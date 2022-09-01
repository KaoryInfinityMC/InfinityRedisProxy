package com.github.kaoryinfinitymc.infinityredisproxy.bungee;

import com.github.kaoryinfinitymc.infinityredisproxy.bungee.filemanager.FileManager;
import com.github.kaoryinfinitymc.infinityredisproxy.core.redis.RedisMessageBroker;
import com.github.kaoryinfinitymc.infinityredisproxy.core.redis.RedisStorage;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

public final class InfinityRedisProxyBungee extends Plugin {

    private  static InfinityRedisProxyBungee instance = null;

    public static InfinityRedisProxyBungee getInstance() {
        return instance;
    }

    private FileManager config;
    private FileManager messages;

    private String serverID;

    private RedisMessageBroker broker;
    private RedisStorage storage;

    public void init() throws Exception {

        registerFiles();

    }

    public void registerFiles(){
        this.config = new FileManager(this, "config-bungee");
        this.messages = new FileManager(this, "messages");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        try {
            this.init();
        } catch (final Exception e) {
            this.getLogger().log(Level.SEVERE,
                    "InfinityElasticBunge had an unexpected error and the proxy will be closed to prevent security breaches.");
            e.printStackTrace();
            this.getProxy().stop();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileManager getConfig(){
        return this.config;
    }

    public FileManager getMessage() {
        return this.messages;
    }

    public RedisMessageBroker getMessageBroker() {
        return this.broker;
    }

    public RedisStorage getStorage() {
        return this.storage;
    }



    public String getServerID() {
        return this.serverID;
    }

}