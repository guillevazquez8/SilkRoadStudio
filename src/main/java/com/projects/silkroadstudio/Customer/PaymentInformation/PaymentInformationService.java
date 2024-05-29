package com.projects.silkroadstudio.Customer.PaymentInformation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentInformationService {
    private final PaymentInformationRepository paymentInformationRepository;
}
