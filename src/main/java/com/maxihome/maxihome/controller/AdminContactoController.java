package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Contacto;
import com.maxihome.maxihome.repository.ContactoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/contactos")
@PreAuthorize("hasRole('ADMIN')")
public class AdminContactoController {

    private final ContactoRepository contactoRepo;

    public AdminContactoController(ContactoRepository contactoRepo) {
        this.contactoRepo = contactoRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaContactos", contactoRepo.findAll());
        return "contactos-list";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Integer id) {
        contactoRepo.deleteById(id);
        return "redirect:/admin/contactos";
    }
}
