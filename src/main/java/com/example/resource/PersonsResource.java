package com.example.resource;

import com.example.controller.PersonController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
public class PersonsResource extends ResourceSupport {
    @Getter
    @Setter
    private List<PersonResource> persons;

    public PersonsResource(List<PersonResource> persons) {
        this.persons = persons;
        add(linkTo(methodOn(PersonController.class).getAll()).withSelfRel());
    }
}
