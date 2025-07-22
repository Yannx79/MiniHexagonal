package com.nk.minihexagonal.infrastructure.config;

import com.nk.minihexagonal.application.port.out.DeleteProductPort;
import com.nk.minihexagonal.application.port.out.LoadAllProductsPort;
import com.nk.minihexagonal.application.port.out.LoadProductPort;
import com.nk.minihexagonal.application.port.out.SaveProductPort;
import com.nk.minihexagonal.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProductService productService(SaveProductPort save, LoadProductPort load, DeleteProductPort delete, LoadAllProductsPort loadAll) {
        return new ProductService(save, load, delete, loadAll);
    }

}
