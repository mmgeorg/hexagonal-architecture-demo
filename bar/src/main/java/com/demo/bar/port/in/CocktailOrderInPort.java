package com.demo.bar.port.in;

import com.demo.bar.domain.model.Cocktail;

public interface CocktailOrderInPort {
    Cocktail heyGiveMeDrink(String order);
}
