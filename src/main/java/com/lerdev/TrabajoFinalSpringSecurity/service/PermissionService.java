package com.lerdev.TrabajoFinalSpringSecurity.service;

import com.lerdev.TrabajoFinalSpringSecurity.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    List<Permission> getAll();
    Optional<Permission> findById(Long id);
   Permission save(Permission permission);
    Permission findByName(String name);

    void delete(Long id);
    Permission update(Permission permission);


}
