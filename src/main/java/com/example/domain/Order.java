package com.example.domain;

import lombok.Data;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by PRASENJIT on 10/15/2015.
 */
@Data
@Entity
@Table(name = "ORDER_T")
public class Order implements Identifiable<Long>{
    @Id
    private Long orderId;
    private String orderName;
    @ManyToOne
    private Person person;

    @Override
    public Long getId() {
        return orderId;
    }
}
