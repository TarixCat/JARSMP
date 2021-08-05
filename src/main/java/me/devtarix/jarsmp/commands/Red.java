package me.devtarix.jarsmp.commands;

import me.devtarix.jarsmp.util.handles.Notifs;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Red implements CommandExecutor {
    Notifs n = new Notifs();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack i = new ItemStack(Material.POTION, 1);
            PotionMeta metap = (PotionMeta) i.getItemMeta();

            List<String> l = new ArrayList<>();
            l.add("Only for those who are worthy");

            metap.setColor(Color.RED);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 2147483646, 28), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.HUNGER, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 2147483646, 127), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 2147483646, 5), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.WITHER, 2147483646, 3), true);
            metap.addCustomEffect(new PotionEffect(PotionEffectType.UNLUCK, 2147483646, 127), true);
            metap.setLore(l);
            metap.setDisplayName("Red");

            i.setItemMeta(metap);

            player.getInventory().addItem(i);
        }
        else {
            n.notUser(sender);
        }
        return true;
    }
}
