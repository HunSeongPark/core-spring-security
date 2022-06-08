package com.hunseong.corespringsecurity.security.voter;

import com.hunseong.corespringsecurity.security.service.SecurityResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by Hunseong on 2022/06/08
 */
@RequiredArgsConstructor
public class IpAddressVoter implements AccessDecisionVoter<Object> {

    private final SecurityResourceService securityResourceService;

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        String address = details.getRemoteAddress();
        List<String> accessIpList = securityResourceService.getAccessIpList();
        for (String ipAddress : accessIpList) {
            if (ipAddress.equals(address)) {
                return ACCESS_ABSTAIN;
            }
        }
        throw new AccessDeniedException("Invalid Ip Address");
    }
}
