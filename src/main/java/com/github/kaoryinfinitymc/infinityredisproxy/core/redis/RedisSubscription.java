package com.github.kaoryinfinitymc.infinityredisproxy.core.redis;

/*
 * This code for this class was originally made by Sammwy
 */

public interface RedisSubscription {
    public void onReceive(final RedisMessage message);
}
