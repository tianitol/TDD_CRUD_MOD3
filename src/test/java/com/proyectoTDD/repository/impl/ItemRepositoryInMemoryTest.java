package com.proyectoTDD.repository.impl;

import com.proyectoTDD.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRepositoryInMemoryTest {
    private ItemRepositoryInMemory repository;

    @BeforeEach
    public void setUp() {
        repository = new ItemRepositoryInMemory();
    }

    @Test
    public void testSaveAndFindById() {

        Item item = new Item(1, "m", "Plato", 10);

        repository.save(item);
        Optional<Item> result = repository.findById(1);

        //Assert
        assertTrue(result.isPresent());
        assertEquals("Plato", result.get().getName());
        assertEquals("m", result.get().getSize());
        assertEquals(10, result.get().getStock());
    }

    @Test
    public void testFindById_NotFound() {

        Optional<Item> result = repository.findById(99);

        //Assert
        assertFalse(result.isPresent());

    }
}
