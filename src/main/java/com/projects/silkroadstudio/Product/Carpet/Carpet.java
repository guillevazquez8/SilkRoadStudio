package com.projects.silkroadstudio.Product.Carpet;

import com.projects.silkroadstudio.Product.Colour;
import com.projects.silkroadstudio.Product.Material;
import com.projects.silkroadstudio.Product.Product;
import com.projects.silkroadstudio.Product.Size.Size;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Carpet extends Product {

    public Carpet(Material material, BigDecimal price, Colour colour, Size size) {
        super(material, price, colour, size);
    }

}
