package dev.spiny.client.impl.setting;

import dev.spiny.client.api.setting.ISetting;
import dev.spiny.client.api.setting.ISettingData;
import dev.spiny.client.api.setting.handler.ISettingValueHandler;

public final class SettingImpl<T> implements ISetting<T> {

    private final ISettingValueHandler<T> valueHandler;

    private final ISettingData settingData;

    public SettingImpl(final ISettingValueHandler<T> valueHandler, final ISettingData settingData) {
        this.valueHandler = valueHandler;
        this.settingData = settingData;
    }

    @Override
    public ISettingValueHandler<T> getValueHandler() {
        return this.valueHandler;
    }

    @Override
    public ISettingData getData() {
        return this.settingData;
    }
}