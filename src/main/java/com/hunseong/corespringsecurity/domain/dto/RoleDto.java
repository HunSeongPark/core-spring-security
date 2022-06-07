package com.hunseong.corespringsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Hunseong on 2022/06/07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto{

    private String id;
    private String roleName;
    private String roleDesc;

}
