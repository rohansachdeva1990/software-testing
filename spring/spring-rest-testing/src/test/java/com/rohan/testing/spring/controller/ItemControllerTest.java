package com.rohan.testing.spring.controller;

import com.rohan.testing.spring.business.ItemBusinessService;
import com.rohan.testing.spring.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"));
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        // Mocking business service, as we are testing the controller
        when(itemBusinessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name: Item, price:10 }"));
    }
}