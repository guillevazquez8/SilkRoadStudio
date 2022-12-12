package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

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
    private Address address;

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth)
            throws IncorrectInformationProvidedException {
        super(name, surname, email, password, role);
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth,
                    PaymentInformation paymentInformation, Address address) throws IncorrectInformationProvidedException {
        super(name, surname, email, password, role);
        this.dateOfBirth = dateOfBirth;
        this.paymentInformation = paymentInformation;
        this.address = address;
    }

}
