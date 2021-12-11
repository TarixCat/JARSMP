package me.devtarix.jarsmp.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class CustomMobListeners implements Listener {

    @EventHandler
    public void zombieSpawn(EntitySpawnEvent event) {
        if(event.getEntityType().equals(EntityType.ZOMBIE)){
            Ageable a = (Ageable) event.getEntity();
            if(!a.isAdult()) {
                if (Math.random() * 100 < 50) {
                    a.setAdult();
                }
            }
        }
    }
}
