package simplemods.cheesemod.items;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.item.ItemFood;
public class ItemFriedEgg extends ItemFood{

	public ItemFriedEgg(int p_i45339_1_, float p_i45339_2_,boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setTextureName("cheesemod:fried_egg");
		setMaxStackSize(64);
		setUnlocalizedName("fried_egg");
		setCreativeTab(CCreativeTabs.tabFood);
	}
	
}
