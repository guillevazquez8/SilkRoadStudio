package com.projects.silkroadstudio.Order;

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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private BigDecimal price;

    private LocalDate deliveryDate;

    @OneToMany(mappedBy = "order")
    @Setter
    private List<Product> products;

    @ManyToOne
    @Setter
    private Customer customer;

    @Setter
    private Boolean confirmed;

    public void setDeliveryDate() {
        // it takes 3 days to deliver
        this.deliveryDate = LocalDate.now().plusDays(3L);
    }

    public Order(BigDecimal price, List<Product> products, Customer customer) {
        this.price = price;
        setDeliveryDate();
        this.products = products;
        this.customer = customer;
        setConfirmed(false);
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
