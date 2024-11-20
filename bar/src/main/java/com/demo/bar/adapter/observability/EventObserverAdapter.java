package com.demo.bar.adapter.observability;

import com.demo.bar.domain.events.BaseDomainEvent;
import com.demo.bar.domain.events.MixologyEvent;
import com.demo.bar.port.out.DomainEventObserverPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class EventObserverAdapter implements DomainEventObserverPort {
    public static final EventHandler<BaseDomainEvent> DEFAULT_HANDLER =
            e -> log.debug("[EventObserverAdapter] Event handled by default {}", e.toSummary());

    private static final Map<Class<? extends BaseDomainEvent>, EventHandler<? extends BaseDomainEvent>> handlers =
            Map.of(MixologyEvent.class, new MixologyEventHandler());

    @Override
    public void observe(BaseDomainEvent event) {
        handlers.getOrDefault(event.getClass(), DEFAULT_HANDLER).handle(cast(event));
    }


    @SuppressWarnings("unchecked")
    public static <T> T cast(Object object) {
        return (T) object;
    }
}
