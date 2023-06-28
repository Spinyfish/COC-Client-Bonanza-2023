package dev.spiny.bus.impl;

import dev.spiny.bus.api.IListenerRegistry;
import dev.spiny.bus.api.listener.IEventListener;

import java.util.Collection;
import java.util.HashSet;

public final class ListenerRegistryImpl implements IListenerRegistry {

    private final Collection<IEventListener> listeners;

    public ListenerRegistryImpl() {
        this.listeners = new HashSet<>();
    }

    @Override
    public Collection<IEventListener> getListeners() {
        return this.listeners;
    }

    @Override
    public void addListeners(Collection<IEventListener> listeners) {
        this.listeners.addAll(listeners);
    }

    @Override
    public void removeListeners(Collection<IEventListener> listeners) {
        this.listeners.removeAll(listeners);
    }
}