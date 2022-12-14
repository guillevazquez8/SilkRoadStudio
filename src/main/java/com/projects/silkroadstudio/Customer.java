package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends User {

    private LocalDate dateOfBirth;

    @OneToOne
    private PaymentInformation paymentInformation;

    @ManyToOne
    private Address shippingAddress;

    @ManyToOne
    private Address billingAddress;

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth)
            throws IncorrectInformationProvidedException {
        super(name, surname, email, password, role);
        this.dateOfBirth = dateOfBirth;
    }

}
