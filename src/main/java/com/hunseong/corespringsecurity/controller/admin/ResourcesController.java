package com.hunseong.corespringsecurity.controller.admin;

import com.hunseong.corespringsecurity.domain.Resources;
import com.hunseong.corespringsecurity.domain.Role;
import com.hunseong.corespringsecurity.domain.dto.ResourcesDto;
import com.hunseong.corespringsecurity.repository.RoleRepository;
import com.hunseong.corespringsecurity.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import com.hunseong.corespringsecurity.service.ResourcesService;
import com.hunseong.corespringsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hunseong on 2022/06/07
 */
@RequiredArgsConstructor
@Controller
public class ResourcesController {

    private final ResourcesService resourcesService;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final UrlFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @GetMapping("/admin/resources")
    public String resources(Model model) {
        List<Resources> resources = resourcesService.getAllResources();
        model.addAttribute("resources", resources);
        return "admin/resources/list";
    }

    @PostMapping("/admin/resources")
    public String createResources(ResourcesDto resourcesDto) {

        Role role = roleRepository.findByRoleName(resourcesDto.getRoleName()).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        ModelMapper modelMapper = new ModelMapper();
        Resources resources = modelMapper.map(resourcesDto, Resources.class);
        resources.setRoleSet(roles);

        resourcesService.createResources(resources);
        filterInvocationSecurityMetadataSource.reload();
        return "redirect:/admin/resources";
    }

    @GetMapping("/admin/resources/register")
    public String viewRoles(Model model) {
        List<Role> roles = roleService.getRoles();
        model.addAttribute("roleList", roles);

        ResourcesDto resources = new ResourcesDto();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role());

        resources.setRoleSet(roleSet);
        model.addAttribute("resources", resources);

        return "admin/resources/detail";
    }

    @GetMapping(value = "/admin/resources/{id}")
    public String getResources(@PathVariable Long id, Model model) {

        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);
        Resources resources = resourcesService.getResources(id);

        ModelMapper modelMapper = new ModelMapper();
        ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);
        model.addAttribute("resources", resourcesDto);

        return "admin/resources/detail";
    }

    @GetMapping(value = "/admin/resources/delete/{id}")
    public String removeResources(@PathVariable Long id) {
        resourcesService.deleteResources(id);
        filterInvocationSecurityMetadataSource.reload();
        return "redirect:/admin/resources";
    }
}
