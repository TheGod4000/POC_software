package com.forjaerp.sales;

import com.forjaerp.shared.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final ApplicationEventPublisher eventPublisher;

    public OrderController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    // Comunicación Síncrona (REST) para recibir la orden [cite: 136]
    @PostMapping
    public String createOrder(@RequestParam String customer) {
        Long newOrderId = System.currentTimeMillis();
        System.out.println("[VENTAS]: Orden #" + newOrderId + " creada para " + customer);

        // Comunicación Asíncrona: Publicar evento "fuego y olvido" [cite: 137]
        OrderCreatedEvent event = new OrderCreatedEvent(newOrderId, customer);
        eventPublisher.publishEvent(event);

        return "Orden creada. El sistema procesará la producción en segundo plano.";
    }
}