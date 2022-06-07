package com.hunseong.corespringsecurity.controller.user;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.domain.dto.AccountDto;
import com.hunseong.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }
}
