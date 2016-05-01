package simplemods.cheesemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemCreamCheesePickaxe extends ItemPickaxeFood {

	public ItemCreamCheesePickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_, 10, 0.8F, false);
		setTextureName("cheesemod:cream_cheese_pickaxe");
		setUnlocalizedName("cream_cheese_pickaxe");
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabTools);
	}
	
}
