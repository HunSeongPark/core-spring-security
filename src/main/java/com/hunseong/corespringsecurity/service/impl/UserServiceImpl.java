package com.hunseong.corespringsecurity.service.impl;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.domain.Role;
import com.hunseong.corespringsecurity.domain.dto.AccountDto;
import com.hunseong.corespringsecurity.repository.RoleRepository;
import com.hunseong.corespringsecurity.repository.UserRepository;
import com.hunseong.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Hunseong on 2022/06/05
 */
@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(Account account) {
        Role role = roleRepository.findByRoleName("ROLE_USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setUserRoles(roles);
        userRepository.save(account);
    }

    @Override
    public void modifyUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);

        if(accountDto.getRoles() != null){
            Set<Role> roles = new HashSet<>();
            accountDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role).get();
                roles.add(r);
            });
            account.setUserRoles(roles);
        }

        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        userRepository.save(account);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Account> getUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDto getUser(Long id) {
        Account account = userRepository.findByIdFetchJoin(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        ModelMapper modelMapper = new ModelMapper();
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);

        List<String> roles = account.getUserRoles()
                .stream()
                .map(Role::getRoleName).toList();

        accountDto.setRoles(roles);
        return accountDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
