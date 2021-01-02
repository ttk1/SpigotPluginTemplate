package net.ttk1.spigotplugintemplate;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SpigotPluginTemplate extends JavaPlugin {
    private Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();
        logger.info("Hello!");

        saveDefaultConfig();
        Configuration config = getConfig();
        logger.info(config.getString("test"));
    }

    @Override
    public void onDisable() {
        logger.info("Bye!");
    }
}
