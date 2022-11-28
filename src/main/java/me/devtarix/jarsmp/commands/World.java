package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.registries.ShapedRecipeProvider;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.devtarix.jarsmp.util.handles.Logger.print;

public class World extends BukkitCommand {
    public World(String name) {
        super(name);
        this.description = "World command";
        this.setUsage("/world");
        this.setPermission("jarsmp.player");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args){
        if (sender instanceof Player) {
            Player p = (Player) sender;

            print(p.getWorld().getName());
        }
        else {
            print("This is a player only command");
        }

        return true;
    }
}
