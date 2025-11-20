package com.maxihome.maxihome.service;

import com.maxihome.maxihome.cart.ShoppingCart;
import com.maxihome.maxihome.model.Order;
import com.maxihome.maxihome.model.OrderItem;
import com.maxihome.maxihome.model.Usuario;
import com.maxihome.maxihome.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    /**
     * Crea un pedido a partir del carrito y lo persiste.
     * Al final, vacía el carrito.
     */
    @Transactional
    public void checkout(ShoppingCart cart, Usuario user) {
        Order o = new Order();
        o.setUsuario(user);
        // quitamos o.setCreatedAt(...) porque el campo ya se inicializa en la entidad
        o.setTotal(cart.getTotal());

        // Construimos la lista de OrderItem a partir de los CartItem
        var items = cart.getItems().stream()
                .map(ci -> {
                    OrderItem oi = new OrderItem();
                    oi.setOrder(o);
                    oi.setProduct(ci.getProduct());
                    oi.setQuantity(ci.getQuantity());
                    oi.setPrice(ci.getProduct().getPrecio());
                    return oi;
                })
                .collect(Collectors.toList());

        o.setItems(items);
        orderRepo.save(o);

        // Limpia el carrito tras guardar el pedido
        cart.clear();
    }
}
