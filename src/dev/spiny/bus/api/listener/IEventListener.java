package dev.spiny.bus.api.listener;

import dev.spiny.bus.api.IEvent;

@FunctionalInterface
public interface IEventListener<T extends IEvent> {
    void invoke(T event);
}