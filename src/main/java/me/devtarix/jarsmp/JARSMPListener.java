package me.devtarix.jarsmp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Listeners for JARSMP
 */
public class JARSMPListener implements Listener {

    /**
     * Event that runs on player join, adds them to the online HashMap and makes a greeting
     * @param event PlayerJoinEvent
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String playerName = p.getDisplayName();
        p.sendMessage(ChatColor.GOLD + "Welcome " + playerName + " to the server.");
        JARSMP.online.add(p);
    }

    /**
     * Event that runs on player quit, removes them from the online HashMap
     * @param e PlayerQuitEvent
     */
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        JARSMP.online.remove(e.getPlayer());
    }

    /**
     * Event that runs on a player kick, broadcasts the kick reason to the server
     * @param event PlayerKickEvent
     */
    @EventHandler
    public void onKick(PlayerKickEvent event) {
        JARSMP.broadcastMessage("User " + event.getPlayer().getDisplayName() + " has just been kicked for: " + event.getReason());
    }

    /**
     * Event that runs on player death, prints coords to console and to the player. Gives a customized death message to some
     * @param event PlayerDeathEvent
     */
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getEntity().sendMessage("Death at X= " + event.getEntity().getLocation().getBlockX() + " Y= " + event.getEntity().getLocation().getBlockY() + " Z= " + event.getEntity().getLocation().getBlockZ());
        System.out.println(event.getEntity().getDisplayName() + " died at: X= " + event.getEntity().getLocation().getBlockX() + " Y= " + event.getEntity().getLocation().getBlockY() + " Z= " + event.getEntity().getLocation().getBlockZ() + " in dimension " + event.getEntity().getLocation().getWorld().getEnvironment());
        switch (event.getEntity().getDisplayName()){
            case "TarixCat":
                Bukkit.getServer().broadcastMessage(ChatColor.RED + "NOOOOOO!!!");
                break;
            case "TarixCat33":
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "how did the admin die?");
                break;
            case "TarixCat22":
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "huh? admin ded");
                break;
            case "Personpacman":
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "*rages*");
                break;
            case "pengypoo":
                Bukkit.getServer().broadcastMessage(ChatColor.AQUA + "another to the death tally!");
                break;
            case "supersebii":
                Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "rest in pepperoni");
                break;
            case "GentlemanCav":
                Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "ah no!");
                break;
            case "OmegaPieZ":
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_AQUA + "not gameing");
                break;
            case "0ctobro":
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_PURPLE + "I HAVE PERISHED");
                break;
            default:
                Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "RIP...");
                break;
        }
    }
}
