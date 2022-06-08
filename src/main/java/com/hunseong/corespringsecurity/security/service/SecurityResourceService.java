package com.hunseong.corespringsecurity.security.service;

import com.hunseong.corespringsecurity.domain.AccessIp;
import com.hunseong.corespringsecurity.domain.Resources;
import com.hunseong.corespringsecurity.repository.AccessIpRepository;
import com.hunseong.corespringsecurity.repository.ResourcesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hunseong on 2022/06/07
 */
@Service
@RequiredArgsConstructor
public class SecurityResourceService {

    private final ResourcesRepository resourcesRepository;
    private final AccessIpRepository accessIpRepository;

    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourcesRepository.findAllByType("url");
        resourcesList.forEach(r -> {
            List<ConfigAttribute> configAttributes = new ArrayList<>();
            r.getRoleSet().forEach(role -> {
                configAttributes.add(new SecurityConfig(role.getRoleName()));
            });
            result.put(new AntPathRequestMatcher(r.getResourceName()), configAttributes);
        });
        return result;
    }

    public List<String> getAccessIpList() {
        return accessIpRepository.findAll().stream()
                .map(AccessIp::getIpAddress).collect(Collectors.toList());
    }
}
