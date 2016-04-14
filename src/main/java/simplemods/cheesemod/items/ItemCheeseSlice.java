package simplemods.cheesemod.items;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.item.ItemFood;
public class ItemCheeseSlice extends ItemFood{

	public ItemCheeseSlice(int p_i45339_1_, float p_i45339_2_,boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setTextureName("cheesemod:cheese_slice");
		setMaxStackSize(64);
		setUnlocalizedName("cheese_slice");
		setCreativeTab(CCreativeTabs.tabFood);
	}
	
}
