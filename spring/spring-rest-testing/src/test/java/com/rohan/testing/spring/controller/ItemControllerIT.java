package com.rohan.testing.spring.controller;

import com.rohan.testing.spring.repository.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

// @RunWith(SpringRunner.class) for Junit 4, this brings in spring context

/**
 * Spring boot test will search for the class annotated with SpringBootApplication in "com.rohan.testing.spring.controller"
 * If it doesn't find it there it will move upward in the directory and go to "com.rohan.testing.spring" (parent) where it will
 * find SpringRestTestApplication class annotated with @SpringBootApplication.
 * <p>
 * Then it launches that application so that spring context loads. When the spring context loads, all the components,
 * services, repositories, In memory database are created and launched up.
 * <p>
 * RANDOM PORT => port for actual web application
 *
 * This is the test of all the layers in the application
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    // Is aware of the port by spring boot test and the random port is associated
    @Autowired
    private TestRestTemplate restTemplate;


    /*
    Here we also have possibility to mock out some classes.
    @MockBean
    private ItemRepository itemRepository;
    */
    @Test
    public void contextLoads() {

    }

    @Test
    public void test_getAllItems() throws JSONException {
        final String response = restTemplate.getForObject("/all-items-from-databases", String.class);
        JSONAssert.assertEquals("[{id:10001},{id:10002}, {id:10003}]", response, false);
    }

}
