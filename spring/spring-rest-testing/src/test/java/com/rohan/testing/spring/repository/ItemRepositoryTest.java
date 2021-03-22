package com.rohan.testing.spring.repository;

import com.rohan.testing.spring.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  To test repository classes
 */
// @RunWith(SpringRunner.class) for J4
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        final List<Item> items = repository.findAll();
        assertEquals(3, items.size());
    }

}