package com.zoho.jwtsecurity.controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AuthenticationController {

    // Simulated token storage (in-memory)
    private static final Set<String> VALID_TOKENS = new HashSet<>();

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return Map.of("error", "Missing Authorization header");
        }

        String base64 = authHeader.substring(6);
        String decoded = new String(Base64.getDecoder().decode(base64));
        String[] parts = decoded.split(":", 2);
        String username = parts[0];
        String password = parts[1];

        if (!"user".equals(username) || !"pwd".equals(password)) {
            return Map.of("error", "Invalid credentials");
        }

        String token = "mock-token-" + username + "-" + System.currentTimeMillis();
        VALID_TOKENS.add(token);
        return Map.of("token", token);
    }

    @GetMapping("/countries")
    public Object getCountries(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return Map.of("error", "Missing Bearer token");
        }

        String token = authHeader.substring(7);
        if (!VALID_TOKENS.contains(token)) {
            return Map.of("error", "Unauthorized");
        }

        return List.of(
                Map.of("code", "IN", "name", "India"),
                Map.of("code", "US", "name", "United States"),
                Map.of("code", "JP", "name", "Japan")
        );
    }
}
