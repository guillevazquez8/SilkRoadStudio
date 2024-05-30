package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.ShoppingCart.ShoppingCart;
import com.projects.silkroadstudio.Product.Size.Size;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String material;

    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Colour colour;

    @ManyToOne
    private Size size;

    @ManyToOne
    private ShoppingCart shoppingCart;

    public Product(String material, BigDecimal price, Colour colour, Size size) {
        this.material = material;
        this.price = price;
        this.colour = colour;
        this.size = size;
    }

}
