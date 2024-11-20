package com.demo.bar.adapter.observability;

import com.demo.bar.domain.events.MixologyEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MixologyEventHandler implements EventHandler<MixologyEvent> {

    @Override
    public void handle(MixologyEvent event) {
        switch (event.getEventType()) {
            case FAILED_NO_INGREDIENTS: {
                //Report metrics
                log.warn("[MixologyEventHandler] No ingredients for - {}", event.getOrder());
                break;
            }
            case FAILED_NO_RECIPE: {
                //Report metrics
                log.warn("[MixologyEventHandler] No recipe for - {}", event.getOrder());
                break;
            }
            case COCKTAIL_MIXED:
            default:
                log.info("[MixologyEventHandler] " + event.toSummary());
        }
    }
}
