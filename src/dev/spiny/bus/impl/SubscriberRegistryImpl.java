package dev.spiny.bus.impl;

import dev.spiny.bus.api.ISubscriber;
import dev.spiny.bus.api.ISubscriberRegistry;
import dev.spiny.bus.api.listener.IEventListener;

import java.util.Collection;
import java.util.Map;

public final class SubscriberRegistryImpl implements ISubscriberRegistry {

    private static final Map<ISubscriber, Collection<IEventListener>> listenerMap;

    @Override
    public Collection<IEventListener> getSubListeners(ISubscriber subscriber) {
        return null;
    }
}