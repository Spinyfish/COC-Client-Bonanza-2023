package dev.spiny.bus.api.dispatch;

import dev.spiny.bus.api.IEvent;

public interface IEventDispatcher {
    void dispatch(IEvent event);
}