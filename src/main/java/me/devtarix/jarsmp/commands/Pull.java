package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.JARSMP;
import me.devtarix.jarsmp.util.handles.Maths;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Pull implements CommandExecutor {
    Notifs n = new Notifs();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 4) {
                FileConfiguration f = JavaPlugin.getPlugin(JARSMP.class).getConfig();

                double blockX = player.getPlayer().getLocation().getBlockX();
                double blockY = player.getPlayer().getLocation().getBlockY();
                double blockZ = player.getPlayer().getLocation().getBlockZ();

                double tX = Integer.parseInt(args[0]);
                double tY = Integer.parseInt(args[1]);
                double tZ = Integer.parseInt(args[2]);

                double speed = Integer.parseInt(args[3]);

                double x = blockX - tX;
                double y = blockY - tY;
                double z = blockZ - tZ;

                Vector v = new Maths().vecpull(x,y,z,speed);

                player.setVelocity(v);
                return true;
            }
            else {
                n.missingargs(player, 4,"pull","x y z speed");
                return false;
            }
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
