package com.example.repository;

import com.example.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
