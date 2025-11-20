// src/main/java/com/maxihome/maxihome/controller/ProfileController.java
package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/perfil")
public class ProfileController {

    private final UsuarioRepository userRepo;
    private final PasswordEncoder encoder;

    public ProfileController(UsuarioRepository userRepo,
                             PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder  = encoder;
    }

    /** Mostrar formulario de perfil */
    @GetMapping
    public String showProfile(@AuthenticationPrincipal Usuario usuario,
                              Model model) {
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    /** Procesar actualización de nombre/email */
    @PostMapping
    public String updateProfile(@AuthenticationPrincipal Usuario currentUser,
                                @ModelAttribute("usuario") Usuario formUser,
                                HttpServletRequest request) {
        // Cargar usuario de BD
        Usuario u = userRepo.findById(currentUser.getId()).orElseThrow();
        u.setNombre(formUser.getNombre());
        u.setEmail(formUser.getEmail());
        userRepo.save(u);

        // Invalidate session para que ingrese con nuevo correo
        request.getSession().invalidate();
        return "redirect:/iniciar-sesion?updated";
    }

    /** Mostrar formulario de cambio de contraseña */
    @GetMapping("/password")
    public String showPasswordForm() {
        return "cambiarPassword";
    }

    /** Procesar cambio de contraseña */
    @PostMapping("/password")
    public String changePassword(@AuthenticationPrincipal Usuario currentUser,
                                 @RequestParam String currentPassword,
                                 @RequestParam String newPassword,
                                 RedirectAttributes attrs,
                                 HttpServletRequest request) {
        Usuario u = userRepo.findById(currentUser.getId()).orElseThrow();

        if (!encoder.matches(currentPassword, u.getPassword())) {
            attrs.addFlashAttribute("errorPwd", "La contraseña actual no coincide.");
            return "redirect:/perfil/password";
        }

        u.setPassword(encoder.encode(newPassword));
        userRepo.save(u);

        // Invalidate session
        request.getSession().invalidate();
        return "redirect:/iniciar-sesion?passwordChanged";
    }
}
