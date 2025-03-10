package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.dto.AuthLoginRequestDTO;
import com.lerdev.TrabajoFinalSpringSecurity.dto.AuthResponseDTO;
import com.lerdev.TrabajoFinalSpringSecurity.jwt.JwtUtils;
import com.lerdev.TrabajoFinalSpringSecurity.model.UserSec;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

@Autowired
private JwtUtils jwtUtils;
@Autowired
private IUserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSec userSec= userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("User Not Found with username: " + username));

        List<SimpleGrantedAuthority> authorityList= new ArrayList<>();

        userSec.getRolesList()
                .forEach(role-> authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRole())));

        userSec.getRolesList().stream()
                .flatMap(role-> role.getPermissionsList().stream())
                .forEach(permission-> authorityList.add(new SimpleGrantedAuthority(permission.getPermissionName())));

        return new User(userSec.getUsername(),
                userSec.getPassword(),
                userSec.isEnabled(),
                userSec.isAccountNonExpired(),
                userSec.isCredentialsNonExpired(),
                userSec.isAccountNonLocked(),
                 authorityList);

    }


    public AuthResponseDTO loginUser (AuthLoginRequestDTO authLoginRequest){

        //recuperamos nombre de usuario y contraseña
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate (username, password);
        //si todo sale bien
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtils.createToken(authentication);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(username, "login ok", accessToken, true);
        return authResponseDTO;

    }


    public Authentication authenticate(String username, String password){
        UserDetails userDetails= loadUserByUsername(username);
        if(userDetails== null){
            throw  new BadCredentialsException("Invalid username or password");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }






}
