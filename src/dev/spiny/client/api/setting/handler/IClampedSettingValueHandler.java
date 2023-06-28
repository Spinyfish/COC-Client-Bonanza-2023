package dev.spiny.client.api.setting.handler;

public interface IClampedSettingValueHandler<T extends Number> extends ISettingValueHandler<T> {
    T getMinimum();
    T getMaximum();
}