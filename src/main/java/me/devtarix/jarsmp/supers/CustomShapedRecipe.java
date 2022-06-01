package me.devtarix.jarsmp.supers;

import me.devtarix.jarsmp.JARSMP;
import me.devtarix.jarsmp.registries.ShapedRecipeProvider;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import static me.devtarix.jarsmp.util.handles.Logger.print;

public abstract class CustomShapedRecipe{
    JARSMP p = JARSMP.getPlugin(JARSMP.class);

    protected String name;
    protected NamespacedKey key;

    protected void setName(String name) {
        this.name = name;

        this.key = new NamespacedKey(this.p, name);

    }

    protected ShapedRecipe recipe;
    protected Material material;
    public ItemStack result;
    protected ItemMeta meta;

    protected void setMaterial(Material material) {
        this.material = material;
        ItemStack result = new ItemStack(material);
        this.meta = result.getItemMeta();
        this.result = result;

    }


    protected void setRecipe(ShapedRecipe recipe) {
        this.recipe = recipe;
    }

    public ShapedRecipe getRecipe() {
        return this.recipe;
    }

    public NamespacedKey getKey() {
        return this.key;
    }

    public void register(Recipe recipe, NamespacedKey key) {
        ShapedRecipeProvider.recipeRegistry.put(key.toString(), result);
        Bukkit.getServer().addRecipe(recipe);
        print("Registering crafting recipe: " + key);
    }
}
