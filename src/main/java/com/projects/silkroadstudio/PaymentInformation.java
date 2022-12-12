package com.projects.silkroadstudio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private long id;

    private String cardNumber;

    private LocalDate expiringDate;

    private Integer securityCode;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiringDate(LocalDate expiringDate) {
        this.expiringDate = expiringDate;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public PaymentInformation(String cardNumber, LocalDate expiringDate, Integer securityCode) {
        this.cardNumber = cardNumber;
        this.expiringDate = expiringDate;
        this.securityCode = securityCode;
    }
}
