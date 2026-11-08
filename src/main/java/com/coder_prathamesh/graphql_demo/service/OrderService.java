package com.coder_prathamesh.graphql_demo.service;

import com.coder_prathamesh.graphql_demo.entities.Order;
import com.coder_prathamesh.graphql_demo.helper.ExceptionHandler;
import com.coder_prathamesh.graphql_demo.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    //create order
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    //get single order
    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
    }

    //get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    //update order
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        existingOrder.setOrderDetails(order.getOrderDetails());
        existingOrder.setOrderAddress(order.getOrderAddress());
        existingOrder.setOrderAmount(order.getOrderAmount());
        return orderRepo.save(existingOrder);
    }

    //delete order
    public Boolean deleteOrder(Long id) {
        Order existingOrder = orderRepo.findById(id)
                .orElseThrow(ExceptionHandler::throwResourceNotFoundException);
        orderRepo.delete(existingOrder);
        return true;
    }
}
