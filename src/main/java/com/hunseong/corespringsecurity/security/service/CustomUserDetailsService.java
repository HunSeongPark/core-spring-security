package com.hunseong.corespringsecurity.security.service;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.domain.Role;
import com.hunseong.corespringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hunseong on 2022/06/05
 */
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userRepository.findByUsernameFetchJoin(username)
                .orElseThrow(() -> new UsernameNotFoundException("UsernameNotfoundException"));

        List<SimpleGrantedAuthority> roles =
                account.getUserRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                .collect(Collectors.toList());
        return new AccountContext(account, roles);
    }
}
