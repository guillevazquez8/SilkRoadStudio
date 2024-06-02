package com.projects.silkroadstudio.User.Customer;

import com.projects.silkroadstudio.Order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/my_orders/{customerId}")
    public List<Order> getAllOrdersByCustomer(@PathVariable Long customerId) {
        return customerService.getAllOrdersByCustomer(customerId);
    }

}
