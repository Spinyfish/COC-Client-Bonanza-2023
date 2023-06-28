package dev.spiny.bus.impl.dispatch;

import dev.spiny.bus.api.IEvent;
import dev.spiny.bus.api.IListenerRegistry;
import dev.spiny.bus.api.dispatch.IEventDispatcher;
import dev.spiny.bus.api.listener.IEventListener;

public class SynchronousEventDispatcherImpl implements IEventDispatcher {
    private final IListenerRegistry listenerRegistry;

    protected SynchronousEventDispatcherImpl(IListenerRegistry listenerRegistry) {
        this.listenerRegistry = listenerRegistry;
    }

    @Override
    public void dispatch(IEvent event) {
        for (IEventListener listener : this.listenerRegistry.getListeners()) {
            listener.invoke(event);
        }
    }
}
