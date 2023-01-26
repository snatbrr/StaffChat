package me.snat.staffchat;

import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("staffchat").setExecutor(new StaffChat(this));
    }
}
