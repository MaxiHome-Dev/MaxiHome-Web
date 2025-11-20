package com.maxihome.maxihome.controller;

import com.maxihome.maxihome.cart.CartItemDTO;
import com.maxihome.maxihome.cart.ShoppingCartDTO;
import com.maxihome.maxihome.cart.ShoppingCart;
import com.maxihome.maxihome.model.Producto;
import com.maxihome.maxihome.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {

    private final ShoppingCart cart;
    private final ProductoRepository productoRepo;

    public CartRestController(ShoppingCart cart,
                              ProductoRepository productoRepo) {
        this.cart         = cart;
        this.productoRepo = productoRepo;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<ShoppingCartDTO> add(@PathVariable Integer id) {
        Producto prod = productoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        cart.add(prod);
        return ResponseEntity.ok(toDto());
    }

    @GetMapping
    public ResponseEntity<ShoppingCartDTO> getCart() {
        return ResponseEntity.ok(toDto());
    }

    private ShoppingCartDTO toDto() {
        var items = cart.getItems().stream()
                .map(ci -> new CartItemDTO(
                        ci.getProduct().getId(),
                        ci.getProduct().getNombre(),
                        ci.getQuantity(),
                        ci.getProduct().getPrecio()
                ))
                .collect(Collectors.toList());
        return new ShoppingCartDTO(
                items,
                cart.getTotalItems(),
                cart.getTotal()
        );
    }
}
