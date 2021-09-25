package de.devgaming.lavaflut.events;

import de.devgaming.lavaflut.Lavaflut;
import de.devgaming.lavaflut.commands.RunCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityDamageListener implements Listener {

    private EntityDamageListener plugin;
    Lavaflut lavaflut;
    private int time;
    private boolean gameHasEnded;

    public EntityDamageListener(){
        plugin = this;
    }

    @EventHandler
    public void countDown(final ServerListPingEvent event){
        if(gameHasEnded == true){
            BukkitRunnable runnable = new BukkitRunnable() {
                public void run(){
                    int countdown = 600;
                    if(countdown > 0){
                        countdown--;

                        event.setMotd("Nächstes Spiel in: " + countdown + " Sekunden");
                    }
                    if(time == 0){
                        gameHasEnded = false;
                        event.setMotd("§cEin Spiel läuft bereits!");
                    }
                }
            };
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(time == 0) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
            if(time > 0) {
                event.setCancelled(true);
            }
    }

    @EventHandler
    public void onFoodLevel(final FoodLevelChangeEvent event) {
        if(time > 0) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(final PlayerPickupItemEvent event) {
        if(time > 0) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(final PlayerDropItemEvent event) {
        if(time > 0) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(time == 0) {
                event.setCancelled(true);
            }

        }
    }
}
