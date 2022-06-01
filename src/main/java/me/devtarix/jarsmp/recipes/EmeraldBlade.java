package me.devtarix.jarsmp.recipes;

import me.devtarix.jarsmp.supers.CustomShapedRecipe;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ShapedRecipe;

public class EmeraldBlade extends CustomShapedRecipe {
    public EmeraldBlade() {
        setName("em_blade");
        setMaterial(Material.EMERALD);

        meta.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 4, true);
        AttributeModifier modifier = new AttributeModifier("emBladeMod", 1, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,modifier);
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(key, result);
        r.shape("x","e","s");
        r.setIngredient('e',Material.EMERALD);
        r.setIngredient('x',Material.NETHER_STAR);
        r.setIngredient('s',Material.STICK);

        setRecipe(r);
        register(r,getKey());
    }
}
