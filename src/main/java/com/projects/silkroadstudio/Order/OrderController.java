package com.projects.silkroadstudio.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PatchMapping("/{productId}")
    public Order addProductToOrder(@PathVariable Long productId, @RequestBody Order order) {
        return orderService.addProductToOrder(productId, order);
    }

    @PatchMapping("/confirm")
    public Order confirmOrder(@RequestBody Order order) {
        return orderService.confirmOrder(order);
    }

}
