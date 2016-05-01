package simplemods.cheesemod.items;

import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemBagelSandwich extends ItemFood{

	public ItemBagelSandwich(int hmod, float smod,
			boolean wmod) {
		super(hmod, smod, wmod);
		setUnlocalizedName("bagel_sandwich");
		setCreativeTab(CCreativeTabs.tabFood);
		setMaxStackSize(32);
		setTextureName("cheesemod:bagel_sandwich");
	}

}
