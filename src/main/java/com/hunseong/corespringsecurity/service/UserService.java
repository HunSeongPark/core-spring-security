package com.hunseong.corespringsecurity.service;

import com.hunseong.corespringsecurity.domain.Account;

/**
 * Created by Hunseong on 2022/06/05
 */
public interface UserService {

    void createUser(Account account);
}
