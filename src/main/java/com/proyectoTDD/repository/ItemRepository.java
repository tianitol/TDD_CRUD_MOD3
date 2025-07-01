package com.proyectoTDD.repository;

import com.proyectoTDD.model.Item;

import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(int id);
}
