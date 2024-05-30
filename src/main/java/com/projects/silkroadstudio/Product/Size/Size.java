package com.projects.silkroadstudio.Product.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    private Integer length;

    @Setter
    private Integer width;

    public Size(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Size{" + length +
                " x " + width + "}";
    }

}
