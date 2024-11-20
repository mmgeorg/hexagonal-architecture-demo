package com.demo.bar.adapter;

import com.demo.bar.domain.model.Cocktail;
import com.demo.bar.port.out.RecipeCatalogOutPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class RecipeCatalogRepository implements RecipeCatalogOutPort {
    private static final Map<String, List<String>> CATALOG_MAP = Map.of(
            "beer", List.of("heineken"),
            "gin-tonic", List.of("tonic", "gin")
    );


    @Override
    public Optional<Cocktail> find(String name) {
        if (!CATALOG_MAP.containsKey(name)) {
            return Optional.empty();
        }
        return Optional.of(new Cocktail(name, CATALOG_MAP.get(name)));
    }
}
