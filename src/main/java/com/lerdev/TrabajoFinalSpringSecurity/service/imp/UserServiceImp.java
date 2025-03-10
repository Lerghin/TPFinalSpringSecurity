package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.model.UserSec;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IUserRepository;
import com.lerdev.TrabajoFinalSpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<UserSec> getAll() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<UserSec> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserSec> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserSec save(UserSec user) {
     return userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
      userRepository.deleteById(id);
    }

    @Override
    public UserSec update(UserSec user) {
        return userRepository.save(user);
    }

    @Override
    public String encriptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
