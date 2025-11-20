package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Sugerencia;
import com.maxihome.maxihome.repository.SugerenciaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sugerencias")
public class SugerenciaController {

    private final SugerenciaRepository repo;

    public SugerenciaController(SugerenciaRepository repo) {
        this.repo = repo;
    }

    /**
     * 1) Mostrar formulario de envío público
     */
    @GetMapping
    public String mostrarFormulario(Model model) {
        if (!model.containsAttribute("sugerencia")) {
            model.addAttribute("sugerencia", new Sugerencia());
        }
        return "sugerencias";
    }

    /**
     * 2) POST: valida y guarda
     */
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("sugerencia") Sugerencia sugerencia,
            BindingResult result,
            RedirectAttributes attrs
    ) {
        if (result.hasErrors()) {
            // Si hay errores, vuelve a mostrar el formulario con los mensajes
            return "sugerencias";
        }
        repo.save(sugerencia);
        // flash para mensaje de éxito en /gracias
        attrs.addFlashAttribute("msgSugerencia", "¡Tu sugerencia se ha guardado correctamente!");
        return "redirect:/gracias?origen=sugerencia";
    }

    // Dentro de SugerenciaController
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public String listarAdmin(Model model) {
        model.addAttribute("listaSugerencias", repo.findAll());
        model.addAttribute("sugerencia", new Sugerencia());
        return "sugerencias-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/sugerencias/listar";
    }

}
