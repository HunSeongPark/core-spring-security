package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by Hunseong on 2022/06/05
 */
public interface UserRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

    @Query("select a from Account a join fetch a.userRoles where a.username = :username")
    Optional<Account> findByUsernameFetchJoin(@Param("username") String username);

    @Query("select a from Account a join fetch a.userRoles where a.id = :id")
    Optional<Account> findByIdFetchJoin(@Param("id") Long id);
}
