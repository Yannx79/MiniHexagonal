package com.nk.minihexagonal.application.port.in;

import com.nk.minihexagonal.domain.model.Product;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Product> getAll();
}
