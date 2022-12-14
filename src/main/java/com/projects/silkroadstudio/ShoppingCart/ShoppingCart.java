package com.projects.silkroadstudio.ShoppingCart;

import com.projects.silkroadstudio.Customer.Customer;
import com.projects.silkroadstudio.Product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "shoppingCart")
    private List<Product> products;

    @OneToOne
    private Customer customer;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart(BigDecimal price, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

}
