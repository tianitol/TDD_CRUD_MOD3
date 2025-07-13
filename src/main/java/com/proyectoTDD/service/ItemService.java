package com.proyectoTDD.service;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;
import com.proyectoTDD.service.validation.ItemValidator;

public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemValidator itemValidator;

    public ItemService(ItemRepository itemRepository, ItemValidator itemValidator)   {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
    }

    public Item createItem(Item item)   {
        itemValidator.validate(item);
        return itemRepository.save(item);
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item con ID " + id + " no encontrado."));
    }

    public class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message)    {
            super(message);
        }
    }
}
