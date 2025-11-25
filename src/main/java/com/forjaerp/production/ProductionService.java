package com.forjaerp.production;

import com.forjaerp.shared.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProductionService {

    @Async // Simula que este servicio está separado y no bloquea a Ventas
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Simulación de latencia (planificación de BOM, etc.) [cite: 36]
        try {
            System.out.println("[PRODUCCIÓN]: ... Recibido evento de orden #" + event.getOrderId());
            Thread.sleep(3000); // Esperamos 3 segundos simulando trabajo pesado
            System.out.println("[PRODUCCIÓN]: Planificación finalizada para cliente: " + event.getCustomerName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}