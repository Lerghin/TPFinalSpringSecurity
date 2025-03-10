package com.lerdev.TrabajoFinalSpringSecurity.controller;

import com.lerdev.TrabajoFinalSpringSecurity.model.Permission;
import com.lerdev.TrabajoFinalSpringSecurity.model.Role;
import com.lerdev.TrabajoFinalSpringSecurity.service.PermissionService;
import com.lerdev.TrabajoFinalSpringSecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/role")

public class RoleRestController {

    @Autowired
    private RoleService roleService;


    @Autowired
    private PermissionService permissionService;


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Role> findAll(){
        return roleService.getAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Set<Permission> permiList = new HashSet<Permission>();
        Permission readPermission;

        // Recuperar la Permission/s por su ID
        for (Permission per : role.getPermissionsList()) {
            readPermission = permissionService.findById(per.getId()).orElseThrow();
            if (readPermission != null) {
                //si encuentro, guardo en la lista
                permiList.add(readPermission);
            }
        }

        role.setPermissionsList(permiList);
        Role newRole = roleService.save(role);
        return ResponseEntity.ok(newRole);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        Optional<Role> roleOptional = roleService.findById(id);
        if (roleOptional.isPresent()) {
            Role updatedRole = roleOptional.get();
            updatedRole.setRole(role.getRole());
            updatedRole.setPermissionsList(role.getPermissionsList());
            roleService.save(updatedRole);
            return ResponseEntity.ok(updatedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
