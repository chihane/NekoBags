package mlxy.nekobags.item;

import java.util.List;
import java.util.UUID;

import mlxy.nekobags.NekoBags;
import mlxy.nekobags.constant.Constants;
import mlxy.nekobags.inventory.InventoryKuroNeko;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemKuroNekoBag extends Item {
	public static final String NAME = "kuronekobag";
	
	public ItemKuroNekoBag() {
		setUnlocalizedName(NAME);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setTextureName(Constants.MOD_ID + ":" + NAME);
		GameRegistry.registerItem(this, NAME);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		entityPlayer.openGui(NekoBags.instance, NekoBags.GUI_ID_KURONEKO, world,
				(int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ);
		
		return super.onItemRightClick(itemStack, world, entityPlayer);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 1;
	}
}
