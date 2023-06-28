package dev.spiny.client.api.module;

public enum EnumModuleType {
    COMBAT("Combat"),
    PLAYER("Player"),
    MOVEMENT("Movement");

    private final String name;

    EnumModuleType(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}