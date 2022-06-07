package com.hunseong.corespringsecurity.controller.login;

import com.hunseong.corespringsecurity.domain.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Hunseong on 2022/06/05
 */
@Controller
public class LoginController {

    @GetMapping(value = {"/login", "/api/login"})
    public String login(
            @RequestParam(value = "error", required = false) boolean error,
            @RequestParam(value = "exception", required = false) String exception,
            Model model
    ) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // authentication 객체가 존재할 시 로그아웃 처리
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login";
    }

    @GetMapping(value = {"/denied", "/api/denied"})
    public String denied(
            @RequestParam(value = "exception", required = false) String exception,
            Model model
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) authentication.getPrincipal();
        model.addAttribute("username", account.getUsername());
        model.addAttribute("exception", exception);
        return "user/login/denied";
    }
}
