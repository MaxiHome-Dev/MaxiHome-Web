package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Contacto;
import com.maxihome.maxihome.repository.ContactoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactoController {

    private final ContactoRepository contactoRepo;

    public ContactoController(ContactoRepository contactoRepo) {
        this.contactoRepo = contactoRepo;
    }

    // formulario público
    @GetMapping("/contacto")
    public String showForm(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto";
    }

    @PostMapping("/contacto")
    public String submitForm(
            @Valid @ModelAttribute("contacto") Contacto contacto,
            BindingResult result,
            RedirectAttributes attrs
    ) {
        if (result.hasErrors()) {
            return "contacto";
        }
        contactoRepo.save(contacto);
        return "redirect:/gracias?origen=contacto";
    }
}
