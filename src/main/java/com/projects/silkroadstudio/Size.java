package com.projects.silkroadstudio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer length;

    private Integer width;

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Size(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Size{" + length +
                " x " + width + '}';
    }

}
