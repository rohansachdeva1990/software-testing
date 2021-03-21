package com.rohan.testing.spring.controller;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith(SpringRunner.class) If working with Junit4
//@WebMvcTest(value = HelloWorldController.class)
@WebMvcTest(HelloWorldController.class)
        // Ideally we want to test only the controller in isolation.
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_helloWorld_basic() throws Exception {
        // Call "/hello-world" (URI)
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")        // URI
                .accept(MediaType.APPLICATION_JSON);   //

        final MvcResult result = mockMvc.perform(request).andReturn();

        // verify response contains hello world
        MatcherAssert.assertThat(result.getResponse().getContentAsString(), is("Hello World"));
    }


    @Test
    public void test_helloWorld_responseMatchers() throws Exception {
        // status() and content()

        // Call "/hello-world" (URI)
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        final MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk()) // Checking 200 Ok
                .andExpect(content().string("Hello World")) // Should exactly match, even the spaces are considered
                .andReturn();
    }
}