package dev.spiny.client.impl.client;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dev.spiny.client.api.client.IClient;

import java.util.logging.Logger;

@Singleton
public final class ClientImpl implements IClient {

    private final Logger logger;

    @Inject
    public ClientImpl(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public void launch() {
        this.logger.info("Client has launched!");
    }

    @Override
    public void shutdown() {
        this.logger.info("Client has shutdown :c");
    }
}