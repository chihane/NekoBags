package mlxy.nekobags.slot;

import mlxy.nekobags.item.ItemKuroNekoBag;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotKuroNekoBag extends Slot {
	public SlotKuroNekoBag(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return !(itemstack.getItem() instanceof ItemKuroNekoBag);
	}
}
