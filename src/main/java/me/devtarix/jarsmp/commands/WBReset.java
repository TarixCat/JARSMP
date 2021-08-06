package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.handles.Notifs;
import me.devtarix.jarsmp.util.handles.UserHandles;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WBReset implements CommandExecutor {
    UserHandles uh = new UserHandles();
    Notifs n = new Notifs();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage("Resetting worldborder");
            player.setFallDistance(0);
            try {
                uh.userToBed(player);
            }
            catch (Exception e) {
                n.noBedFound(player);
                uh.userToSpawn(player);
            }
            uh.healUser(player);
            Bukkit.getScheduler().cancelTask(Integer.parseInt(args[0]));
            Bukkit.getServer().getWorld("world").getWorldBorder().setCenter(0,0);
            Bukkit.getServer().getWorld("world").getWorldBorder().setSize(526);
            return true;
        }
        else {
            n.notUser(sender);
            return false;
        }
    }
}
