package com.projects.silkroadstudio.Customer;

import com.projects.silkroadstudio.Customer.Address.Address;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.Customer.PaymentInformation.PaymentInformation;
import com.projects.silkroadstudio.User.Role.Role;
import com.projects.silkroadstudio.User.User;
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

    public Customer(String name, String surname, String email, String password, LocalDate dateOfBirth)
            throws IncorrectInformationProvidedException {
        super(name, surname, email, password);
        super.setRole(new Role(ERole.ROLE_CUSTOMER));
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String name, String surname, String email, String password, LocalDate dateOfBirth, Address shippingAddress)
            throws IncorrectInformationProvidedException {
        this(name, surname, email, password, dateOfBirth);
        this.shippingAddress = shippingAddress;
    }

    public Customer(String name, String surname, String email, String password, LocalDate dateOfBirth, Address shippingAddress, Address billingAddress, PaymentInformation paymentInformation)
            throws IncorrectInformationProvidedException {
        this(name, surname, email, password, dateOfBirth, shippingAddress);
        this.billingAddress = billingAddress;
        this.paymentInformation = paymentInformation;
    }

}
