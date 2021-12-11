package me.devtarix.jarsmp.util.handles;

import me.devtarix.jarsmp.util.CI;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class UserHandles {
    Player user;
    public void userToBed(Player user) {
        this.user = user;

        user.teleport(user.getBedSpawnLocation());
    }

    public void userToSpawn(Player user) {
        this.user = user;

        user.teleport(user.getWorld().getSpawnLocation());
    }
    
    Player user2;
    
    public void userToUser(Player user, Player user2) {
        this.user = user;
        this.user2 = user2;

        user.teleport(user2.getLocation());
        user.sendMessage(CI.S + "You have been teleported to " + user2.getDisplayName() + ".");
        user.playSound(user.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1,1);

        user2.playNote(user2.getLocation(), Instrument.CHIME, Note.natural(3, Note.Tone.E));
        user2.sendMessage(CI.I + user.getDisplayName() + " has teleported to you.");
    }

    public void strikeUser(Player user) {
        this.user = user;

        Bukkit.getServer().getWorld("world").strikeLightning(user.getLocation());
    }

    public void healUser(Player user) {
        this.user = user;

        user.setFallDistance(0);
        user.setFireTicks(0);
        user.setSaturation(20);
        user.setFoodLevel(20);
        if (user.getHealth() < 16) {
            user.setHealth(user.getHealth() + (user.getHealth() / 4));
        }
    }
}
