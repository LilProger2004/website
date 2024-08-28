package com.project.dropping.services.impliments;

import com.project.dropping.model.Product;
import com.project.dropping.repository.ProductRepository;
import com.project.dropping.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImplement implements ProductService {


    final ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
