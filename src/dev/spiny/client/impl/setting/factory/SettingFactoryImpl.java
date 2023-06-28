package dev.spiny.client.impl.setting.factory;

import dev.spiny.client.api.setting.ISetting;
import dev.spiny.client.api.setting.factory.ISettingFactory;

import java.util.Collection;

public final class SettingFactoryImpl implements ISettingFactory {
    @Override
    public <T> ISetting<T> createSetting(String name, String description, T value) {
        return null;
    }

    @Override
    public <T extends Number> ISetting<T> createClampedSetting(String name, String description, T min, T max, T value) {
        return null;
    }

    @Override
    public <T> ISetting<T> createCollectionSetting(String name, String description, T value, Collection<T> values) {
        return null;
    }
}