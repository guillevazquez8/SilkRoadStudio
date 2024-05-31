package com.projects.silkroadstudio;

import com.projects.silkroadstudio.Product.*;
import com.projects.silkroadstudio.Product.Blanket.Blanket;
import com.projects.silkroadstudio.Product.Carpet.Carpet;
import com.projects.silkroadstudio.Product.Cushion.Cushion;
import com.projects.silkroadstudio.Product.Size.Size;
import com.projects.silkroadstudio.Product.Size.SizeRepository;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.User.Role.Role;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();

        Size size1 = new Size(100, 50);
        sizeRepository.save(size1);
        Cushion cushion1 = new Cushion(Material.SILK, new BigDecimal(50), Colour.BLACK, size1);
        productRepository.save(cushion1);
        Blanket blanket1 = new Blanket(Material.SILK, new BigDecimal(100), Colour.BEIGE, size1);
        productRepository.save(blanket1);
        Carpet carpet1 = new Carpet(Material.LEATHER, new BigDecimal(1000), Colour.WHITE, size1);
        productRepository.save(blanket1);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
        sizeRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void testGetProductByMaterial() {
        List<Product> products = productService.getAllByMaterial("silk");
        assertEquals(products.size(), 2);
    }


}
