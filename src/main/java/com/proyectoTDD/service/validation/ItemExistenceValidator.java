package com.proyectoTDD.service.validation;

import com.proyectoTDD.model.Item;
import com.proyectoTDD.repository.ItemRepository;
import com.proyectoTDD.exception.ItemNotFoundException;

public class ItemExistenceValidator {
    private final ItemRepository itemRepository;

    public ItemExistenceValidator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item validate(int id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("No existe un item con ID: " + id));
    }
}

