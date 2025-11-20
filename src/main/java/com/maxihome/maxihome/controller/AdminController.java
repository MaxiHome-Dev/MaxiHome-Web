// src/main/java/com/maxihome/maxihome/controller/AdminController.java
package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.UsuarioRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UsuarioRepository userRepo;

    public AdminController(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("usuarios", userRepo.findAll());
        return "adminUsers";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(
            @PathVariable Long id,
            @AuthenticationPrincipal Usuario currentUser,
            RedirectAttributes attrs) {

        // Evitar que el admin se borre a sí mismo
        if (currentUser.getId().equals(id)) {
            attrs.addFlashAttribute("errorAdmin", "No puedes eliminar tu propia cuenta.");
        } else {
            userRepo.deleteById(id);
            attrs.addFlashAttribute("msgAdmin", "Usuario eliminado correctamente.");
        }
        return "redirect:/admin/users";
    }
}
