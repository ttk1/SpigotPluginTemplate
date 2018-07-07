package net.ttk1.spigotplugintemplate;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public class SpigotPluginTemplate extends JavaPlugin {
    private Logger logger;
    private Configuration config;

    public SpigotPluginTemplate() {
    }

    @Override
    public void onEnable() {
        logger = getLogger();
        initConfig();
        config = getConfig();

        logger.info("SpigotPluginTemplate enabled");
        logger.info((String) config.get("test", "test"));
    }

    @Override
    public void onDisable() {
        logger.info("SpigotPluginTemplate disabled");
    }

    private void initConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                logger.info("config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                logger.info("config.yml found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
