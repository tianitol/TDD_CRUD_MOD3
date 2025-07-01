package com.proyectoTDD.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    int id = 1;
    String size = "p";
    String name = "Taza";
    int stock = 10;

    @Test
    public void testItemConstructorAndGetters() {

        Item item = new Item(id, size, name, stock);

        //Assert
        assertEquals(id, item.getId());
        assertEquals(size, item.getSize());
        assertEquals(name, item.getName());
        assertEquals(stock, item.getStock());
    }

    @Test
    public void testItemSetters() {
        Item item = new Item();

        item.setId(id);
        item.setSize(size);
        item.setName(name);
        item.setStock(stock);

        //Assert
        assertEquals(id, item.getId());
        assertEquals(size, item.getSize());
        assertEquals(name, item.getName());
        assertEquals(stock, item.getStock());
    }
}
