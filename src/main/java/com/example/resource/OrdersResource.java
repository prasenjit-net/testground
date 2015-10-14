package com.example.resource;

import com.example.controller.OrderController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
public class OrdersResource extends ResourceSupport {
    @Getter
    @Setter
    private List<OrderResource> orders;

    public OrdersResource(List<OrderResource> orders) {
        this.orders = orders;
        add(linkTo(methodOn(OrderController.class).getAll()).withSelfRel());
    }
}
