package com.project.wb.repo;

import com.project.wb.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceInreface extends CrudRepository<User,Long> {
}
