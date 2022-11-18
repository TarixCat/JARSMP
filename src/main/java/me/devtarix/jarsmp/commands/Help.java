package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Logger;
import me.devtarix.jarsmp.util.handles.Notifs;
import me.devtarix.jarsmp.util.handles.UserHandles;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class Help extends Notifs implements CommandExecutor {
    UserHandles uh = new UserHandles();
    Notifs n = new Notifs();
    Logger logger = new Logger();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            player.setFallDistance(0);
            try {
                uh.userToBed(player);
            }
            catch (Exception e) {
                n.noBedFound(player);
                uh.userToSpawn(player);
            }
            uh.healUser(player);

            player.setExp(0f);
            player.sendMessage(CI.E + "Your Experience was removed as punishment.");

            logger.log(Level.INFO, "SS command used...");

            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1,1);
        }
        else{
            n.notUser(sender);
        }
        return true;
    }
}
