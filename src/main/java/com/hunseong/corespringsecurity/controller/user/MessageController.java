package com.hunseong.corespringsecurity.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/api/messages")
    public ResponseEntity<String> apiMessage() {
        return ResponseEntity.ok("message_ok");
    }
}
