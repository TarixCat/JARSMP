package me.devtarix.jarsmp.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

/**
 * Separate Listeners to customize mob behavior
 */
public class CustomMobListeners implements Listener {

    /**
     * Reduces the chance of a baby zombie spawning by ((Math.random() * 100) < 50)
     * @param event
     */
    @EventHandler
    public void zombieSpawn(EntitySpawnEvent event) {
        if(event.getEntityType().equals(EntityType.ZOMBIE)){
            Ageable a = (Ageable) event.getEntity();
            if(!a.isAdult()) {
                if ((Math.random() * 100) < 50) {
                    a.setAdult();
                }
            }
        }
    }
}
