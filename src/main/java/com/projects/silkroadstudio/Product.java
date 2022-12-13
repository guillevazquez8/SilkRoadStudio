package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    private String material;

    private BigDecimal price;

    @Enumerated(value = EnumType.STRING)
    private Colour colour;

    @ManyToOne
    private Size size;

    @ManyToOne
    private ShoppingCart shoppingCart;

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product(String material, BigDecimal price, Colour colour, Size size) {
        this.material = material;
        this.price = price;
        this.colour = colour;
        this.size = size;
    }

}
