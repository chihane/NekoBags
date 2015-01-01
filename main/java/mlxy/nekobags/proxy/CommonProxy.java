package mlxy.nekobags.proxy;

import mlxy.nekobags.NekoBags;
import mlxy.nekobags.container.ContainerKuroNekoBag;
import mlxy.nekobags.gui.GUIKuroNeko;
import mlxy.nekobags.inventory.InventoryKuroNeko;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public void registerRenderers() {
	}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player,
			World world, int x, int y, int z) {
		if (guiId == NekoBags.GUI_ID_KURONEKO) {
			return new ContainerKuroNekoBag(player.inventory, new InventoryKuroNeko(player.getHeldItem()));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player,
			World world, int x, int y, int z) {
		if (guiId == NekoBags.GUI_ID_KURONEKO) {
			return new GUIKuroNeko(player.inventory, new InventoryKuroNeko(player.getHeldItem()));
		}
		return null;
	}
}
