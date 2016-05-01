package simplemods.cheesemod.items;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.item.ItemFood;
public class ItemBreadSlice extends ItemFood{
	public ItemBreadSlice(int p_i45339_1_, float p_i45339_2_,boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setTextureName("cheesemod:bread_slice");
		setMaxStackSize(64);
		setUnlocalizedName("bread_slice");
		setCreativeTab(CCreativeTabs.tabFood);
	}
}


