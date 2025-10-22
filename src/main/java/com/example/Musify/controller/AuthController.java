package com.example.Musify.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;


@RestController
public class AuthController {


@GetMapping("/api/public/hello")
public Map<String, String> hello() {
return Map.of("message", "Backend is running. Use /oauth2/authorization/google to login.");
}


@GetMapping("/api/auth/me")
public Object getUser(@AuthenticationPrincipal OAuth2User principal) {
if (principal == null) {
return Map.of("error", "Not authenticated");
}
return Map.of(
"name", principal.getAttribute("name"),
"email", principal.getAttribute("email"),
"picture", principal.getAttribute("picture"),
"providerId", principal.getAttribute("sub")
);
}
}