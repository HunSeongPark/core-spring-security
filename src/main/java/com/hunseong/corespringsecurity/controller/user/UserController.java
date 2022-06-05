package com.hunseong.corespringsecurity.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class UserController {

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }
}
