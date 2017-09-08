package com.gnanesh.spring.boot.exercise.repository;

import com.gnanesh.spring.boot.exercise.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gnanesh Arva
 * @since 06 Sep 2017 at 20:38
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);

}
