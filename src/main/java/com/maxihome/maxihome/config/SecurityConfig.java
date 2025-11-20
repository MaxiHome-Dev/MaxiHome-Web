// src/main/java/com/maxihome/maxihome/config/SecurityConfig.java
package com.maxihome.maxihome.config;

import com.maxihome.maxihome.service.CustomUserDetailsService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService uds;

    public SecurityConfig(CustomUserDetailsService uds) {
        this.uds = uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/css/**", "/js/**", "/img/**",
                                "/iniciar-sesion", "/registro", "/error"
                        ).permitAll()
                        // carrito y pedidos sólo para autenticados
                        .requestMatchers("/cart/**", "/orders/**")
                        .authenticated()
                        // admin solo ROLE_ADMIN
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/iniciar-sesion")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/iniciar-sesion?error") // ← Añadido
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/iniciar-sesion?logout")
                        .permitAll()
                )
                .userDetailsService(uds);
        return http.build();
    }

}
