package com.proyectoTDD.repository.impl;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemRepositoryInMemory implements ItemRepository {

    //Almacenar en memoria, simulando BD
    private final Map<Integer, Item> storage;

    public ItemRepositoryInMemory() {
        this.storage = new HashMap<>();
    }

    @Override
    public Item save(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El ítem no puede ser null");
        }
        storage.put(item.getId(), item);
        return item;
    }

    @Override
    public Optional<Item> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

}
