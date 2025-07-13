package com.proyectoTDD.repository.impl;

import com.proyectoTDD.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testDeleteById_RemovesItem() {

        Item item = new Item(1, "m", "Plato", 10);
        repository.save(item);

        repository.deleteById(1);
        Optional<Item> result = repository.findById(1);

        //Assert
        assertFalse(result.isPresent());

    }

    @Test
    public void testDeleteById_WhenItemDoesNotExist_ShouldThrowException() {

        int nonexistentId = 999;

        //Act y Assert
        Exception exception;
        exception = assertThrows(IllegalArgumentException.class, () -> repository.deleteById(nonexistentId));

        assertEquals("No existe un item con ID: 999", exception.getMessage());
    }

    @Test
    public void testUpdatedItem_ShouldReplaceExistingItem() {
        //Se instancia el item
        Item original = new Item(1, "m", "Cuchara", 15);
        repository.save(original);

        Item updated = new Item(1, "g", "Cuchara", 20);
        //Act
        repository.update(updated);
        Optional<Item> result = repository.findById(1);

        //Assert
        assertTrue(result.isPresent());
        assertEquals("g", result.get().getSize());
        assertEquals("Cuchara", result.get().getName());
        assertEquals(20, result.get().getStock());
    }

    @Test
    public void testUpdateItem_WhenItemDoesNotExist_ShouldThrowException()  {
        //Instanciar el item
        Item item = new Item(99, "s", "Taza de té", 5);

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.update(item);
        });

        //Assert
        assertEquals("No existe un item con ID: 99", exception.getMessage());
    }
}
