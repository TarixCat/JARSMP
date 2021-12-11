package me.devtarix.jarsmp.util.handles;

import org.bukkit.Location;

public class World {
    public int[][] area(Location loc, int x, int y, int z) {
        int lx = loc.getBlockX();
        int ly = loc.getBlockY();
        int lz = loc.getBlockZ();

        int[][] m = {
                {lx + x, ly + y, lz + z},
                {lx, ly, lz},
                {lx - x, ly - y, lz - z}
        };

        return m;
    }
}
