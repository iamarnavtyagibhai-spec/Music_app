package com.example.Musify.config;


import com.example.Musify.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {


private final UserService userService;


public OAuth2LoginSuccessHandler(UserService userService) {
this.userService = userService;
}


@Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
if (authentication instanceof OAuth2AuthenticationToken token) {
OAuth2User user = token.getPrincipal();
Map<String, Object> attributes = user.getAttributes();


String provider = token.getAuthorizedClientRegistrationId();
String providerId = (String) attributes.get("sub");
String email = (String) attributes.get("email");
String name = (String) attributes.get("name");
String picture = (String) attributes.get("picture");


userService.upsert(provider, providerId, email, name, picture);
}


response.sendRedirect("/api/auth/me");
}
}