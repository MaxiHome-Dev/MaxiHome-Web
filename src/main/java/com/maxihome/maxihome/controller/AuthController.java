// src/main/java/com/maxihome/maxihome/controller/AuthController.java
package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Role;
import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.RoleRepository;
import com.maxihome.maxihome.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Set;

@Controller
public class AuthController {

    private final UsuarioRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    public AuthController(UsuarioRepository userRepo,
                          RoleRepository roleRepo,
                          PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String procesarRegistro(
            @ModelAttribute("usuario") @Valid Usuario usuario,
            BindingResult result,
            Model model
    ) {
        if (userRepo.findByEmail(usuario.getEmail()).isPresent()) {
            result.rejectValue("email", "error.usuario", "Ya existe un usuario con ese correo");
        }
        if (result.hasErrors()) {
            return "registro";
        }
        // Cifrar contraseña
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        // Asignar rol USER por defecto
        Role userRole = roleRepo.findByName("ROLE_USER")
                .orElseThrow();
        usuario.setRoles(Set.of(userRole));
        userRepo.save(usuario);
        return "redirect:/iniciar-sesion?registered";
    }

    @GetMapping("/iniciar-sesion")
    public String mostrarLogin(
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "registered", required = false) String reg,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "updated", required = false) String updated,
            @RequestParam(value = "passwordChanged", required = false) String pwdChanged,
            @RequestParam(value = "timeout", required = false) String timeout,
            Model model) {

        if (logout != null) {
            model.addAttribute("msg", "Has cerrado sesión correctamente.");
        }
        if (reg != null) {
            model.addAttribute("msg", "Registro exitoso. Por favor, inicia sesión.");
        }
        if (error != null) {
            model.addAttribute("error", "Correo o contraseña inválidos.");
        }
        if (updated != null) {
            model.addAttribute("msg", "Perfil actualizado. Inicia sesión con tu nuevo correo.");
        }
        if (pwdChanged != null) {
            model.addAttribute("msg", "Contraseña cambiada. Inicia sesión con tu nueva contraseña.");
        }
        if (timeout != null) {
            model.addAttribute("error", "Tu sesión expiró por inactividad.");
        }

        return "iniciarSesion";
    }

}
