package com.nk.minihexagonal.application.port.in;

import com.nk.minihexagonal.domain.model.Product;

public interface CreateProductUseCase {
    Product create(Product product);
}
