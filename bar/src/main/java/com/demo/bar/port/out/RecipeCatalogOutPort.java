package com.demo.bar.port.out;

import com.demo.bar.domain.model.Cocktail;

import java.util.Optional;

public interface RecipeCatalogOutPort {

    Optional<Cocktail> find(String name);
}
