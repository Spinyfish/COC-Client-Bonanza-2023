package dev.spiny.client.api.command.result;

public interface ICommandResultFactory {
    ICommandExecutionResult createResult(String content);
}