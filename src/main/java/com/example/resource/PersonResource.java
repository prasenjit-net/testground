package com.example.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by PRASENJIT on 10/14/2015.
 */
public class PersonResource extends ResourceSupport {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
}
