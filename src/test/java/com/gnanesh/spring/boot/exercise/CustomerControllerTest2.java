package com.gnanesh.spring.boot.exercise;

import com.gnanesh.spring.boot.exercise.controller.CustomerController;
import com.gnanesh.spring.boot.exercise.repository.CustomerRepository;
import com.gnanesh.spring.boot.exercise.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Gnanesh Arva
 * @since 07 Sep 2017 at 08:30
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest2 {


    // With @WebMvcTest (I am testing the web, so do not create other beans like @Service, @Repository).
    // It focuses on configuring @Controller beans.
    // But here we need to create the MockMvc instance. Go to CustomerControllerTest3 for auto creation of MockMvc instance.


    @Autowired
    WebApplicationContext webApplicationContext;
    @MockBean
    CustomerService customerService;
    @MockBean
    CustomerRepository customerRepository;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFindAll() throws Exception {
        assertThat(customerService).isNotNull();
        mockMvc.perform(get("/customers")).andExpect(status().isOk()).andDo(print());

    }


}
