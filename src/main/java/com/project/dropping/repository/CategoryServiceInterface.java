package com.project.dropping.repository;

import com.project.dropping.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryServiceInterface extends CrudRepository<Category,Long> {
}
