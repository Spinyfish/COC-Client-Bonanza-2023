package dev.spiny.client.api.module;

import dev.spiny.client.api.toggle.IToggleable;

public interface IClientModule extends IToggleable {
    ModuleMetaData getMetaData();
}