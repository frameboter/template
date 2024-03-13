package com.frameboter.template.rest;
import com.frameboter.rest.AbstractResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PingResource extends AbstractResource {

    @PostMapping("/ping")
    void createPing(@AuthenticationPrincipal Jwt jwt) {

        List<String> roles = (List<String>) jwt.getClaimAsMap("realm_access").getOrDefault("roles", new ArrayList());
        String role = roles.get(0);
    }
}
