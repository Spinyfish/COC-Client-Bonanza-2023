package dev.spiny.client.impl.guice;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import dev.spiny.bus.api.IEventBus;
import dev.spiny.bus.api.IListenerRegistry;
import dev.spiny.bus.api.dispatch.IEventDispatcher;
import dev.spiny.bus.impl.EventBusImpl;
import dev.spiny.bus.impl.ListenerRegistryImpl;
import dev.spiny.bus.impl.dispatch.SynchronousEventDispatcherImpl;
import dev.spiny.client.api.chat.IChatBroadcaster;
import dev.spiny.client.api.client.IClient;
import dev.spiny.client.api.command.ICommandExecutor;
import dev.spiny.client.api.command.ICommandRepository;
import dev.spiny.client.api.module.IClientModule;
import dev.spiny.client.api.module.IModuleRepository;
import dev.spiny.client.api.setting.factory.ISettingFactory;
import dev.spiny.client.api.toggle.IToggleService;
import dev.spiny.client.impl.chat.ChatBroadcasterImpl;
import dev.spiny.client.impl.client.ClientImpl;
import dev.spiny.client.impl.command.CommandRepositoryImpl;
import dev.spiny.client.impl.command.executor.ToggleCommandExecutorImpl;
import dev.spiny.client.impl.module.ModuleRepositoryImpl;
import dev.spiny.client.impl.module.type.player.ExamplePlayerModuleImpl;
import dev.spiny.client.impl.setting.factory.SettingFactoryImpl;
import dev.spiny.client.impl.toggle.EventToggleServiceImpl;
import net.minecraft.client.main.GameConfiguration;

public final class ClientGuiceModule extends AbstractModule {

    private final GameConfiguration gameConfiguration;

    public ClientGuiceModule(final GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

    @Override
    protected void configure() {
        super.bind(GameConfiguration.class).toInstance(this.gameConfiguration);
        this.configureEventBus();

        this.configureClientCore();
        this.configureSettings();
        this.configureChat();
        this.configureModules();
        this.configureCommands();
    }

    private void configureEventBus() {
        super.bind(IListenerRegistry.class).to(ListenerRegistryImpl.class);
        super.bind(IEventDispatcher.class).to(SynchronousEventDispatcherImpl.class);
        super.bind(IEventBus.class).to(EventBusImpl.class);
    }

    private void configureClientCore() {
        super.bind(IClient.class).to(ClientImpl.class);
    }

    private void configureSettings() {
        super.bind(ISettingFactory.class).to(SettingFactoryImpl.class);
    }

    private void configureChat() {
        super.bind(IChatBroadcaster.class).to(ChatBroadcasterImpl.class);
    }

    private void configureModules() {
        super.bind(IToggleService.class).to(EventToggleServiceImpl.class);

        final Multibinder<IClientModule> moduleMultibinder = Multibinder.newSetBinder(super.binder(), IClientModule.class);

        moduleMultibinder.addBinding().to(ExamplePlayerModuleImpl.class);

        super.bind(IModuleRepository.class).to(ModuleRepositoryImpl.class);
    }

    private void configureCommands() {
        final Multibinder<ICommandExecutor> executorMultibinder = Multibinder.newSetBinder(super.binder(), ICommandExecutor.class);

        executorMultibinder.addBinding().to(ToggleCommandExecutorImpl.class);

        super.bind(ICommandRepository.class).to(CommandRepositoryImpl.class);
    }

}