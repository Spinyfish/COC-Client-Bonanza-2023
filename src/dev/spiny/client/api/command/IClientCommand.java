package dev.spiny.client.api.command;

public interface IClientCommand {
    ICommandExecutor getExecutor();
    CommandMetaData getMetaData();
}