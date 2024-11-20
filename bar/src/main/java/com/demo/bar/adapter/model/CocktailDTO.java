package com.demo.bar.adapter.model;

import com.demo.bar.domain.model.Cocktail;

import java.util.List;

public record CocktailDTO(String name, List<String> ingredients) {

    public static CocktailDTO from(Cocktail cocktail){
        return new CocktailDTO(cocktail.name(), cocktail.ingredients());
    }
}
