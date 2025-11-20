// src/main/java/com/maxihome/maxihome/controller/ProductoController.java
package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.CategoriaProducto;
import com.maxihome.maxihome.model.Producto;
import com.maxihome.maxihome.repository.CategoriaProductoRepository;
import com.maxihome.maxihome.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoRepository productoRepo;
    private final CategoriaProductoRepository categoriaRepo;

    public ProductoController(ProductoRepository productoRepo,
                              CategoriaProductoRepository categoriaRepo) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
    }

    @GetMapping("/productos")
    public String listarProductos(
            @RequestParam(value = "categoria", required = false) Integer categoriaId,
            Model model
    ) {
        List<CategoriaProducto> categorias = categoriaRepo.findAll();
        List<Producto> productos;

        if (categoriaId != null) {
            productos = productoRepo.findByCategoriaId(categoriaId);
        } else {
            productos = productoRepo.findAll();
        }

        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        model.addAttribute("categoriaSeleccionada", categoriaId);
        return "productos";
    }
}
