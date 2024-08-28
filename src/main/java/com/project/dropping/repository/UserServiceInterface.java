package com.project.dropping.repository;

import com.project.dropping.model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceInterface extends CrudRepository<Buyer,Long> {
}
