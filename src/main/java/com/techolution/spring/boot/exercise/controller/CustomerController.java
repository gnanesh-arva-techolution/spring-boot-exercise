package com.techolution.spring.boot.exercise.controller;

import com.techolution.spring.boot.exercise.domain.Customer;
import com.techolution.spring.boot.exercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gnanesh Arva
 * @since 06 Sep 2017 at 20:35
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer post(@RequestBody Customer customer) {
        customer = customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping
    public Customer put(@RequestBody Customer customer) {
        customer = customerService.saveCustomer(customer);
        return customer;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping(value = "/email/")
    public Customer getCustomerByEmailId(@RequestParam String email) {
        return customerService.findCustomerByEmail(email);
    }

    @GetMapping(value = "/test")
    public Customer test() {
        return new Customer();
    }
}
