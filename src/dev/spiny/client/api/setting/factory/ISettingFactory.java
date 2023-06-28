package dev.spiny.client.api.setting.factory;

import dev.spiny.client.api.setting.ISetting;

import java.util.Collection;

public interface ISettingFactory {
    <T> ISetting<T> createSetting(String name, String description, T value);

    <T extends Number> ISetting<T> createClampedSetting(String name, String description, T min, T max, T value);

    <T> ISetting<T> createCollectionSetting(String name, String description, T value, Collection<T> values);
}