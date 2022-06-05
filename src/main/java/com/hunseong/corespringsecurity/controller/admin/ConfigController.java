package com.hunseong.corespringsecurity.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class ConfigController {

    @GetMapping("/config")
    public String config() {
        return "admin/config";
    }
}
