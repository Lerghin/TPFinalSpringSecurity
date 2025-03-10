package com.lerdev.TrabajoFinalSpringSecurity.controller;

import com.lerdev.TrabajoFinalSpringSecurity.model.Role;
import com.lerdev.TrabajoFinalSpringSecurity.model.UserSec;
import com.lerdev.TrabajoFinalSpringSecurity.service.RoleService;
import com.lerdev.TrabajoFinalSpringSecurity.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/user")

public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserSec>> getAllUsers() {
        List<UserSec> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserSec> getUserById(@PathVariable Long id) {
        Optional <UserSec> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UserSec> createUser(@RequestBody UserSec userSec) {
       Set<Role> roleList = new HashSet<Role>();
       Role readRole;
       userSec.setPassword(userService.encriptPassword(userSec.getPassword()));
         for (Role role : userSec.getRolesList()){
              readRole = roleService.findById(role.getId()).orElseThrow(null);
              if (readRole != null){
                roleList.add(readRole);
              }
         }
         if(!roleList.isEmpty()){
             userSec.setRolesList(roleList);
             UserSec newUser = userService.save(userSec);
             return ResponseEntity.ok(newUser);
         }
         return ResponseEntity.badRequest().build();

    }

}
