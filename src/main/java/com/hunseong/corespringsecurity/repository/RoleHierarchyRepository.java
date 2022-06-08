package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.RoleHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/08
 */
public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {
    Optional<RoleHierarchy> findByChildName(String roleName);
}
