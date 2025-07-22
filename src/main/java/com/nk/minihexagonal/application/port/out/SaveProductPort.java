package com.nk.minihexagonal.application.port.out;

import com.nk.minihexagonal.domain.model.Product;

// create and update
public interface SaveProductPort {
    Product save(Product product);
}
