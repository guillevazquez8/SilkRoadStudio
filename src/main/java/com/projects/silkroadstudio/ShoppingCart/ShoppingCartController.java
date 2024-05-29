package com.projects.silkroadstudio.ShoppingCart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shopping_cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
}
