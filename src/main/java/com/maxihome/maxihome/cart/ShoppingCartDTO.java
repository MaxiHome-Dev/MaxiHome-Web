package com.maxihome.maxihome.cart;

import java.util.List;

public class ShoppingCartDTO {
    private List<CartItemDTO> items;
    private int totalItems;
    private double total;

    public ShoppingCartDTO() {}

    public ShoppingCartDTO(List<CartItemDTO> items, int totalItems, double total) {
        this.items      = items;
        this.totalItems = totalItems;
        this.total      = total;
    }
    // getters y setters...
    public List<CartItemDTO> getItems() { return items; }
    public void setItems(List<CartItemDTO> items) { this.items = items; }
    public int getTotalItems() { return totalItems; }
    public void setTotalItems(int totalItems) { this.totalItems = totalItems; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
