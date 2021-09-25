package de.devgaming.lavaflut.listener;

import de.devgaming.lavaflut.Lavaflut;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerDeathListener implements Listener
{
    private Lavaflut plugin;
    Lavaflut lavaflut;

    public PlayerDeathListener() {
        this.lavaflut = null;
        this.plugin = lavaflut;
    }

    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        final Player p = e.getEntity().getPlayer();
        final Player k = e.getEntity().getKiller();
        p.setGameMode(GameMode.SPECTATOR);
        p.sendTitle("§c§lDu bist ausgeschieden!", "§a§l");

        final EntityDamageEvent lastDamage = p.getLastDamageCause();
        if (lastDamage == null) {
            return;
        }
        final EntityDamageEvent.DamageCause cause = lastDamage.getCause();
        if (cause.equals((Object)EntityDamageEvent.DamageCause.SUICIDE)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " begang Selbstmord.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.CUSTOM)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " starb.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " spielte mit TNT.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.CONTACT)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " spie\u00df sich auf einem Kaktus auf.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.DROWNING)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " hat die Sauerstoffflasche vergessen.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " wollte mit einem Creeper tanzen.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.FALL)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " starb an Fallschaden.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.FIRE)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " hatte nicht genug Wasser um sich zu l\u00f6schen.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.FIRE_TICK)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " verbrannte.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.LAVA)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " verbrannte in Lava.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.MAGIC)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " wurde von einem Damage Poiton getroffen.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.POISON)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " experimentierte mit Tr\u00e4nken.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.PROJECTILE)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " wurde von " + ChatColor.AQUA + k.getName() + ChatColor.RED + " erschossen.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.STARVATION)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " verhungerte.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.SUFFOCATION)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " erstickte ohne Grund.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.VOID)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " fiel aus der Welt.");
        }
        else if (cause.equals((Object)EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            e.setDeathMessage(Lavaflut.PREFIX + ChatColor.GRAY + p.getName() + ChatColor.RED + " wurde von " + ChatColor.AQUA + k.getName() + ChatColor.RED + " get\u00f6tet.");
        }
        else {
            e.setDeathMessage(Lavaflut.PREFIX + String.valueOf(e.getEntity().getName()) + " starb.");
        }
    }
}
