package com.github.kaoryinfinitymc.infinityredisproxy.core.redis;

/*
 * This code for this class was originally made by Sammwy
 */

import redis.clients.jedis.Jedis;

public class RedisStorage {

    private final Jedis client; // Redis client used to store data;

    public RedisStorage(final String host, final int port, final String password) {
        this.client = new Jedis(host, port);

        if (password != null && !password.isEmpty()) {
            this.client.auth(password);
        }

        this.client.ping();
    }

    public String get(String key) {
        return this.client.get(key);
    }

    public void set(String key, String value) {
        this.client.set(key, value);
    }

    public void set(String key, String value, int expiration) {
        this.client.setex(key, expiration, value);
    }

    public void delete(String key) {
        this.client.del(key);
    }

}
