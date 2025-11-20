package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Reclamacion;
import com.maxihome.maxihome.repository.ReclamacionRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReclamacionController {

    private final ReclamacionRepository repo;

    public ReclamacionController(ReclamacionRepository repo) {
        this.repo = repo;
    }

    /**
     * GET: muestra el formulario vacío
     */
    @GetMapping("/reclamaciones")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reclamacion", new Reclamacion());
        return "reclamaciones";
    }

    /**
     * POST: valida y guarda
     */
    @PostMapping("/reclamaciones")
    public String procesarFormulario(
            @Valid @ModelAttribute("reclamacion") Reclamacion reclamacion,
            BindingResult result,
            RedirectAttributes attrs
    ) {
        if (result.hasErrors()) {
            // vuelves a la misma vista, Thymeleaf rellenará los campos y mostrará errores
            return "reclamaciones";
        }
        repo.save(reclamacion);
        attrs.addFlashAttribute("msgReclamo", "¡Tu reclamo se ha guardado correctamente!");
        return "redirect:/reclamaciones";
    }

    // ——— ADMIN ———
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/reclamaciones")
    public String listar(Model model) {
        model.addAttribute("listaReclamaciones", repo.findAll(Sort.by(Sort.Direction.DESC, "fecha")));
        return "reclamaciones-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/reclamaciones/borrar/{id}")
    public String borrar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/admin/reclamaciones";
    }
}
