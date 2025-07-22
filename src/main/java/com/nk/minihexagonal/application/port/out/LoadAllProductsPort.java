package com.nk.minihexagonal.application.port.out;

import com.nk.minihexagonal.domain.model.Product;

import java.util.List;

public interface LoadAllProductsPort {
    List<Product> findAll();
}
