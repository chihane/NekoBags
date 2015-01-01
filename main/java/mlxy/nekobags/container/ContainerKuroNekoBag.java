package mlxy.nekobags.container;

import mlxy.nekobags.slot.SlotKuroNekoBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerKuroNekoBag extends Container {
	private IInventory lowerChestInventory;
	private int numRows;

	public ContainerKuroNekoBag(IInventory inventoryPlayer,
			IInventory inventoryBag) {
		this.lowerChestInventory = inventoryBag;
		this.numRows = inventoryBag.getSizeInventory() / 9;
		inventoryBag.openInventory();
		int i = (this.numRows - 4) * 18;
		int j;
		int k;

		for (j = 0; j < this.numRows; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new SlotKuroNekoBag(inventoryBag, k + j * 9,
						8 + k * 18, 18 + j * 18));
			}
		}

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				this.addSlotToContainer(new Slot(inventoryPlayer,
						k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		for (j = 0; j < 9; ++j) {
			this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18,
					161 + i));
		}
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return this.lowerChestInventory.isUseableByPlayer(p_75145_1_);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (p_82846_2_ < this.numRows * 9) {
				if (!this.mergeItemStack(itemstack1, this.numRows * 9,
						this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9,
					false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer p_75134_1_) {
		super.onContainerClosed(p_75134_1_);
		this.lowerChestInventory.closeInventory();
	}

	/**
	 * Return this chest container's lower chest inventory.
	 */
	public IInventory getLowerChestInventory() {
		return this.lowerChestInventory;
	}

	@Override
	public ItemStack slotClick(int slot, int button, int flag,
			EntityPlayer player) {
		if (slot >= 0 && getSlot(slot) != null
				&& getSlot(slot).getStack() == player.getHeldItem()) {
			return null;
		}
		return super.slotClick(slot, button, flag, player);
	}

}
