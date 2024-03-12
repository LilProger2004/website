package com.project.dropping.repo;

import com.project.dropping.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryServiceInterface extends CrudRepository<Category,Long> {
}
