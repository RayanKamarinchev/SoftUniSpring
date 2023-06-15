package com.example.mvcdemo.repository;

import com.example.mvcdemo.domain.entities.Role;
import com.example.mvcdemo.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleName roleName);

    List<Role> findAll();
}
