package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<Product> findByIdOptional(Long id) {
        return productRepository.findById(id);
    }

    public Product findById(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new BadRequestException("Introduced product id does not exist");
        }
        return productRepository.findById(id).get();
    }

}
