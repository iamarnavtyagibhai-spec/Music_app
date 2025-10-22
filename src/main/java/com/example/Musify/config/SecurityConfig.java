package com.example.Musify.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {


private final OAuth2LoginSuccessHandler successHandler;


public SecurityConfig(OAuth2LoginSuccessHandler successHandler) {
this.successHandler = successHandler;
}


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http
.csrf(csrf -> csrf.disable())
.authorizeHttpRequests(auth -> auth
.requestMatchers("/", "/api/public/**").permitAll()
.anyRequest().authenticated()
)
.oauth2Login(oauth2 -> oauth2.successHandler(successHandler))
.logout(logout -> logout.logoutSuccessUrl("/api/public/logout-success").permitAll());


return http.build();
}
}