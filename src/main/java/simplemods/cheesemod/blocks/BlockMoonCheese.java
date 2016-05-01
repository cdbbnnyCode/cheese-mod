package simplemods.cheesemod.blocks;

import java.util.Random;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.CommonProxy;
import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockMoonCheese extends Block {

	public BlockMoonCheese(Material p_i45394_1_) {
		super(p_i45394_1_);
		setHardness(3.0F);
		setResistance(15.0F);
		setStepSound(soundTypePiston);
		setBlockName("moon_cheese_ore");
		setCreativeTab(CCreativeTabs.tabBlock);
		setBlockTextureName("cheesemod:moon_cheese_ore");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return CommonProxy.moon_cheese;
	}
	
	
}
