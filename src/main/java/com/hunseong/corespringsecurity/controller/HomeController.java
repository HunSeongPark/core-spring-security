package com.hunseong.corespringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
