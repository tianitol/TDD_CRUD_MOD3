package com.proyectoTDD.repository.impl;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemRepositoryInMemory implements ItemRepository {

    private final Map<Integer, Item> storage = new HashMap<>();

    @Override
    public Item save(Item item) {
        storage.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

}
