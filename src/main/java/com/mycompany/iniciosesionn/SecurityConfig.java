package com.mycompany.iniciosesion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // desactivar CSRF solo para pruebas
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // permitir todas las rutas
            );
        return http.build();
    }
}
