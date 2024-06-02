package com.projects.silkroadstudio.User.Customer;

import com.projects.silkroadstudio.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c.myOrders from Customer c where c.id = ?1")
    List<Order> getAllOrdersByCustomer(Long customerId);
}
