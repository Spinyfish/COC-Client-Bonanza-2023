package dev.spiny.client.impl.toggle;

import com.google.inject.Inject;
import dev.spiny.bus.api.IEventBus;
import dev.spiny.client.api.toggle.IToggleService;
import dev.spiny.client.api.toggle.IToggleable;

import java.util.HashMap;
import java.util.Map;

public final class EventToggleServiceImpl implements IToggleService {

    private final IEventBus eventBus;

    private final Map<IToggleable, Boolean> toggleableMap;

    @Inject
    public EventToggleServiceImpl(final IEventBus eventBus) {
        this.eventBus = eventBus;
        this.toggleableMap = new HashMap<>();
    }

    @Override
    public boolean toggle(final IToggleable toggleable) {
        final boolean prevToggleState = this.toggleableMap.computeIfAbsent(toggleable, t -> false);
        final boolean toggled = !prevToggleState;

        if (toggled) {
            this.eventBus.subscribe(toggleable);
        } else {
            this.eventBus.unsubscribe(toggleable);
        }
        return toggled;
    }

    @Override
    public boolean isEnabled(final IToggleable toggleable) {
        return this.toggleableMap.computeIfAbsent(toggleable, t -> false);
    }
}