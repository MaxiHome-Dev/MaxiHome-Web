package com.maxihome.maxihome.cart;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean de sesión que almacena el carrito de un usuario.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    // Cambiado a Integer porque Producto.getId() es Integer
    private final Map<Integer, CartItem> items = new HashMap<>();

    /**
     * Añade un producto al carrito. Si ya existía, incrementa la cantidad en 1.
     */
    public void add(com.maxihome.maxihome.model.Producto product) {
        Integer productId = product.getId();
        CartItem ci = items.get(productId);
        if (ci == null) {
            items.put(productId, new CartItem(product, 1));
        } else {
            ci.setQuantity(ci.getQuantity() + 1);
        }
    }

    /**
     * Elimina por completo el ítem correspondiente al productId.
     */
    public void remove(Integer productId) {
        items.remove(productId);
    }

    /**
     * Actualiza la cantidad de un ítem. Si qty <= 0, lo elimina.
     */
    public void update(Integer productId, int qty) {
        if (qty <= 0) {
            remove(productId);
        } else {
            CartItem ci = items.get(productId);
            if (ci != null) {
                ci.setQuantity(qty);
            }
        }
    }

    /**
     * Devuelve todos los ítems actualmente en el carrito.
     */
    public Collection<CartItem> getItems() {
        return items.values();
    }

    /**
     * Número total de unidades en el carrito.
     */
    public int getTotalItems() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    /**
     * Suma total: sum(prod.precio * cantidad).
     */
    public double getTotal() {
        return items.values().stream()
                .mapToDouble(ci -> ci.getProduct().getPrecio() * ci.getQuantity())
                .sum();
    }

    /**
     * Vacía todo el carrito.
     */
    public void clear() {
        items.clear();
    }
}
