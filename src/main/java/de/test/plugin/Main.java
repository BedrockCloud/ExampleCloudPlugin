package de.test.plugin;

import com.bedrockcloud.bedrockcloud.BedrockCloud;
import com.bedrockcloud.bedrockcloud.api.event.EventHandler;
import com.bedrockcloud.bedrockcloud.api.event.Listener;
import com.bedrockcloud.bedrockcloud.api.event.server.ServerStartEvent;
import com.bedrockcloud.bedrockcloud.api.event.server.ServerStopEvent;
import com.bedrockcloud.bedrockcloud.api.plugin.Plugin;
import de.test.plugin.commands.TestCommand;

public class Main extends Plugin implements Listener {
    @Override
    public void onEnable() {
        BedrockCloud.getLogger().info("enabled plugin");
        BedrockCloud.getInstance().getPluginManager().registerListener(this);
        this.getCloud().getPluginManager().getCommandManager().registerCommand(new TestCommand("test", "test", "Test command"));
    }

    @EventHandler
    public void onServerStart(ServerStartEvent event) {
        BedrockCloud.getLogger().info("server started");
    }

    @EventHandler
    public void onServerStop(ServerStopEvent event) {
        BedrockCloud.getLogger().info("server stopped");
    }
}