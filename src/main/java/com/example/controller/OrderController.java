package com.example.controller;

import com.example.mapper.OrderResourceAssembler;
import com.example.repository.OrderRepository;
import com.example.resource.OrderResource;
import com.example.resource.OrdersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PRASENJIT on 10/14/2015.
 */
@RestController
@RequestMapping("/order")
@ExposesResourceFor(OrderResource.class)
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderResourceAssembler orderResourceAssembler;

    @RequestMapping
    public OrdersResource getAll() {
        return new OrdersResource(orderResourceAssembler.toResources(orderRepository.findAll()));
    }

    @RequestMapping("/{id}")
    public OrderResource view(@PathVariable Long id) {
        return orderResourceAssembler.toResource(orderRepository.findOne(id));
    }


}
