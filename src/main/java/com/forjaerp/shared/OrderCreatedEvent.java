package com.forjaerp.shared;

public class OrderCreatedEvent {
    private Long orderId;
    private String customerName;

    public OrderCreatedEvent(Long orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public Long getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
}