package com.hunseong.corespringsecurity.service.impl;

import com.hunseong.corespringsecurity.domain.Role;
import com.hunseong.corespringsecurity.repository.RoleRepository;
import com.hunseong.corespringsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/07
 */
@Transactional
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public Role getRole(long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("role not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepository.deleteById(id);
    }
}
