package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Logger;
import me.devtarix.jarsmp.util.handles.Notifs;
import me.devtarix.jarsmp.util.handles.UserHandles;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class SpecMode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Notifs n = new Notifs();
        UserHandles uh = new UserHandles();
        Logger logger = new Logger();
            if (sender instanceof Player) {
                Player player = (Player) sender;
                try {
                    switch (args[0]) {
                        case "on":
                            if(player.getGameMode() == GameMode.SURVIVAL){
                                player.setGameMode(GameMode.SPECTATOR);
                            }
                            else {
                                player.sendMessage(CI.E + "You need to have camacc off to use this command...");
                            }
                            break;
                        case "off":
                            if(player.getGameMode() == GameMode.SPECTATOR) {
                                player.setGameMode(GameMode.SURVIVAL);
                                try {
                                    uh.userToBed(player);
                                } catch (Exception e) {
                                    n.noBedFound(player);
                                    uh.userToSpawn(player);
                                } finally {
                                    player.setFallDistance(0);
                                }
                            }
                            else {
                                player.sendMessage(CI.E + "You need to have camacc on to use this command...");
                            }
                            break;
                        default:
                            player.sendMessage("Argument <on/off> required: /camacc on or /camacc off. You will be teleported to your bed on off.");
                            break;
                    }
                }
                catch (Exception e) {
                    n.criticalError(player);
                    logger.log(Level.SEVERE, e.getMessage());
                    player.sendMessage(CI.I + "Argument <on/off> required: /camacc on or /camacc off. You will be teleported to your bed on off.");
                }
            }
            else {
                n.notUser(sender);
            }
        return true;
    }
}
