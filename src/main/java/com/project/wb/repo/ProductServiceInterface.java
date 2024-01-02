package com.project.wb.repo;

import com.project.wb.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductServiceInterface extends CrudRepository<Product,Long> {
}
