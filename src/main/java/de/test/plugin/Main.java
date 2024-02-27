package de.test.plugin;

import com.bedrockcloud.bedrockcloud.Cloud;
import com.bedrockcloud.bedrockcloud.api.event.EventHandler;
import com.bedrockcloud.bedrockcloud.api.event.Listener;
import com.bedrockcloud.bedrockcloud.api.event.server.ServerStartEvent;
import com.bedrockcloud.bedrockcloud.api.event.server.ServerStopEvent;
import com.bedrockcloud.bedrockcloud.api.plugin.Plugin;
import de.test.plugin.commands.TestCommand;

public class Main extends Plugin implements Listener {
    @Override
    public void onEnable() {
        Cloud.getLogger().info("enabled plugin");
        Cloud.getInstance().getPluginManager().registerListener(this);
        this.getCloud().getPluginManager().getCommandManager().registerCommand(new TestCommand("test", "test", "Test command"));
    }

    @EventHandler
    public void onServerStart(ServerStartEvent event) {
        Cloud.getLogger().info("server " + event.getServer().getServerName() + " started");
    }

    @EventHandler
    public void onServerStop(ServerStopEvent event) {
        Cloud.getLogger().info("server " + event.getServer().getServerName() + " stopped");
    }
}