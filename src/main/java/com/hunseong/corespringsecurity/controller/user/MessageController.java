package com.hunseong.corespringsecurity.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class MessageController {

    @GetMapping("/messages")
    public String message() {
        return "user/messages";
    }

    @ResponseBody
    @GetMapping("/api/messages")
    public String apiMessage() {
        return "messages_ok";
    }
}
