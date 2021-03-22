package com.rohan.testing.spring.business;

import com.rohan.testing.spring.model.Item;
import com.rohan.testing.spring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        final List<Item> all = itemRepository.findAll();
        // Some business logic
        all.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        return all;
    }
}
