package com.example.mapper;

import com.example.controller.PersonController;
import com.example.domain.Person;
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
public class PersonResourceAssembler extends IdentifiableResourceAssemblerSupport<Person, PersonResource> {

    @Autowired
    private EntityLinks entityLinks;

    /**
     * Creates a new {@link ResourceAssemblerSupport} using the given controller class and resource type.
     */
    public PersonResourceAssembler() {
        super(PersonController.class, PersonResource.class);
    }

    @Override
    public PersonResource toResource(Person entity) {
        PersonResource resource = createResource(entity);
        resource.setName(entity.getName());
        resource.setAge(entity.getAge());
        resource.add(entityLinks.linkFor(PersonResource.class).slash(entity).slash("orders").withRel("orders"));
        return resource;
    }
}
