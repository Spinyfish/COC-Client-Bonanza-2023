package dev.spiny.bus.api;

import dev.spiny.bus.api.listener.IEventListener;

import java.util.Collection;

public interface ISubscriberRegistry {
    Collection<IEventListener> getSubListeners(ISubscriber subscriber);
}