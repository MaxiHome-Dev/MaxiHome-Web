package com.maxihome.maxihome.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciona con el pedido padre
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Producto concreto
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Producto product;

    // Cantidad pedida
    @Column(nullable = false)
    private Integer quantity;

    // Precio unitario al momento de la compra
    @Column(nullable = false)
    private Double price;

    // --- Getters y setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
