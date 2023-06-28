package dev.spiny.client.impl.module;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.spiny.client.api.module.IClientModule;
import dev.spiny.client.api.module.IModuleRepository;

import java.util.Collection;
import java.util.Set;

@Singleton
public final class ModuleRepositoryImpl implements IModuleRepository {

    private final Collection<IClientModule> modules;

    @Inject
    public ModuleRepositoryImpl(final Set<IClientModule> moduleSet) {
        this.modules = ImmutableSet.copyOf(moduleSet);
    }

    @Override
    public IClientModule getModuleByName(String moduleName) {
        for (final IClientModule module : this.modules) {
            final String name = module.getMetaData().name();
            if (moduleName.equalsIgnoreCase(name)) {
                return module;
            }
        }

        return null;
    }

    @Override
    public Collection<IClientModule> getModules() {
        return this.modules;
    }
}