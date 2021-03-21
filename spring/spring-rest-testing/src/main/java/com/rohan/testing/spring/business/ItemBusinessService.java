package com.rohan.testing.spring.business;

import com.rohan.testing.spring.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
