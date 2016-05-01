package simplemods.cheesemod.inventory;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CCreativeTabs {
	public static CreativeTabs tabBlock = new CreativeTabs("blocks") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(CommonProxy.salt_ore);
		}
	};
	public static CreativeTabs tabFood = new CreativeTabs("cheese_food") {
		@Override
		public Item getTabIconItem() {
			return CommonProxy.cheese_wedge;
		}
	};
}
