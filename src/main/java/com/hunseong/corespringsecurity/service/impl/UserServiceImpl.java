package com.hunseong.corespringsecurity.service.impl;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.repository.UserRepository;
import com.hunseong.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hunseong on 2022/06/05
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(Account account) {
        userRepository.save(account);
    }
}
