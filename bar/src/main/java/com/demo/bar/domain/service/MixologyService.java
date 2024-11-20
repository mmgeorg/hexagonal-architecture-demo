package com.demo.bar.domain.service;

import com.demo.bar.domain.events.MixologyEvent;
import com.demo.bar.domain.model.Cocktail;
import com.demo.bar.port.in.CocktailOrderInPort;
import com.demo.bar.port.out.DomainEventObserverPort;
import com.demo.bar.port.out.RecipeCatalogOutPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MixologyService implements CocktailOrderInPort {

    private final RecipeCatalogOutPort recipeCatalogPort;
    private final DomainEventObserverPort observer;

    @Override
    public Cocktail heyGiveMeDrink(String order) {

        var maybeCocktail = recipeCatalogPort.find(order);

        if (maybeCocktail.isEmpty()) {
            observer.observe(MixologyEvent.failedToFindRecipe(order));
            throw new RuntimeException("We don't have cocktail with" + order);
        }
        var cocktail = maybeCocktail.get();
        observer.observe(MixologyEvent.cocktailMixed(cocktail.name()));
        return cocktail;
    }

}