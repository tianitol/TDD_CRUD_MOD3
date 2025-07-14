package com.proyectoTDD.service;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;
import com.proyectoTDD.service.validation.ItemExistenceValidator;
import com.proyectoTDD.service.validation.ItemValidator;

public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemValidator itemValidator;
    private final ItemExistenceValidator itemExistenceValidator;

    public ItemService(ItemRepository itemRepository, ItemValidator itemValidator)   {
        this.itemRepository = itemRepository;
        this.itemValidator = itemValidator;
        this.itemExistenceValidator = new ItemExistenceValidator(itemRepository);
    }

    public Item createItem(Item item)   {
        itemValidator.validate(item);
        return itemRepository.save(item);
    }

    public Item getItemById(int id) {
        return itemExistenceValidator.validate(id);
    }

    public void deleteItemById(int id) {
        itemExistenceValidator.validate(id);
        itemRepository.deleteById(id);
    }

    public Item updateItemById(int id, Item updatedItem) {
        itemExistenceValidator.validate(id);
        return itemRepository.save(updatedItem);
    }

}
