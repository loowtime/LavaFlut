package de.devgaming.lavaflut;

import de.devgaming.lavaflut.commands.AutoStart;
import de.devgaming.lavaflut.commands.RunCommand;
import de.devgaming.lavaflut.events.EntityDamageListener;
import de.devgaming.lavaflut.events.LobbyStateListeners;
import de.devgaming.lavaflut.listener.PlayerDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public final class Lavaflut extends JavaPlugin {

    private static Lavaflut plugin;
    public static Lavaflut instance;
    public static final String PREFIX = "§8[§1LavaFlood§8] ";
    private int time;


    @Override
    public void onEnable() {
        plugin = this;
        System.out.println(Lavaflut.PREFIX + "§aPlugin gestartet!");
        this.registerCommands();

        Bukkit.getPluginManager().registerEvents(new LobbyStateListeners(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(), this);

    }

    public void registerCommands() {
        this.getCommand("start").setExecutor(new RunCommand());
        this.getCommand("autostart").setExecutor(new AutoStart());
    }

    @Override
    public void onDisable() {
        System.out.println(Lavaflut.PREFIX + "§cPlugin deaktiviert!");
    }


    public static Lavaflut getPlugin() {
        return plugin;
    }

}
