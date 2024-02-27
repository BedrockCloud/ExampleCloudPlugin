package de.test.plugin.commands;

import com.bedrockcloud.bedrockcloud.Cloud;
import com.bedrockcloud.bedrockcloud.utils.command.Command;

public class TestCommand extends Command {
    public TestCommand(String cmd, String usage, String description) {
        super(cmd, usage, description);
    }

    @Override
    public void onCommand(String[] args) {
        Cloud.getLogger().info("Test command executed");
    }
}
