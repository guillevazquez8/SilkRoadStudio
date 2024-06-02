package com.projects.silkroadstudio.Product;

import com.projects.silkroadstudio.exceptions.BadRequestException;
import com.projects.silkroadstudio.exceptions.IncorrectInformationProvidedException;
import com.projects.silkroadstudio.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    public List<Product> getAllByMaterial(String material) throws IncorrectInformationProvidedException {
        List<String> materials = Stream.of(Material.values())
                .map(Material::name)
                .toList();
        if (!materials.contains(material)) {
            throw new IncorrectInformationProvidedException(String.format("Material $s is not valid", material));
        }
        // assign random value to initialize variable
        Material material_enum = Material.SILK;
        for (String each_material : materials) {
            if (material.equals(each_material)) {
                material_enum = Material.valueOf(each_material);
            }
        }
        if (productRepository.getAllByMaterial(material_enum).isEmpty()) {
            throw new NotFoundException(String.format("There are no products made out of material %s", material));
        }
        return productRepository.getAllByMaterial(material_enum).get();
    }

}
