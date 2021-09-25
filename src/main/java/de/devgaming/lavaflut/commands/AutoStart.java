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

public class AutoStart implements CommandExecutor {
    private int time;
    private boolean gameHasEnded;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        time = 300;

        BukkitRunnable runnable = new BukkitRunnable() {

            @Override
            public void run() {
                switch (time){
                    case 300:
                        break;
                    case 10:
                        break;
                    case 5:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Ende!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Ende!");
                        });
                        break;
                    case 4:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Ende!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Ende!");
                        });
                        break;
                    case 3:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Ende!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Ende!");
                        });
                        break;
                    case 2:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunden verbleibend, bis zum Ende!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Ende!");
                        });
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Lavaflut.PREFIX + "§aNoch " + time + " Sekunde verbleibend, bis zum Ende!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                            player.sendTitle("§e§l" + time + " Sekunden", "§aBis zum Ende!");
                        });
                        break;
                }

                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setLevel(time);
                    player.setExp(time / 300);
                });

                if (time == 0) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
                    Bukkit.broadcastMessage(Lavaflut.PREFIX + "§cDer Server stoppt jetzt!");
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.playSound(player.getLocation() , Sound.BLOCK_COMPARATOR_CLICK, 1, 1);
                        player.sendTitle("§7Das Spiel", "§cEndet!");
                    });
                        cancel();
                        return;
                    }
                time--;
            }
        };
        runnable.runTaskTimer(Lavaflut.getPlugin() , 0, 6300);

        return true;
    }
}
