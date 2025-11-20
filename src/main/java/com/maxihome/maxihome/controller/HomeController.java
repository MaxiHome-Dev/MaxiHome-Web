package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.CategoriaProducto;
import com.maxihome.maxihome.model.Marca;
import com.maxihome.maxihome.model.Producto;
import com.maxihome.maxihome.model.Testimonio;
import com.maxihome.maxihome.repository.CategoriaProductoRepository;
import com.maxihome.maxihome.repository.MarcaRepository;
import com.maxihome.maxihome.repository.ProductoRepository;
import com.maxihome.maxihome.repository.TestimonioRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.domain.Sort;

@Controller
public class HomeController {

    private final CategoriaProductoRepository categoriaRepo;
    private final ProductoRepository productoRepo;
    private final TestimonioRepository testimonioRepo;
    private final MarcaRepository marcaRepo;

    public HomeController(CategoriaProductoRepository categoriaRepo,
                          ProductoRepository productoRepo,
                          TestimonioRepository testimonioRepo,
                          MarcaRepository marcaRepo) {
        this.categoriaRepo = categoriaRepo;
        this.productoRepo = productoRepo;
        this.testimonioRepo = testimonioRepo;
        this.marcaRepo = marcaRepo;
    }

    @GetMapping("/")
    public String index(Model model) {

        // 2. Categorías destacadas (p.ej. las primeras 4)
        List<CategoriaProducto> categorias = categoriaRepo.findAll();
        List<CategoriaProducto> categoriasDestacadas = categorias.stream()
                .limit(4)
                .toList();
        model.addAttribute("categoriasDestacadas", categoriasDestacadas);

        // 3. Productos nuevos: top 6 por fecha de creación
        List<Producto> productosNuevos = productoRepo.findTop6ByOrderByCreadoEnDesc();
        model.addAttribute("productosNuevos", productosNuevos);

        // 3. Todos los testimonios ordenados por fecha desc
        List<Testimonio> testimonios = testimonioRepo.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
        model.addAttribute("testimonios", testimonios);

        // 4. Todas las marcas
        List<Marca> marcas = marcaRepo.findAll();

        // Partir en trozos de 5
        List<List<Marca>> marcaChunks = new ArrayList<>();
        for (int i = 0; i < marcas.size(); i += 5) {
            marcaChunks.add(marcas.subList(i, Math.min(i + 5, marcas.size())));
        }
        model.addAttribute("marcaChunks", marcaChunks);

        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/gracias")
    public String mostrarGracias(@RequestParam(name = "origen", required = false) String origen, Model model) {
        String mensaje;
        if ("contacto".equals(origen)) {
            mensaje = "¡Gracias por contactarnos! Responderemos pronto.";
        } else if ("sugerencia".equals(origen)) {
            mensaje = "¡Gracias por tu sugerencia! La tomaremos en cuenta.";
        } else if ("reclamo".equals(origen)) {
            mensaje = "¡Tu reclamo ha sido registrado! Lo evaluaremos con seriedad.";
        } else {
            mensaje = "¡Gracias! Tu mensaje fue recibido.";
        }
        model.addAttribute("mensaje", mensaje);
        return "gracias";
    }

    // ... (otros mappings comentados o eliminados) ...
}
