package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.handles.Notifs;
import me.devtarix.jarsmp.util.handles.UserHandles;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WBReset extends BukkitCommand {
    Notifs n = new Notifs();
    UserHandles uh = new UserHandles();

    public WBReset(String name) {
        super(name);
        this.description = "Resets the worldborder using scheduler canceller";
        this.setUsage("/wbreset <int>");
        this.setPermission("jarsmp.player");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
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
            return true;
        }
    }

}
