package simplemods.cheesemod.items;

import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCheeseWedge extends Item {
	public ItemCheeseWedge() {
		setMaxStackSize(64);
		setCreativeTab(CCreativeTabs.tabFood);
		setUnlocalizedName("cheese_wedge");
		setTextureName("cheesemod:cheese_wedge");
	}
}
