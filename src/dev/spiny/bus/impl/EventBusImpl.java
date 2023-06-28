package dev.spiny.bus.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.spiny.bus.api.IEvent;
import dev.spiny.bus.api.IEventBus;
import dev.spiny.bus.api.ISubscriber;
import dev.spiny.bus.api.dispatch.IEventDispatcher;

@Singleton
public final class EventBusImpl implements IEventBus {

    private final IEventDispatcher dispatcher;

    @Inject
    public EventBusImpl(final IEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void publish(final IEvent event) {
        this.dispatcher.dispatch(event);
    }

    @Override
    public void subscribe(ISubscriber subscriber) {

    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {

    }
}