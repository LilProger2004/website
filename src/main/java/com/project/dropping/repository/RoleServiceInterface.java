package com.project.dropping.repository;

import com.project.dropping.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleServiceInterface extends CrudRepository<Role,Long> {
}
