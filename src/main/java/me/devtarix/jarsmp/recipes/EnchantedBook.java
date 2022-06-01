package me.devtarix.jarsmp.recipes;

import me.devtarix.jarsmp.supers.CustomShapedRecipe;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ShapedRecipe;

public class EnchantedBook extends CustomShapedRecipe {
    public EnchantedBook() {
        setName("item");
        setMaterial(Material.BAKED_POTATO);

        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        result.setItemMeta(meta);

        ShapedRecipe rr = new ShapedRecipe(key, result);
        rr.shape("xxx","xxx","xxx");
        rr.setIngredient('x', Material.STICK);

        super.recipe = rr;
        register(rr, getKey());
    }
}
