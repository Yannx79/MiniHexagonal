package com.nk.minihexagonal.infrastructure.web;

import com.nk.minihexagonal.application.port.in.*;
import com.nk.minihexagonal.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductByIdUseCase getProductByIdUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductByIdUseCase getProductByIdUseCase, GetAllProductsUseCase getAllProductsUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(createProductUseCase.create(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>  getById(@PathVariable Long id) {
        return ResponseEntity.ok(getProductByIdUseCase.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(getAllProductsUseCase.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(updateProductUseCase.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        deleteProductUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

}
