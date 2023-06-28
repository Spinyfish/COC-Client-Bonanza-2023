package dev.spiny.client.api.setting.handler;

public interface ISettingValueHandler<T> {
    T getValue();
    T setValue(T value);

    T getDefault();
}