package dev.spiny.bus.api;

import dev.spiny.bus.api.listener.IEventListener;

import java.util.Collection;

public interface IListenerRegistry {
    Collection<IEventListener> getListeners();

    void addListeners(Collection<IEventListener> listeners);
    void removeListeners(Collection<IEventListener> listeners);
}