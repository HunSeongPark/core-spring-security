package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/06/05
 */
public interface UserRepository extends JpaRepository<Account, Long> {
}
