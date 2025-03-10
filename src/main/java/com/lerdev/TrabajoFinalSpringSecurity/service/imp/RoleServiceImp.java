package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.model.Role;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IRoleRepository;
import com.lerdev.TrabajoFinalSpringSecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public List<Role> getAll() {
        return  roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }



    @Override
    public Role save(Role role) {
     return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
     roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }
}
