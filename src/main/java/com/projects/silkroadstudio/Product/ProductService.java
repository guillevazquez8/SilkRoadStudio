package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.exceptions.BadRequestException;
import com.projects.silkroadstudio.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Product> getAllByMaterial(String material) {
        if (productRepository.getAllByMaterial(material).isEmpty()) {
            throw new NotFoundException(String.format("There are no products made out of material %s", material));
        }
        return productRepository.getAllByMaterial(material).get();
    }

}
