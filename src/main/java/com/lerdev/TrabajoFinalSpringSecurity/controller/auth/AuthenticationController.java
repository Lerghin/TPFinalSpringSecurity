package com.lerdev.TrabajoFinalSpringSecurity.controller.auth;

import com.lerdev.TrabajoFinalSpringSecurity.dto.AuthLoginRequestDTO;
import com.lerdev.TrabajoFinalSpringSecurity.service.imp.UserDetailsServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthLoginRequestDTO userRequest) {
        return new ResponseEntity<>(this.userDetailsServiceImp.loginUser(userRequest), HttpStatus.OK);
    }

}
