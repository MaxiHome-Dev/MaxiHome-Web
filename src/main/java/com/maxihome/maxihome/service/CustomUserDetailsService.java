// src/main/java/com/maxihome/maxihome/service/CustomUserDetailsService.java
package com.maxihome.maxihome.service;

import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repo;
    public CustomUserDetailsService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
