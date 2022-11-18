package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.CI;
import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class NameTag extends BukkitCommand {
    Notifs n = new Notifs();

    public NameTag(String name) {
        super(name);
        this.description = "Gives a name tag to the player";
        this.setUsage("/nametag");
        this.setPermission("jarsmp.player");
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack nametag = new ItemStack(Material.NAME_TAG, 1);
            ItemMeta meta = nametag.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("A nametag...");


            meta.setDisplayName("Lolface");
            meta.setLocalizedName("Lolface");
            meta.setLore(lore);
            nametag.setItemMeta(meta);

            player.getInventory().addItem(nametag);
            player.sendMessage(CI.S + "Nametag given");
        }
        else {
            n.notUser(sender);
        }
        return true;
    }

}
