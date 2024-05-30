package com.projects.silkroadstudio.ShoppingCart;

import com.projects.silkroadstudio.User.Customer.Customer;
import com.projects.silkroadstudio.Product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private BigDecimal price;

    @Setter
    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "shoppingCart")
    @Setter
    private List<Product> products;

    @OneToOne
    @Setter
    private Customer customer;

    public ShoppingCart(BigDecimal price, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "price = " + price + ", " +
                "deliveryDate = " + deliveryDate + ", " +
                "customer = " + customer + ")";
    }
}
