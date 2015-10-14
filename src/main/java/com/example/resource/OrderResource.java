package com.example.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by PRASENJIT on 10/14/2015.
 */
public class OrderResource extends ResourceSupport {
    @Getter
    @Setter
    private Long orderId;
    @Getter
    @Setter
    private String orderName;
}
