package com.projects.silkroadstudio;

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

    public Carpet(String material, BigDecimal price, Colour colour, Size size) {
        super(material, price, colour, size);
    }

}
