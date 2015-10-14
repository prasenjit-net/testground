package com.example;

import com.example.domain.Order;
import com.example.domain.Person;
import com.example.repository.OrderRepository;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class TestgroundApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(TestgroundApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Person person1 = createPerson("person1", 10);
        person1 = personRepository.saveAndFlush(person1);
        Person person2 = createPerson("person2", 20);
        person2 = personRepository.saveAndFlush(person2);

        Order order1 = createOrder(1L, "order1");
        order1 = orderRepository.saveAndFlush(order1);
        Order order2 = createOrder(2L, "order2");
        order2 =orderRepository.saveAndFlush(order2);

        order1.setPerson(person1);
        order2.setPerson(person2);
    }

    private Order createOrder(long id, String name) {
        Order order = new Order();
        order.setOrderName(name);
        order.setOrderId(id);
        return order;
    }

    private Person createPerson(String name, int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}
