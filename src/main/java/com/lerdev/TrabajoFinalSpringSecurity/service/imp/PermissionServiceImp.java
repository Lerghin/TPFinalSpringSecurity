package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.model.Permission;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IPermissionRepository;
import com.lerdev.TrabajoFinalSpringSecurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImp  implements PermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;
    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();

    }

    @Override
    public Optional<Permission> findById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    public Permission findByName(String permissionName) {
        return permissionRepository.findByPermissionName(permissionName);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }


    @Override
    public void delete(Long id) {
    permissionRepository.deleteById(id);
    }

    @Override
    public Permission update(Permission permission) {
        return permissionRepository.save(permission);
    }
}
