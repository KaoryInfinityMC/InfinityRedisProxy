package com.github.kaoryinfinitymc.infinityredisproxy.core.sync.bungee;

import com.github.kaoryinfinitymc.infinityredisproxy.bungee.InfinityRedisProxyBungee;
import com.github.kaoryinfinitymc.infinityredisproxy.core.redis.RedisMessage;
import com.github.kaoryinfinitymc.infinityredisproxy.core.redis.RedisSubscription;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class SendGlobalAlertProxySyncBungee implements RedisSubscription {

    public final static String CHANNEL = "alert_broadcast";

    private final InfinityRedisProxyBungee plugin;

    public SendGlobalAlertProxySyncBungee(final InfinityRedisProxyBungee plugin) {
        this.plugin = plugin;
    }

    public void sendGlobalAlert(final String message) {
        this.plugin.getMessageBroker().publish(CHANNEL, message);
    }

    @Override
    public void onReceive(final RedisMessage message) {
        if (!message.getChannel().equals(CHANNEL)) {
            return;
        }

        this.plugin.getProxy().broadcast(
                new ComponentBuilder(ChatColor.translateAlternateColorCodes('&',
                        this.plugin.getMessage().getConfig().getString("messages.global.alert.prefix") + " "
                                + message.getContent())).create());
    }

}
