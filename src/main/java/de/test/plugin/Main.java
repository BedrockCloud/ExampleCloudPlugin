package de.test.plugin;

import com.bedrockcloud.bedrockcloud.BedrockCloud;
import com.bedrockcloud.bedrockcloud.api.event.EventHandler;
import com.bedrockcloud.bedrockcloud.api.event.Listener;
import com.bedrockcloud.bedrockcloud.api.event.server.ServerStartEvent;
import com.bedrockcloud.bedrockcloud.api.plugin.Plugin;

public class Main extends Plugin implements Listener {
    @Override
    public void onEnable() {
        BedrockCloud.getLogger().info("enabled plugin");
        BedrockCloud.getInstance().getPluginManager().registerListener(this);
    }

    @EventHandler
    public void onServerStart(ServerStartEvent event) {
        BedrockCloud.getLogger().info("server started");
        System.out.println(event.getServer().getServerName());
    }
}