package com.nextgendan;

import org.bukkit.plugin.java.JavaPlugin;

public class Corrector extends JavaPlugin {
    private static Corrector instance;

    protected static Corrector getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

}