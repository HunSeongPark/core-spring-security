package com.hunseong.corespringsecurity.controller.admin;

import com.hunseong.corespringsecurity.domain.Account;
import com.hunseong.corespringsecurity.domain.Role;
import com.hunseong.corespringsecurity.domain.dto.AccountDto;
import com.hunseong.corespringsecurity.service.RoleService;
import com.hunseong.corespringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/07
 */
@RequiredArgsConstructor
@Controller
public class UserManagerController {

    private final UserService userService;

    private final RoleService roleService;

    @GetMapping(value="/admin/accounts")
    public String getUsers(Model model) {

        List<Account> accounts = userService.getUsers();
        model.addAttribute("accounts", accounts);

        return "admin/user/list";
    }

    @PostMapping(value="/admin/accounts")
    public String modifyUser(AccountDto accountDto) {

        userService.modifyUser(accountDto);

        return "redirect:/admin/accounts";
    }

    @GetMapping(value = "/admin/accounts/{id}")
    public String getUser(@PathVariable(value = "id") Long id, Model model) {

        AccountDto accountDto = userService.getUser(id);
        List<Role> roleList = roleService.getRoles();

        model.addAttribute("account", accountDto);
        model.addAttribute("roleList", roleList);

        return "admin/user/detail";
    }

    @GetMapping(value = "/admin/accounts/delete/{id}")
    public String removeUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
