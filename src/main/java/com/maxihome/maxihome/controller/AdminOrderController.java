package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.model.Order;
import com.maxihome.maxihome.repository.OrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/pedidos")
@PreAuthorize("hasRole('ADMIN')")
public class AdminOrderController {

    private final OrderRepository orderRepo;

    public AdminOrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    // 1) Listar todos los pedidos
    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", orderRepo.findAllByOrderByCreatedAtDesc());
        return "pedidos-list";
    }

    // 2) Ver detalle de un pedido concreto
    @GetMapping("/ver/{id}")
    public String verPedido(@PathVariable Long id, Model model) {
        Order pedido = orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido inválido: " + id));
        model.addAttribute("pedido", pedido);
        return "pedido-detalle";
    }

    // 3) (Opcional) Borrar un pedido
    @GetMapping("/borrar/{id}")
    public String borrarPedido(@PathVariable Long id, RedirectAttributes attrs) {
        orderRepo.deleteById(id);
        attrs.addFlashAttribute("success", "Pedido eliminado correctamente.");
        return "redirect:/admin/pedidos";
    }
}
