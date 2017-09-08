package com.techolution.spring.boot.exercise;

import com.techolution.spring.boot.exercise.domain.Customer;
import com.techolution.spring.boot.exercise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootExerciseApplication {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExerciseApplication.class, args);
    }

    @PostConstruct
    public void addCustomers() {
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer();
            customer.setEmail("abcd_" + i + "@abcd.abcd");
            customer.setFirstName("first_name_" + i);
            customer.setLastName("last_name_" + i);
            customerRepository.save(customer);
            System.out.println("After saving customer. ID : " + customer.getId());
        }
    }

}
