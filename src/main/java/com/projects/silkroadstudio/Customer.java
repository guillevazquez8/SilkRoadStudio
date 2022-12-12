package com.projects.silkroadstudio;

import jakarta.persistence.Entity;
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

    private PaymentInformation paymentInformation;

    private Address address;

    public Customer(String name, String surname, String email, String password, Role role) throws IncorrectInformationProvidedException {
        super(name ,surname, email, password, role);

}
