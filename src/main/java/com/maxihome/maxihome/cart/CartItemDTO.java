package com.maxihome.maxihome.cart;

public class CartItemDTO {
    private Integer productId;
    private String productName;
    private int quantity;
    private double price;

    public CartItemDTO() {}

    public CartItemDTO(Integer productId, String productName, int quantity, double price) {
        this.productId   = productId;
        this.productName = productName;
        this.quantity    = quantity;
        this.price       = price;
    }
    // getters y setters...
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
