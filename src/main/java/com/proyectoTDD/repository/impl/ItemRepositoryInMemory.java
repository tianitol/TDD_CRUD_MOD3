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

    @Override
    public void deleteById(int id) {
        if(!storage.containsKey(id)) {
            throw new IllegalArgumentException("No existe un ítem con ID: " + id);
        }
        storage.remove(id);
    }

    @Override
    public Item update(Item item)   {
        //Utilización de .replace() en vez de .put() para verificar si el id existe antes de actualizar el item
        storage.replace(item.getId(), item);
        return item;
    }

}
