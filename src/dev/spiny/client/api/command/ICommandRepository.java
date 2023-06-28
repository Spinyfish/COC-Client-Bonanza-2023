package dev.spiny.client.api.command;

import java.util.Collection;

public interface ICommandRepository {
    IClientCommand getCommandByName(String commandName);

    Collection<IClientCommand> getCommands();
}