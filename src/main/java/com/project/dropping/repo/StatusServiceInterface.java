package com.project.dropping.repo;

import com.project.dropping.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusServiceInterface extends CrudRepository<Status,Long> {
}
