package de.devgaming.lavaflut.commands;

import de.devgaming.lavaflut.Lavaflut;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;

public class RunCommand implements CommandExecutor {
    private int time;
    private boolean gameHasEnded;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        time = 15;

        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                switch (time){
                    case 15:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l " + time + " Sekunden", "§aBis zum Start!");
                        });
                        break;
                    case 10:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l " + time + " Sekunden", "§aBis zum Start!"); 
                        });
                        break;
                    case 5:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l " + time + " Sekunden", "§aBis zum Start!");
                        });
                        break;
                    case 4:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Start!");
                        });
                        break;
                    case 3:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Start!");
                        });
                        break;
                    case 2:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Start!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Start!");
                        });
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunde verbleibend, bis zum Start!");
                        Bukkit.getServer().setWhitelist(true);
                        for (final Player target : Bukkit.getOnlinePlayers()) {
                            target.setWhitelisted(true);
                        }
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunde", "§aBis zum Start!");
                        });
                        break;
                }

                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setLevel(time);
                    player.setExp(time / 15);
                });

                if (time == 0) {
                    if (gameHasEnded == true){
                    int countdown = 600;
                    Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aDas Minispiel hat bekommen, mit einer 5 Minuten Schutzzeit, wo dich keiner angreifen kann!");
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.setLevel(10);
                        player.setExp(10);
                        player.playSound(player.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        player.sendTitle(Lavaflut.PREFIX + "ist gestartet!", "§a§lMit einer 5 Minuten Schutzzeit!");
                    });
                    cancel();
                    return;
                }}
                time--;
            }
        };
        runnable.runTaskTimer(Lavaflut.getPlugin() , 0, 20);

        return true;
    }
}
