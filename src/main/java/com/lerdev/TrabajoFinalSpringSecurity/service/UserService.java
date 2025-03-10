package com.lerdev.TrabajoFinalSpringSecurity.service;

import com.lerdev.TrabajoFinalSpringSecurity.model.UserSec;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserSec> getAll();
    Optional<UserSec> findById(Long id);
   Optional<UserSec > findByUsername(String username);
    UserSec save(UserSec user);
    void delete(Long id);
    UserSec update(UserSec user);
    public String encriptPassword(String password);
}
