package dev.spiny.client.api.setting.handler;

import java.util.Collection;

public interface ICollectionSettingValueHandler<T> extends ISettingValueHandler<T> {
    Collection<T> getValues();
}