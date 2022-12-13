package com.projects.silkroadstudio;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Blanket extends Product {

    public Blanket(String material, BigDecimal price, Colour colour, Size size) {
        super(material, price, colour, size);
    }

}
