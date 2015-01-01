package mlxy.nekobags.recipe;

import mlxy.nekobags.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModItems.kuroNekoBag, 1), new Object[]{
			"* *",
			"###",
			"###",
			'#', Blocks.wool,
			'*', Items.string
		});
	}
}
