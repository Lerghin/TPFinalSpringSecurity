package com.lerdev.TrabajoFinalSpringSecurity.repository;

import com.lerdev.TrabajoFinalSpringSecurity.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermissionName(String permissionName);
}
