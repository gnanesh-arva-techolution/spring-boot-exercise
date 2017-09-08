package com.gnanesh.spring.boot.exercise;

import com.gnanesh.spring.boot.exercise.controller.CustomerController;
import com.gnanesh.spring.boot.exercise.service.CustomerService;
import com.gnanesh.spring.boot.exercise.domain.Customer;
import com.gnanesh.spring.boot.exercise.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Gnanesh Arva
 * @since 07 Sep 2017 at 15:44
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CustomerController.class})
@AutoConfigureMockMvc
public class CustomerControllerTest3 {

    @MockBean
    CustomerService customerService;
    @MockBean
    CustomerRepository customerRepository;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        Customer customer = new Customer();
        customer.setFirstName("First_Name");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        when(customerService.findAllCustomers()).thenReturn(customerList);
    }

    @Test
    public void testFindAll() throws Exception {
        assertThat(customerService).isNotNull();
        mockMvc.perform(get("/customers")).andExpect(status().isOk()).andDo(print());

    }


}
