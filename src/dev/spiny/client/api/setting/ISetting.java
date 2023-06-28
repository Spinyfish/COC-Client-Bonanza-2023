package dev.spiny.client.api.setting;

import dev.spiny.client.api.setting.handler.ISettingValueHandler;

public interface ISetting<T> {
    ISettingValueHandler<T> getValueHandler();
    ISettingData getData();
}