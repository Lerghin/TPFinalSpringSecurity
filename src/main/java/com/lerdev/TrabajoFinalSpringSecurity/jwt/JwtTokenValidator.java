package com.lerdev.TrabajoFinalSpringSecurity.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.http.HttpHeaders;
import java.io.IOException;

import java.util.Collection;

public class JwtTokenValidator  extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;


    public JwtTokenValidator(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
       String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);
       if(jwtToken != null) {
           jwtToken = jwtToken.substring(7);
           DecodedJWT decodedJWT = jwtUtils.validateToken(jwtToken);
           String username = jwtUtils.extractUsername(decodedJWT);
           String authorities = jwtUtils.getSpecificClaim(decodedJWT, "authorities").asString();
           Collection authoritiesList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
           SecurityContext context = SecurityContextHolder.getContext();
           Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authoritiesList);
           context.setAuthentication(authentication);
           SecurityContextHolder.setContext(context);
       }
         filterChain.doFilter(request,response);
    }




}
