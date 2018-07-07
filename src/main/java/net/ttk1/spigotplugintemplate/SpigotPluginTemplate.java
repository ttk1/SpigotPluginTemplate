package net.ttk1.spigotplugintemplate;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public class SpigotPluginTemplate extends JavaPlugin {
    private Logger logger;
    private Configuration config;

    @Inject
    private void setLogger(@Named("spigotplugintemplate") Logger logger) {
        this.logger = logger;
    }

    @Inject
    private void setConfig(Configuration config) {
        this.config = config;
    }

    public SpigotPluginTemplate() {
    }

    @Override
    public void onEnable() {
        initConfig();

        // injector
        PluginModule module = new PluginModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

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
                getLogger().info("config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("config.yml found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
