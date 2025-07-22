package com.nk.minihexagonal.application.port.in;

import com.nk.minihexagonal.domain.model.Product;

public interface GetProductByIdUseCase {
    Product getById(Long id);
}
