package simplemods.cheesemod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBucketBoilingSaltyMilk extends Item{
	public ItemBucketBoilingSaltyMilk() {
		setTextureName("minecraft:bucket_milk").setUnlocalizedName("bucket_boiling_salt_milk");
	}

	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_,
			EntityPlayer p_77654_3_) {
		return new ItemStack(Items.bucket);
	}
	
}
