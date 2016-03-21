package net.coreprotect;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Corrector extends JavaPlugin {
    private static Corrector instance;

    public static Corrector getInstance() {
        if (instance == null) {
            instance = new Corrector();
        }
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        PluginDescriptionFile pdfFile = this.getDescription();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
    }

}