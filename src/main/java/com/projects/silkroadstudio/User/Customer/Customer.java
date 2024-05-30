package com.projects.silkroadstudio.User.Customer;

import com.projects.silkroadstudio.User.Customer.Address.Address;
import com.projects.silkroadstudio.User.Role.ERole;
import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.User.Customer.PaymentInformation.PaymentInformation;
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

    @Override
    public void setRole(Role role) throws IncorrectInformationProvidedException {
        if (role.getRole() != ERole.ROLE_CUSTOMER) {
            throw new IncorrectInformationProvidedException("Customer user must have customer role");
        }
        super.setRole(role);
    }

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth)
            throws IncorrectInformationProvidedException {
        super(name, surname, email, password);
        super.setRole(role);
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth, Address shippingAddress)
            throws IncorrectInformationProvidedException {
        this(name, surname, email, password, role, dateOfBirth);
        this.shippingAddress = shippingAddress;
    }

    public Customer(String name, String surname, String email, String password, Role role, LocalDate dateOfBirth, Address shippingAddress, Address billingAddress, PaymentInformation paymentInformation)
            throws IncorrectInformationProvidedException {
        this(name, surname, email, password, role, dateOfBirth, shippingAddress);
        this.billingAddress = billingAddress;
        this.paymentInformation = paymentInformation;
    }

}
