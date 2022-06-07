package com.hunseong.corespringsecurity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/07
 */
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String admin() {
        return "admin/home";
    }
}
