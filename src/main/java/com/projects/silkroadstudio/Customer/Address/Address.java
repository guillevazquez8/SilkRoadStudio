package com.projects.silkroadstudio.Customer.Address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter
    private String street;

    @Setter
    private String city;

    @Setter
    private Integer postcode;

    @Setter
    private String country;

    public Address(String street, String city, Integer postcode, String country) {
        this.street = street;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
    }

}
