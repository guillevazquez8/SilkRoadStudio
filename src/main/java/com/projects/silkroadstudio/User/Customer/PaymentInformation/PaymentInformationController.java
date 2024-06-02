package com.projects.silkroadstudio.User.Customer.PaymentInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment_information")
public class PaymentInformationController {

    private final PaymentInformationService paymentInformationService;

    @PostMapping
    public PaymentInformation createPaymentInformation(@RequestBody PaymentInformation paymentInformation) {
        return paymentInformationService.save(paymentInformation);
    }

}
