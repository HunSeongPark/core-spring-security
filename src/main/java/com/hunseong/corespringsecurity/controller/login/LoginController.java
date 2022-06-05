package com.hunseong.corespringsecurity.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "user/login/login";
    }
}
