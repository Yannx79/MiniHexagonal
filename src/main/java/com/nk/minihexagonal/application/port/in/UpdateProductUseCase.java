package com.nk.minihexagonal.application.port.in;

import com.nk.minihexagonal.domain.model.Product;

public interface UpdateProductUseCase {
    Product update(Long id, Product product);
}
