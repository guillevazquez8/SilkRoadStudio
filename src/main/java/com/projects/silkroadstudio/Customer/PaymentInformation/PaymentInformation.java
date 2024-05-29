package com.projects.silkroadstudio.Customer.PaymentInformation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Setter
    private String cardNumber;

    @Setter
    private LocalDate expiringDate;

    @Setter
    private Integer securityCode;

    public PaymentInformation(String cardNumber, LocalDate expiringDate, Integer securityCode) {
        this.cardNumber = cardNumber;
        this.expiringDate = expiringDate;
        this.securityCode = securityCode;
    }
}
