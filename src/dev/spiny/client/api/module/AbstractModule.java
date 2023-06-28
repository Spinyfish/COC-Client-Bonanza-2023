package dev.spiny.client.api.module;

public abstract class AbstractModule implements IClientModule {

    private final ModuleMetaData metaData;

    protected AbstractModule() {
        this.metaData = this.getClass().getAnnotation(ModuleMetaData.class);
    }

    @Override
    public ModuleMetaData getMetaData() {
        return this.metaData;
    }
}