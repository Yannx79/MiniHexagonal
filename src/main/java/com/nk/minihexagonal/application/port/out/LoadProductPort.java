package com.nk.minihexagonal.application.port.out;

import com.nk.minihexagonal.domain.model.Product;

import java.util.Optional;

public interface LoadProductPort {
    Optional<Product> loadById(Long id);
}
