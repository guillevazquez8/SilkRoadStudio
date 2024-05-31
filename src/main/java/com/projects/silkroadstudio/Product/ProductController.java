package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/material/{material}")
    public List<Product> getAllByMaterial(@PathVariable String material) throws IncorrectInformationProvidedException {
        return productService.getAllByMaterial(material.toUpperCase());
    }
}
