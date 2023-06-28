package dev.spiny.client.api.module;

import java.util.Collection;

public interface IModuleRepository {
    /**
     *
     * @param moduleName The name of the module.
     *
     * @return The module with the given name, null if the module is not found.
     */
    IClientModule getModuleByName(String moduleName);

    Collection<IClientModule> getModules();
}