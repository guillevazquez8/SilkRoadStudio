package com.projects.silkroadstudio.User.Customer;

import com.projects.silkroadstudio.Order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Order> saveOrder(Order order) {
        Customer customer = order.getCustomer();
        List<Order> newOrderList = customer.getMyOrders();
        newOrderList.add(order);
        customer.setMyOrders(newOrderList);
        return newOrderList;
    }

    public List<Order> getAllOrdersByCustomer(Long customerId) {
        return customerRepository.getAllOrdersByCustomer(customerId);
    }

}
