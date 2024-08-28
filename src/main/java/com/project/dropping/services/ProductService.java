package com.project.dropping.services;

import com.project.dropping.model.Product;

import java.util.List;

public interface ProductService {
   Product findById(Long id);
   List<Product> findAll();
}
