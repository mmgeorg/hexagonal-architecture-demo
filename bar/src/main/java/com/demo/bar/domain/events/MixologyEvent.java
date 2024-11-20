package com.demo.bar.domain.events;

import lombok.Value;

import static java.lang.String.format;

@Value(staticConstructor = "of")
public class MixologyEvent implements BaseDomainEvent {
    EventType eventType;
    String order;

    public enum EventType {
        FAILED_NO_INGREDIENTS,
        FAILED_NO_RECIPE,
        COCKTAIL_MIXED
    }

    public static MixologyEvent failedToFindRecipe(String message) {
        return MixologyEvent.of(EventType.FAILED_NO_RECIPE, message);
    }

    public static MixologyEvent outOfIngredients(String message) {
        return MixologyEvent.of(EventType.FAILED_NO_INGREDIENTS, message);
    }

    public static MixologyEvent cocktailMixed(String message) {
        return MixologyEvent.of(EventType.COCKTAIL_MIXED, message);
    }

    @Override
    public String toSummary() {
        return format("[%s]. %s", eventType, order);
    }
}
