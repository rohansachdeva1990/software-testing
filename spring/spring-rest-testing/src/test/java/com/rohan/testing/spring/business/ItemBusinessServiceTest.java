package com.rohan.testing.spring.business;

import com.rohan.testing.spring.model.Item;
import com.rohan.testing.spring.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Test
    public void testValueBusinessLogic() {
        when(itemRepository.findAll()).thenReturn(List.of(
                new Item(1, "Item1", 10, 100),
                new Item(2, "Item2", 20, 20)
        ));

        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(1000, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }

}