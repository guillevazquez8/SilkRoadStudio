package com.projects.silkroadstudio;

import com.projects.silkroadstudio.Order.Order;
import com.projects.silkroadstudio.Order.OrderService;
import com.projects.silkroadstudio.Product.Carpet.Carpet;
import com.projects.silkroadstudio.Product.Colour;
import com.projects.silkroadstudio.Product.Cushion.Cushion;
import com.projects.silkroadstudio.Product.Material;
import com.projects.silkroadstudio.Product.Product;
import com.projects.silkroadstudio.Product.ProductRepository;
import com.projects.silkroadstudio.Product.Size.Size;
import com.projects.silkroadstudio.Product.Size.SizeRepository;
import com.projects.silkroadstudio.User.Customer.Address.Address;
import com.projects.silkroadstudio.User.Customer.Address.AddressRepository;
import com.projects.silkroadstudio.User.Customer.Customer;
import com.projects.silkroadstudio.User.Customer.CustomerRepository;
import com.projects.silkroadstudio.User.Customer.PaymentInformation.PaymentInformation;
import com.projects.silkroadstudio.User.Customer.PaymentInformation.PaymentInformationRepository;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.Role.RoleRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private PaymentInformationRepository paymentInformationRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
        productRepository.deleteAll();
        roleRepository.deleteAll();
        addressRepository.deleteAll();
        paymentInformationRepository.deleteAll();
        sizeRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void testCreateOrder() {
        Size size1 = new Size(100, 50);
        sizeRepository.save(size1);
        Cushion cushion = new Cushion(Material.WOOL, new BigDecimal(1000), Colour.BEIGE, size1);
        productRepository.save(cushion);
        Carpet carpet = new Carpet(Material.SILK, new BigDecimal(500), Colour.WHITE, size1);
        productRepository.save(carpet);
        PaymentInformation paymentInfo = new PaymentInformation("1234", LocalDate.parse("2026-01-23"), 1234);
        paymentInformationRepository.save(paymentInfo);
        Address address = new Address("Rua Canido", "Vigo", 1234, "Spain");
        addressRepository.save(address);
        Role customerRole = new Role(ERole.ROLE_CUSTOMER);
        roleRepository.save(customerRole);
        Customer customer = new Customer("Guille", "TusMuerto", "guille@email.com", "12345678910", customerRole, LocalDate.parse("1995-09-28"), address, address, paymentInfo);
        customerRepository.save(customer);
        List<Product> products = Arrays.asList(cushion, carpet);
        Order order = new Order(products, customer);

        Order savedOrder = orderService.save(order);
        assertEquals(savedOrder.getPrice(), cushion.getPrice().add(carpet.getPrice()));
    }
}
