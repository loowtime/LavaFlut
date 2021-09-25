package de.devgaming.lavaflut.events;

import de.devgaming.lavaflut.Lavaflut;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

import java.util.Set;

public class LobbyStateListeners implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();


        player.setMaxHealth(6.0);
        player.setFoodLevel(20);
        player.setGameMode(GameMode.SURVIVAL);

        //SCOREBOARD
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objektive = board.registerNewObjective("abcd", "abcd");
        objektive.setDisplaySlot(DisplaySlot.SIDEBAR);
        objektive.setDisplayName(Lavaflut.PREFIX + "");
        objektive.getScore("§8§m------------------------").setScore(9);
        objektive.getScore("").setScore(8);
        objektive.getScore("§8\u258c §7Dein Name").setScore(7);
        objektive.getScore("§8\u27a5 §e" + player.getName()).setScore(6);
        objektive.getScore("§2").setScore(5);
        objektive.getScore("§8\u258c §7Discord").setScore(4);
        objektive.getScore("§8\u27a5 §e.gg/XBQkgWDCmD").setScore(3);
        objektive.getScore("§3").setScore(2);
        objektive.getScore("§8§m-----------------------").setScore(1);
        objektive.getScore("         §6§lDevGaming.de").setScore(0);
        player.setScoreboard(board);

        event.setJoinMessage(Lavaflut.PREFIX + "§8[§a+§8] §7" + player.getName());
    }

    @EventHandler
    public void onLeft(final PlayerQuitEvent event){
        final Player player = event.getPlayer();

        event.setQuitMessage(Lavaflut.PREFIX + "" + "§8[§c-§8] §7" + player.getName());
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
    }

    @EventHandler
    public void onHit(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            event.setCancelled(true);
        }
    }

}
