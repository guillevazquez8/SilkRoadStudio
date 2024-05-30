package com.projects.silkroadstudio.User.Customer.Address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
}
