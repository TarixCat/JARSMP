package me.devtarix.jarsmp.util;

import org.bukkit.ChatColor;

public enum DMsgs {
    TCAT("tcat","TarixCat", ChatColor.RED),
    TCAT33("tcat33","TarixCat33",ChatColor.DARK_RED),
    PPAC("ppac", "Personpacman",ChatColor.GOLD),
    PENG("peng", "penguinboi69",ChatColor.AQUA),
    SEBI("sebi","supersebii", ChatColor.GREEN),
    GCAV("gcav","GentlemanCav",ChatColor.BLUE),
    PIEZ("piez","OmegaPieZ",ChatColor.DARK_AQUA),
    OCTO("octo","0ctobro",ChatColor.DARK_PURPLE);

    private String shortname, usrname;
    private ChatColor color;

    DMsgs(String shortname, String usrname, ChatColor color) {
        this.shortname = shortname;
        this.usrname = usrname;
        this.color = color;
    }

    public String getShortname() {
        return this.shortname;
    }
    public String getUsrname() {
        return this.usrname;
    }
    public ChatColor getColor() {
        return this.color;
    }
    public String getConfigString() {
        return "user-msgs."+this.shortname;
    }
}
