package dev.spiny.client.impl.command.executor;

import com.google.inject.Inject;
import dev.spiny.client.api.command.CommandMetaData;
import dev.spiny.client.api.command.ICommandExecutor;
import dev.spiny.client.api.command.arg.ICommandArgs;
import dev.spiny.client.api.command.result.ICommandExecutionResult;
import dev.spiny.client.api.command.result.ICommandResultFactory;
import dev.spiny.client.api.module.IClientModule;
import dev.spiny.client.api.module.IModuleRepository;
import dev.spiny.client.api.toggle.IToggleService;

@CommandMetaData(
        names = {"Toggle", "T"}
)
public final class ToggleCommandExecutorImpl implements ICommandExecutor {

    private final ICommandResultFactory resultFactory;

    private final IModuleRepository moduleRepository;

    private final IToggleService toggleService;

    @Inject
    public ToggleCommandExecutorImpl(final ICommandResultFactory resultFactory,
                                     final IModuleRepository moduleRepository,
                                     final IToggleService toggleService) {
        this.resultFactory = resultFactory;
        this.moduleRepository = moduleRepository;
        this.toggleService = toggleService;
    }

    @Override
    public ICommandExecutionResult execute(ICommandArgs commandArgs) {
        final String[] args = commandArgs.getArgs();
        final String moduleName = args[0];
        final IClientModule module = this.moduleRepository.getModuleByName(moduleName);

        if (module == null) {
            return this.missingModuleResult(moduleName);
        }

        final boolean enabled = this.toggleService.toggle(module);

        final String enabledString = enabled ? "Enabled" : "Disabled";

        return this.resultFactory.createResult(enabledString + ' ' + moduleName);
    }

    private ICommandExecutionResult missingModuleResult(final String name) {
        return this.resultFactory.createResult("The module " + name + " could not be found... DUMB TWINK");
    }
}