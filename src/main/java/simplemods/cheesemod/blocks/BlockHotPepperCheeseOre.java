package simplemods.cheesemod.blocks;

import java.util.Random;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.CommonProxy;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
/**
 * No, this is not a hopper...
 */
public class BlockHotPepperCheeseOre extends Block{

	public BlockHotPepperCheeseOre(Material p_i45394_1_) {
		super(Material.rock);
		setCreativeTab(CCreativeTabs.tabBlock);
		setBlockName("pepper_cheese_ore");
		setBlockTextureName("cheesemod:pepper_cheese_ore");
		setLightLevel(0.325F);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return CommonProxy.hot_pepper_cheese;
	}
	
}
