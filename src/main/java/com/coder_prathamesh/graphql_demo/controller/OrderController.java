package com.coder_prathamesh.graphql_demo.controller;

import com.coder_prathamesh.graphql_demo.entities.Order;
import com.coder_prathamesh.graphql_demo.entities.User;
import com.coder_prathamesh.graphql_demo.service.OrderService;
import com.coder_prathamesh.graphql_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @MutationMapping
    public Order createOrder(
            @Argument String orderDetails,
            @Argument String orderAddress,
            @Argument Double orderAmount,
            @Argument Long user_id
    ) {
        User user = userService.getUser(user_id);
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setOrderAddress(orderAddress);
        order.setOrderAmount(orderAmount);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrderById(@Argument Long order_id) {
        return orderService.getOrderById(order_id);
    }

    /*@MutationMapping
    public Order updateOrder(
            @Argument Long orderId,
            @Argument String orderDetails,
            @Argument String orderAddress,
            @Argument Double orderAmount
    ) {
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setOrderAddress(orderAddress);
        order.setOrderAmount(orderAmount);
        return orderService.updateOrder(orderId, order);
    }    */

    @MutationMapping
    public Boolean deleteOrder(@Argument Long order_id) {
        return orderService.deleteOrder(order_id);
    }



}