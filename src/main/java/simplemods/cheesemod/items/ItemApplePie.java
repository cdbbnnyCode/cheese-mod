package simplemods.cheesemod.items;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.CommonProxy;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemApplePie extends Item {
	public ItemApplePie() {
		setMaxStackSize(64);
		setCreativeTab(CCreativeTabs.tabFood);
		setUnlocalizedName("apple_pie");
		setTextureName("cheesemod:apple_pie");
	}
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if(p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).isReplaceable(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_) && p_77648_7_ != 0)
        {
            p_77648_7_ = 1;
            p_77648_5_--;
        }
        if (p_77648_7_ == 0)
        {
            return false;
        }
        else if (!p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).getMaterial().isSolid() && !p_77648_3_.isSideSolid(p_77648_4_, p_77648_5_, p_77648_6_, net.minecraftforge.common.util.ForgeDirection.getOrientation(p_77648_7_)))
        {
            return false;
        }
        else
        {
            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }

        }
        {
            if (!p_77648_3_.isRemote)
            {
            	p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, CommonProxy.apple_pie_block);
            	p_77648_1_.stackSize--;
            }
            return true;
        }
    }
}
