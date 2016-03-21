package net.coreprotect;

import org.bukkit.plugin.java.JavaPlugin;

public class Corrector extends JavaPlugin {
    private static Corrector instance;

    public static Corrector getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

}