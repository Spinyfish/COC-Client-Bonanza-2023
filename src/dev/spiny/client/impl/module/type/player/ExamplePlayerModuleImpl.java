package dev.spiny.client.impl.module.type.player;

import com.google.inject.Inject;
import dev.spiny.bus.api.Subscribe;
import dev.spiny.bus.api.listener.IEventListener;
import dev.spiny.client.api.chat.IChatBroadcaster;
import dev.spiny.client.api.module.AbstractModule;
import dev.spiny.client.api.module.EnumModuleType;
import dev.spiny.client.api.module.ModuleMetaData;
import dev.spiny.client.api.setting.ISetting;
import dev.spiny.client.api.setting.factory.ISettingFactory;
import dev.spiny.client.impl.event.game.GameTickEvent;

import java.util.logging.Logger;

@ModuleMetaData(
        name = "Example",
        description = "Uwu",
        type = EnumModuleType.PLAYER
)
public final class ExamplePlayerModuleImpl extends AbstractModule {

    private final ISetting<Integer> exampleIntSetting;

    private final IChatBroadcaster chatBroadcaster;

    @Subscribe
    private final IEventListener<GameTickEvent> gameTickListener = this::onGameTick;

    @Inject
    public ExamplePlayerModuleImpl(final ISettingFactory factory, final IChatBroadcaster chatBroadcaster) {
        this.chatBroadcaster = chatBroadcaster;
        this.exampleIntSetting = factory.createClampedSetting("Example", "An example setting!", 0, 5, 3);
    }

    private void onGameTick(final GameTickEvent gameTickEvent) {
        this.chatBroadcaster.broadcastMessage("Hiii! Come on in :3 Im just putting on my bikini hee~ and when they shut the door... THATS WHEN I LET THEM SEE ME");
    }

}