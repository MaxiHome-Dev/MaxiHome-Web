// src/main/java/com/maxihome/maxihome/config/DataLoader.java
package com.maxihome.maxihome.config;

import com.maxihome.maxihome.model.Role;
import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.RoleRepository;
import com.maxihome.maxihome.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(
            RoleRepository roleRepo,
            UsuarioRepository userRepo,
            PasswordEncoder encoder
    ) {
        return args -> {
            // 1) crear roles si no existen
            if (roleRepo.findByName("ROLE_USER").isEmpty()) {
                Role user = new Role();
                user.setName("ROLE_USER");
                roleRepo.save(user);
            }
            if (roleRepo.findByName("ROLE_ADMIN").isEmpty()) {
                Role adminR = new Role();
                adminR.setName("ROLE_ADMIN");
                roleRepo.save(adminR);
            }

            // 2) crear usuario admin con contraseña 'Admin123'
            String adminEmail = "admin@maxihome.com";
            if (userRepo.findByEmail(adminEmail).isEmpty()) {
                Usuario admin = new Usuario();
                admin.setNombre("Administrador");
                admin.setEmail(adminEmail);
                admin.setPassword(encoder.encode("Admin123"));
                Role adminRole = roleRepo.findByName("ROLE_ADMIN").get();
                admin.setRoles(Set.of(adminRole));
                userRepo.save(admin);
                System.out.println(">> Usuario ADMIN creado: " + adminEmail + " / Admin123");
            }
        };
    }
}
