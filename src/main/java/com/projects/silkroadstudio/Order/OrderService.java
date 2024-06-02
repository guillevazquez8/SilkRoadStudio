package com.projects.silkroadstudio.Order;

import com.projects.silkroadstudio.Product.Product;
import com.projects.silkroadstudio.Product.ProductService;
import com.projects.silkroadstudio.User.Customer.CustomerService;
import com.projects.silkroadstudio.User.Customer.PaymentInformation.PaymentInformation;
import com.projects.silkroadstudio.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CustomerService customerService;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order addProductToOrder(Long productId, Order order) {
        // 1. add product to carts products list
        List<Product> listProducts = order.getProducts();
        Product product = productService.findByIdOptional(productId).get();
        listProducts.add(product);
        order.setProducts(listProducts);
        // 2. increment carts total price
        BigDecimal productPrice = product.getPrice();
        order.setPrice(order.getPrice().add(productPrice));
        return order;
    }

    public Order confirmOrder(Order order) {
        // 1. get payment information from customer
        PaymentInformation paymentInfo = order.getCustomer().getPaymentInformation();
        if (paymentInfo == null) {
            throw new BadRequestException("You need to provide payment information to order a product");
        }
        // send transaction request to corresponding bank with card info, receive confirmation
        order.setConfirmed(true);
        customerService.saveOrder(order);
        return order;
    }

}
