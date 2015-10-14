package com.example.mapper;

import com.example.controller.OrderController;
import com.example.domain.Order;
import com.example.resource.OrderResource;
import com.example.resource.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.IdentifiableResourceAssemblerSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
@Component
public class OrderResourceAssembler extends IdentifiableResourceAssemblerSupport<Order, OrderResource> {

    @Autowired
    private EntityLinks entityLinks;

    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public OrderResourceAssembler() {
        super(OrderController.class, OrderResource.class);
    }

    @Override
    public OrderResource toResource(Order entity) {
        OrderResource resource = createResource(entity);
        resource.setOrderName(entity.getOrderName());
        resource.setOrderId(entity.getOrderId());
        resource.add(entityLinks.linkForSingleResource(PersonResource.class, entity.getPerson()).withRel("person"));
        return resource;
    }
}
