package com.hunseong.corespringsecurity.service;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.domain.dto.AccountDto;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/05
 */
public interface UserService {

    void createUser(Account account);
    void modifyUser(AccountDto accountDto);
    List<Account> getUsers();
    AccountDto getUser(Long id);
    void deleteUser(Long id);
}
