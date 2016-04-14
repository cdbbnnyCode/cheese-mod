package simplemods.cheesemod.items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBucketVinegar extends Item { 
	public ItemBucketVinegar() {
		setTextureName("cheesemod:bucket_vinegar");
		setUnlocalizedName("bucket_vinegar");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
        return p_77654_1_.stackSize <= 0 ? new ItemStack(Items.bucket) : p_77654_1_;
    }
}
