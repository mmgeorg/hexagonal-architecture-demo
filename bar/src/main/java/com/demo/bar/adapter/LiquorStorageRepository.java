package com.demo.bar.adapter;

import com.demo.bar.port.out.LiquorStorageOutPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class LiquorStorageRepository implements LiquorStorageOutPort {
    private static final Set<String> INVENTORY = Set.of(
            "heineken", "gin", "tonic"
    );

    @Override
    public boolean tryToGetIngredients(List<String> components) {
        return INVENTORY.containsAll(components);
    }
}
