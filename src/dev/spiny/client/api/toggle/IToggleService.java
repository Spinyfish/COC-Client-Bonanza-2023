package dev.spiny.client.api.toggle;

public interface IToggleService {
    boolean toggle(IToggleable toggleable);

    boolean isEnabled(IToggleable toggleable);
}