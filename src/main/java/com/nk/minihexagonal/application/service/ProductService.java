package com.nk.minihexagonal.application.service;

import com.nk.minihexagonal.application.port.in.*;
import com.nk.minihexagonal.application.port.out.DeleteProductPort;
import com.nk.minihexagonal.application.port.out.LoadAllProductsPort;
import com.nk.minihexagonal.application.port.out.LoadProductPort;
import com.nk.minihexagonal.application.port.out.SaveProductPort;
import com.nk.minihexagonal.domain.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService implements CreateProductUseCase, GetProductByIdUseCase, DeleteProductUseCase, GetAllProductsUseCase, UpdateProductUseCase {

    private final SaveProductPort savePort;
    private final LoadProductPort loadPort;
    private final DeleteProductPort deletePort;
    private final LoadAllProductsPort loadAllPort;

    public ProductService(SaveProductPort savePort, LoadProductPort loadPort, DeleteProductPort deletePort, LoadAllProductsPort loadAllPort) {
        this.savePort = savePort;
        this.loadPort = loadPort;
        this.deletePort = deletePort;
        this.loadAllPort = loadAllPort;
    }

    @Override
    public Product create(Product product) {
        return savePort.save(product);
    }

    @Override
    public Product getById(Long id) {
        return loadPort.loadById(id)
                .orElseThrow(() -> new RuntimeException("No product found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        deletePort.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        return loadAllPort.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> existing = loadPort.loadById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Product not found with ID: " + id);
        }
        product.setId(id); // aseguramos que actualiza el existente
        return savePort.save(product);    }
}
