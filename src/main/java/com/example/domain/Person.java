package com.example.domain;

import lombok.Data;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
@Data
@Entity
@Table(name = "PERSON_T")
public class Person implements Identifiable<String> {
    @Id
    private String name;
    private int age;
    @OneToMany(mappedBy = "person")
    private List<Order> orders;

    @Override
    public String getId() {
        return name;
    }
}
