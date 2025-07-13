package com.proyectoTDD.service.validation;

import com.proyectoTDD.model.Item;

public class ItemValidator {
    public void validate(Item item) {
        if(item.getName() == null || item.getName().isEmpty())  {
            throw new IllegalArgumentException("El nombre del item no puede estar vacío.");
        }

        if(item.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }
}
