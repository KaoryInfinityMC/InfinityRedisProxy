package com.github.kaoryinfinitymc.infinityredisproxy.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "infinityredisproxy",
        name = "InfinityRedisProxy",
        version = "1.0.0-SNAPSHOT",
        description = "InfinityRedisProxy",
        authors = {"HappyRogelio7, KaoryStudios, KaoryStudiosMC, KaoryInfinityMC"}
)

public class InfinityRedisProxyVelocity {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        event.toString();
    }

}
