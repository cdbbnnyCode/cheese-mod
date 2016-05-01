package simplemods.cheesemod.items;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
public class ItemPoisonedApple extends ItemFood{

	public ItemPoisonedApple(int p_i45339_1_, float p_i45339_2_,boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setTextureName("cheesemod:poisoned_apple");
		setMaxStackSize(64);
		setUnlocalizedName("poisoned_apple");
		setPotionEffect(Potion.hunger.id,300,0,1F);
		setAlwaysEdible();
		setCreativeTab(CCreativeTabs.tabFood);
	}
	
}
