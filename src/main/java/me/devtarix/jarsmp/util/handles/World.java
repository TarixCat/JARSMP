package me.devtarix.jarsmp.util.handles;

import org.bukkit.Location;

/**
 * Currently unused
 */
public class World {
    /**
     * Returns an area of blocks from target to an x,y,z from the target as a volume
     * @param loc Location
     * @param x X-offset
     * @param y Y-offset
     * @param z Z-offset
     * @return This is broken :)
     */
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
