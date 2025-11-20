package com.maxihome.maxihome.cart;

import com.maxihome.maxihome.model.Producto;

/**
 * Representa un ítem en el carrito: el producto y la cantidad deseada.
 */
public class CartItem {
    private Producto product;
    private int quantity;

    public CartItem(Producto product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
