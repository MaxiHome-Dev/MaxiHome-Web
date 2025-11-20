package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.cart.ShoppingCart;
import com.maxihome.maxihome.model.Producto;
import com.maxihome.maxihome.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final ShoppingCart cart;
    private final ProductoRepository productoRepo;

    public CartController(ShoppingCart cart,
                          ProductoRepository productoRepo) {
        this.cart = cart;
        this.productoRepo = productoRepo;
    }

    /**
     * Añade un producto al carrito (o incrementa su cantidad).
     */
    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id) {
        Producto prod = productoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        cart.add(prod);
        return "redirect:/cart";
    }

    /**
     * Muestra el contenido del carrito.
     */
    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("items", cart.getItems());
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    /**
     * Actualiza la cantidad de un ítem del carrito.
     */
    @PostMapping("/update")
    public String updateQuantity(
            @RequestParam("productId") Integer productId,
            @RequestParam("qty") int qty) {
        cart.update(productId, qty);
        return "redirect:/cart";
    }

    /**
     * Elimina un ítem del carrito.
     */
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart";
    }
}
