package com.example.controller;

import com.example.domain.Person;
import com.example.mapper.OrderResourceAssembler;
import com.example.mapper.PersonResourceAssembler;
import com.example.repository.PersonRepository;
import com.example.resource.OrderResource;
import com.example.resource.PersonResource;
import com.example.resource.PersonsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by PRASENJIT on 10/14/2015.
 */
@RestController
@RequestMapping("/person")
@ExposesResourceFor(PersonResource.class)
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonResourceAssembler personResourceAssembler;
    @Autowired
    private OrderResourceAssembler orderResourceAssembler;

    @RequestMapping
    public PersonsResource getAll() {
        List<Person> persons = personRepository.findAll();
        return new PersonsResource(personResourceAssembler.toResources(persons));
    }

    @RequestMapping("/{id}")
    public PersonResource view(@PathVariable String id) {
        Person person = personRepository.findOne(id);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping("/{id}/orders")
    public List<OrderResource> orders(@PathVariable String id) {
        Person person = personRepository.findOne(id);
        return orderResourceAssembler.toResources(person.getOrders());
    }
}
