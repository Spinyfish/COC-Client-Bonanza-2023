package dev.spiny.client.impl.command;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.spiny.client.api.command.CommandMetaData;
import dev.spiny.client.api.command.IClientCommand;
import dev.spiny.client.api.command.ICommandExecutor;
import dev.spiny.client.api.command.ICommandRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Singleton
public final class CommandRepositoryImpl implements ICommandRepository {

    private final Collection<IClientCommand> commands;

    @Inject
    public CommandRepositoryImpl(final Set<ICommandExecutor> executors) {
        final Collection<IClientCommand> tempCommandsSet = new HashSet<>();

        for (ICommandExecutor executor : executors) {
            final CommandMetaData metaData = executor.getClass().getAnnotation(CommandMetaData.class);
            tempCommandsSet.add(new ClientCommandImpl(executor, metaData));
        }

        this.commands = ImmutableSet.copyOf(tempCommandsSet);
    }

    @Override
    public IClientCommand getCommandByName(String commandName) {
        for (final IClientCommand command : this.commands) {
            final String[] names = command.getMetaData().names();
            final int length = names.length;
            for (int i = 0; i < length; i++) {
                final String cmdAlias = names[i];
                if (!cmdAlias.equalsIgnoreCase(commandName)) {
                    continue;
                }

                return command;
            }
        }
        return null;
    }

    @Override
    public Collection<IClientCommand> getCommands() {
        return this.commands;
    }
}