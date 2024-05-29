package com.projects.silkroadstudio.ShoppingCart;

import com.projects.silkroadstudio.Product.Product;
import com.projects.silkroadstudio.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    private final ProductService productService;

    public ShoppingCart addProductToCart(Long productId, ShoppingCart shoppingCart) {
        List<Product> listProducts = new ArrayList<>();
        Optional<Product> product = productService.findByIdOptional(productId);
        listProducts.add(product.get());
        shoppingCart.setProducts(listProducts);
        return shoppingCart;
    }

}
