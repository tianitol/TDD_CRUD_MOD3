
package com.proyectoTDD.service;

import com.proyectoTDD.exception.ItemNotFoundException;
import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;
import com.proyectoTDD.service.validation.ItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 public class ItemServiceTest {

    private ItemRepository itemRepository;
    private ItemService itemService;


     @BeforeEach
    public void setUp() {
        itemRepository = mock(ItemRepository.class);
         ItemValidator itemValidator = mock(ItemValidator.class);
        itemService = new ItemService(itemRepository, itemValidator);
    }

    //Test para Crear un item (Create)

    @Test
    public void testCreateItem_shouldReturnSavedItem() {
        //Instanciar nuevo item
        Item item = new Item(1, "p", "Taza", 10);
        when(itemRepository.save(item)).thenReturn(item);

        //Crear el nuevo item
        Item result = itemService.createItem(item);

        //Assert
        assertNotNull(result);
        assertEquals("Taza", result.getName());
        assertEquals(10, result.getStock());
        assertEquals("p", result.getSize());
        verify(itemRepository, times(1)).save(item);
    }

    @Test
     public void testGetItemById_shouldReturnItemIfExists() {
         //Instanciar
        Item item = new Item(1, "p", "Taza", 10);

        when(itemRepository.findById(1)).thenReturn(Optional.of(item));

        //Act
        Item result = itemService.getItemById(1);

        //Assert
        assertNotNull(result.getName());
        assertEquals(10, result.getStock());
        assertEquals("p", result.getSize());
        verify(itemRepository, times(1)).findById(1);
    }

    @Test
     public void testGetItemById_shouldThrowExceptionIfNotFound()    {
         //instanciar?
        when(itemRepository.findById(99)).thenReturn(Optional.empty());

        //Act and Assert
        assertThrows(ItemNotFoundException.class, () -> itemService.getItemById(99));
        verify(itemRepository, times(1)).findById(99);
    }

    @Test
    public void testDeleteItemById_shouldDeleteIfExists()   {
         //Instanciar
        int id = 1;
        Item item = new Item(id, "p", "Taza", 10);

        when(itemRepository.findById(id)).thenReturn(Optional.of(item));

        //Act
        itemService.deleteItemById(id);

        //Assert
        verify(itemRepository, times(1)).deleteById(id);
    }

     @Test
     public void testDeleteItemById_shouldThrowExceptionIfNotFound() {
         // Arrange
         int id = 99;
         when(itemRepository.findById(id)).thenReturn(Optional.empty());

         // Act & Assert
         assertThrows(ItemNotFoundException.class, () -> itemService.deleteItemById(id));
         verify(itemRepository, never()).deleteById(anyInt());
     }

 }