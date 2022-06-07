package com.hunseong.corespringsecurity.service;

import com.hunseong.corespringsecurity.domain.Role;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/07
 */
public interface RoleService {
    Role getRole(long id);
    List<Role> getRoles();
    void createRole(Role role);
    void deleteRole(long id);
}
