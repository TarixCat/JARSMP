package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.JARSMP;
import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Logger;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class WorldBorder implements CommandExecutor {

    private JavaPlugin plugin =JavaPlugin.getProvidingPlugin(JARSMP.class);

    Notifs n = new Notifs();

    public double[] pCalc() {
        double locX, locZ, sumX, sumZ;
        sumX = 0;
        sumZ = 0;
        int nc = Bukkit.getServer().getOnlinePlayers().size();
        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

        for(int i = 0; i <= nc-1; ++i) {
            Player p = list.get(i);
            locX = p.getLocation().getX();
            sumX += locX;

            locZ = p.getLocation().getZ();
            sumZ += locZ;
        }

        sumX /= nc;
        sumZ /= nc;

        return new double[]{sumX, sumZ};
    }

    public void trigger() {
        double X, Z;
        double[] calc = pCalc();
        X = calc[0];
        Z = calc[1];
        Bukkit.getServer().getWorld("world").getWorldBorder().setCenter(X, Z);
    }

    public void triggerT(String target) {
        Player t = Bukkit.getPlayer(target);
        double X, Z;
        X = t.getLocation().getX();
        Z = t.getLocation().getZ();
        Bukkit.getServer().getWorld("world").getWorldBorder().setCenter(X, Z);
    }

    public int schedule(long cycledelay) {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this::trigger, 0L, cycledelay);
    }
    public int schedule(long cycledelay, String t) {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> triggerT(t), 0L, cycledelay);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int g = 0;

            switch (args.length) {
                case 0:
                    g = schedule(1);
                    Bukkit.getServer().getWorld("world").getWorldBorder().setSize(31);
                    break;
                case 1:
                    g = schedule(1);
                    Bukkit.getServer().getWorld("world").getWorldBorder().setSize(Double.parseDouble(args[0]));
                    break;
                case 2:
                    g = schedule(1, args[1]);
                    Bukkit.getServer().getWorld("world").getWorldBorder().setSize(Double.parseDouble(args[0]));
                    break;
                default:
                    player.sendMessage(CI.I + "Retry in the correct format /wbcalc [size] [target]");
                    break;
            }
            new Logger().log(Level.INFO, "Val = "+g);
            player.sendMessage(CI.W + "Active worldborder");
            return true;
        }
        else {
            n.notUser(sender);
            return true;
        }
    }


}
