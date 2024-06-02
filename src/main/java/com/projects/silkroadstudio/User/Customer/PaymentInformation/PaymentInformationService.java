package com.projects.silkroadstudio.User.Customer.PaymentInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentInformationService {

    private final PaymentInformationRepository paymentInformationRepository;

    public PaymentInformation save(PaymentInformation paymentInformation) {
        return paymentInformationRepository.save(paymentInformation);
    }

}
