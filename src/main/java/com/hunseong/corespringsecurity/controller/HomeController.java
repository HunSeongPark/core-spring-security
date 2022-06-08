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

    private final SetupDataLoader setupDataLoader;

    @GetMapping("/")
    public String home() {
//        setupDataLoader.setupSecurityResources();
        return "home";
    }
}
