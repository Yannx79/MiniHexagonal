package com.nk.minihexagonal.infrastructure.persistence;

import com.nk.minihexagonal.application.port.out.DeleteProductPort;
import com.nk.minihexagonal.application.port.out.LoadAllProductsPort;
import com.nk.minihexagonal.application.port.out.LoadProductPort;
import com.nk.minihexagonal.application.port.out.SaveProductPort;
import com.nk.minihexagonal.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceAdapter implements SaveProductPort, LoadProductPort, DeleteProductPort, LoadAllProductsPort {

    private final JpaProductRepository repository;

    public ProductPersistenceAdapter(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> loadById(Long id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = toEntity(product);
        ProductEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        return entity;
    }

    private Product toDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        return product;
    }
}
