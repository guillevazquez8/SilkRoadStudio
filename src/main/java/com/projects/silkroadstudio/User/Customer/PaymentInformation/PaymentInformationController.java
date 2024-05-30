package com.projects.silkroadstudio.User.Customer.PaymentInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment_information")
public class PaymentInformationController {
    private final PaymentInformationService paymentInformationService;
}
