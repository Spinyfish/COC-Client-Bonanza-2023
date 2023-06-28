package dev.spiny.bus.api;

public interface IEventBus {
    void publish(IEvent event);

    void subscribe(ISubscriber subscriber);

    void unsubscribe(ISubscriber subscriber);
}