package com.hunseong.corespringsecurity.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class MessageController {

    @GetMapping("/messages")
    public String message() {
        return "user/messages";
    }
}
