package com.projects.silkroadstudio.Cushion;

import com.projects.silkroadstudio.Product.Colour;
import com.projects.silkroadstudio.Product.Product;
import com.projects.silkroadstudio.Product.Size.Size;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cushion extends Product {

    public Cushion(String material, BigDecimal price, Colour colour, Size size) {
        super(material, price, colour, size);
    }

}
