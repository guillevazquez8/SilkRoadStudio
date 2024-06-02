package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Tag(name = "Product", description = "API to get products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/material/{material}")
    public List<Product> getAllByMaterial(@PathVariable String material) throws IncorrectInformationProvidedException {
        return productService.getAllByMaterial(material.toUpperCase());
    }
}
