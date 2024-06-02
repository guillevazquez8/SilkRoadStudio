package com.projects.silkroadstudio.User.Customer.PaymentInformation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment_information")
@Tag(name = "Payment Information", description = "API to enter payment information")
public class PaymentInformationController {

    private final PaymentInformationService paymentInformationService;

    @PostMapping
    public PaymentInformation createPaymentInformation(@RequestBody PaymentInformation paymentInformation) {
        return paymentInformationService.save(paymentInformation);
    }

}
