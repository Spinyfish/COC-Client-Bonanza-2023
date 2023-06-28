package dev.spiny.client.impl.command;

import dev.spiny.client.api.command.CommandMetaData;
import dev.spiny.client.api.command.IClientCommand;
import dev.spiny.client.api.command.ICommandExecutor;

public final class ClientCommandImpl implements IClientCommand {

    private final ICommandExecutor executor;

    private final CommandMetaData metaData;

    public ClientCommandImpl(final ICommandExecutor executor, final CommandMetaData metaData) {
        this.executor = executor;
        this.metaData = metaData;
    }

    @Override
    public ICommandExecutor getExecutor() {
        return this.executor;
    }

    @Override
    public CommandMetaData getMetaData() {
        return this.metaData;
    }
}