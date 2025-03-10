package com.lerdev.TrabajoFinalSpringSecurity.repository;

import com.lerdev.TrabajoFinalSpringSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

}
