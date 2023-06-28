package dev.spiny.client.impl.chat;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.spiny.client.api.chat.IChatBroadcaster;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

@Singleton
public final class ChatBroadcasterImpl implements IChatBroadcaster {

    private final Minecraft minecraft;

    @Inject
    public ChatBroadcasterImpl(final Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    @Override
    public void broadcastMessage(String content) {
        this.minecraft.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(content));
    }
}