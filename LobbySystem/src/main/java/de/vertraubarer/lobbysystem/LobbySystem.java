package de.vertraubarer.lobbysystem;

import de.vertraubarer.lobbysystem.commands.*;
import de.vertraubarer.lobbysystem.listeners.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new InteractEventListener(), this);
        pluginManager.registerEvents(new DropEventListener(), this);
        pluginManager.registerEvents(new JoinEventListener(), this);
        pluginManager.registerEvents(new QuitEventListener(), this);
        pluginManager.registerEvents(new FoodLevelChange(), this);
        pluginManager.registerEvents(new DamageEventListener(), this);

        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
    }
}
