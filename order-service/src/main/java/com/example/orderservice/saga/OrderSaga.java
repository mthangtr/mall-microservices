package com.example.orderservice.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class OrderSaga {

    @Autowired
    private OrderService orderService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public void createOrder(OrderRequest orderRequest) {
        String orderId = UUID.randomUUID().toString();
        try {
            // Step 1: Create Order
            Order order = orderService.createOrder(orderId, orderRequest);
            
            // Step 2: Reserve Inventory
            inventoryService.reserveInventory(orderRequest.getProductId(), orderRequest.getQuantity());
            
            // Step 3: Send Notification
            notificationService.sendOrderConfirmation(order.getUserId(), orderId);
        } catch (Exception e) {
            // Handle rollback and compensation logic
            handleFailure(orderId);
        }
    }

    private void handleFailure(String orderId) {
        // Compensation logic for failed steps
        // e.g., release inventory, notify user, etc.
    }
}