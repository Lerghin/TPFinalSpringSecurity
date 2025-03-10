package com.lerdev.TrabajoFinalSpringSecurity.service;

import com.lerdev.TrabajoFinalSpringSecurity.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAll();
    Optional<Role> findById(Long id);

    Role save(Role role);
    void delete(Long id);
    Role update(Role role);
}
