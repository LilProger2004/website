package com.project.dropping.repo;

import com.project.dropping.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceInterface extends CrudRepository<User,Long> {
}
