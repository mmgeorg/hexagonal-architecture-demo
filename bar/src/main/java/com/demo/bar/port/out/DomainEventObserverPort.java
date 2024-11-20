package com.demo.bar.port.out;


import com.demo.bar.domain.events.BaseDomainEvent;

public interface DomainEventObserverPort {

    void observe(BaseDomainEvent event);
}
