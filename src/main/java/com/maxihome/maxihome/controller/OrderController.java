package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.cart.ShoppingCart;
import com.maxihome.maxihome.model.Order;
import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.OrderRepository;
import com.maxihome.maxihome.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepo;
    private final ShoppingCart cart;

    public OrderController(OrderService orderService,
                           OrderRepository orderRepo,
                           ShoppingCart cart) {
        this.orderService = orderService;
        this.orderRepo    = orderRepo;
        this.cart         = cart;
    }

    /** Checkout: solo si hay al menos un ítem, si no vuelve al carrito con error */
    @PostMapping("/cart/checkout")
    public String checkout(
            @AuthenticationPrincipal Usuario user,
            RedirectAttributes attrs) {

        if (cart.getItems().isEmpty()) {
            attrs.addFlashAttribute("errorCart",
                    "El carrito está vacío. Agrega al menos un producto antes de hacer checkout.");
            return "redirect:/cart";
        }

        orderService.checkout(cart, user);
        attrs.addFlashAttribute("msgOrder", "Pedido realizado correctamente.");
        return "redirect:/orders";
    }

    /** Lista los pedidos del usuario */
    @GetMapping("/orders")
    public String myOrders(
            @AuthenticationPrincipal Usuario user,
            Model model,
            @ModelAttribute("msgOrder") String msgOrder,
            @ModelAttribute("errorOrder") String errorOrder
    ) {
        List<Order> orders = orderRepo.findByUsuarioId(user.getId());
        model.addAttribute("orders", orders);
        // los flash attrs msgOrder y errorOrder ya están en el modelo
        return "orders";
    }

    /** Detalle de un pedido */
    @GetMapping("/orders/{id}")
    public String orderDetails(
            @PathVariable Long id,
            @AuthenticationPrincipal Usuario user,
            Model model
    ) {
        Order o = orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + id));
        if (!o.getUsuario().getId().equals(user.getId())) {
            return "redirect:/orders";
        }
        model.addAttribute("order", o);
        return "orderDetails";
    }

    /** Elimina un pedido propio */
    @PostMapping("/orders/delete/{id}")
    public String deleteOrder(
            @PathVariable Long id,
            @AuthenticationPrincipal Usuario user,
            RedirectAttributes attrs) {

        Order o = orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + id));

        if (!o.getUsuario().getId().equals(user.getId())) {
            attrs.addFlashAttribute("errorOrder",
                    "No puedes eliminar un pedido que no es tuyo.");
        } else {
            orderRepo.delete(o);
            attrs.addFlashAttribute("msgOrder", "Pedido eliminado correctamente.");
        }

        return "redirect:/orders";
    }
}
