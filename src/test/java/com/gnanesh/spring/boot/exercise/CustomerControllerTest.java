package com.gnanesh.spring.boot.exercise;

import com.gnanesh.spring.boot.exercise.controller.CustomerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Gnanesh Arva
 * @since 07 Sep 2017 at 08:15
 */
@RunWith(SpringRunner.class)
public class CustomerControllerTest {


    // Without Spring MVC Test related annotations.

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
    }

    @Test
    public void testFindAll() throws Exception {
        mockMvc.perform(get("/customers/test")).andExpect(status().isOk()).andDo(print());
    }

}
