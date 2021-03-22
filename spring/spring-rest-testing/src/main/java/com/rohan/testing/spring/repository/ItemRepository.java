package com.rohan.testing.spring.repository;

import com.rohan.testing.spring.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
