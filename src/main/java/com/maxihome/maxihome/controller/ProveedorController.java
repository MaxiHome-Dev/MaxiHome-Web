package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Proveedor;
import com.maxihome.maxihome.repository.ProveedorRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
@PreAuthorize("hasRole('ADMIN')")
public class ProveedorController {

    private final ProveedorRepository proveedorRepo;

    public ProveedorController(ProveedorRepository proveedorRepo) {
        this.proveedorRepo = proveedorRepo;
    }

    // 1) Lista todos los proveedores y prepara un objeto vacío para el modal
    @GetMapping
    public String listarProveedores(Model model) {
        model.addAttribute("listaProveedores", proveedorRepo.findAll());
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores";      // Thymeleaf: proveedores.html
    }

    // 2) Guarda o actualiza un proveedor (viene del form en el modal)
    @PostMapping("/guardar")
    public String guardarOActualizarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorRepo.save(proveedor);
        return "redirect:/proveedores";
    }

    // 3) Borra un proveedor y redirige de vuelta al listado
    @GetMapping("/borrar/{id}")
    public String eliminarProveedor(@PathVariable("id") Integer id) {
        proveedorRepo.deleteById(id);
        return "redirect:/proveedores";
    }

}
