package com.project.wb.repo;

import com.project.wb.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductServiceInterface extends CrudRepository<Product,Long> {
}
