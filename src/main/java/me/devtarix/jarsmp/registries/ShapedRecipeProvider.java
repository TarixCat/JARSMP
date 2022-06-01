package me.devtarix.jarsmp.registries;

import me.devtarix.jarsmp.recipes.EmeraldBlade;
import me.devtarix.jarsmp.recipes.EnchantedBook;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static me.devtarix.jarsmp.util.handles.Logger.print;

public class ShapedRecipeProvider {
    public static HashMap<String, ItemStack> recipeRegistry = new HashMap<>();

    public void test() {
        recipeRegistry.forEach((namespacedKey, itemStack) -> print("Registered: " + namespacedKey));
    }
    public ShapedRecipeProvider() {
        init();
        test();
    }

    public void init() {
        new EnchantedBook();
        new EmeraldBlade();
    }
}
