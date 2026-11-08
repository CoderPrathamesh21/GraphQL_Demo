package com.coder_prathamesh.graphql_demo.repo;

import com.coder_prathamesh.graphql_demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
