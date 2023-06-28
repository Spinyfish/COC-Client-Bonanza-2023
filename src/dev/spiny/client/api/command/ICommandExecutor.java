package dev.spiny.client.api.command;

import dev.spiny.client.api.command.arg.ICommandArgs;
import dev.spiny.client.api.command.result.ICommandExecutionResult;

public interface ICommandExecutor {
    ICommandExecutionResult execute(ICommandArgs commandArgs);
}