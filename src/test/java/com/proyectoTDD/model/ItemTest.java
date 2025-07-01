package com.proyectoTDD.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    @Test
    public void testItemConstructorAndGetters() {
        int id = 1;
        String size = "p";
        String name = "Taza";
        int stock = 10;

        Item item = new Item(id, size, name, stock);

        //Assert
        assertEquals(id, item.getId());
        assertEquals(size, item.getSize());
        assertEquals(name, item.getName());
        assertEquals(stock, item.getStock());
    }
}
