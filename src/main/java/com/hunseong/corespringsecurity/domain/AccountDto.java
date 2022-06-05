package com.hunseong.corespringsecurity.domain;

import lombok.Data;

/**
 * Created by Hunseong on 2022/06/05
 */
@Data
public class AccountDto {

    private String username;
    private String password;
    private String email;
    private String age;
    private String role;
}
