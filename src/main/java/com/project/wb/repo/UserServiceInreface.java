package com.project.wb.repo;

import com.project.wb.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserServiceInreface extends CrudRepository<User,Long> {
}
