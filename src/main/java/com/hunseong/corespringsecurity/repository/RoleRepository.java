package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/07
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);
}
