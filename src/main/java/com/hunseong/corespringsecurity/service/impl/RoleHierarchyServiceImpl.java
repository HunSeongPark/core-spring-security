package com.hunseong.corespringsecurity.service.impl;

import com.hunseong.corespringsecurity.domain.RoleHierarchy;
import com.hunseong.corespringsecurity.repository.RoleHierarchyRepository;
import com.hunseong.corespringsecurity.service.RoleHierarchyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/08
 */
@Transactional
@RequiredArgsConstructor
@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    private final RoleHierarchyRepository roleHierarchyRepository;

    @Override
    public String findAllHierarchy() {
        List<RoleHierarchy> roleHierarchies = roleHierarchyRepository.findAll();
        StringBuilder concatedRole = new StringBuilder();
        for (RoleHierarchy roleHierarchy : roleHierarchies) {
            if (roleHierarchy.getParentName() != null) {
                concatedRole.append(roleHierarchy.getParentName().getChildName());
                concatedRole.append(" > ");
                concatedRole.append(roleHierarchy.getChildName());
                concatedRole.append("/n");
            }
        }
        return concatedRole.toString();
    }
}
