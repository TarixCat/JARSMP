package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.registries.ShapedRecipeProvider;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static me.devtarix.jarsmp.util.handles.Logger.print;

public class GiveItem extends BukkitCommand {
    public GiveItem(String name) {
        super(name);
        this.description = "Give item command";
        this.setUsage("/giveitem");
        this.setPermission("jarsmp.dev");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if(ShapedRecipeProvider.recipeRegistry.containsKey(args[0])) {
                p.getInventory().addItem(ShapedRecipeProvider.recipeRegistry.get(args[0]));
            }
            else {
                print(args[0] + " is not in the registry, please try again...");
            }
        }
        else {
            print("This is a player only command");
        }

        return true;
    }
}
