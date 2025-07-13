package com.proyectoTDD.service;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository)   {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item)   {
        return itemRepository.save(item);
    }
}
