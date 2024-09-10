package com.project.dropping.services.impliments;

import com.project.dropping.model.Role;
import com.project.dropping.repository.RoleRepository;
import com.project.dropping.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImplements implements RoleService {

    final RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findById(1L).orElseThrow();
    }
}
