
package com.proyectoTDD.service;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;
import com.proyectoTDD.service.validation.ItemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 public class ItemServiceTest {

    private ItemRepository itemRepository;
    private ItemService itemService;
    private ItemValidator itemValidator;


    @BeforeEach
    public void setUp() {
        itemRepository = mock(ItemRepository.class);
        itemValidator = mock(ItemValidator.class);
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


}