package com.coder_prathamesh.graphql_demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String orderDetails;
    private String orderAddress;
    private Double orderAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
