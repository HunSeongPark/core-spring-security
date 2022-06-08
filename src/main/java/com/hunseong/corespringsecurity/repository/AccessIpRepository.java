package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.AccessIp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/08
 */
public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {
    Optional<AccessIp> findByIpAddress(String ipAddress);
}
