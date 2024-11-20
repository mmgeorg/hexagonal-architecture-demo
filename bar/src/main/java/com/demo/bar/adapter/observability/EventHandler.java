package com.demo.bar.adapter.observability;

import com.demo.bar.domain.events.BaseDomainEvent;

public interface EventHandler<T extends BaseDomainEvent> {

    void handle(T event);
}
