package com.projects.silkroadstudio.Customer;

import com.projects.silkroadstudio.Carpet.CarpetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
}
