package simplemods.cheesemod.blocks;

import java.util.Random;

import simplemods.cheesemod.inventory.CCreativeTabs;
import simplemods.cheesemod.items.*;
import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
public class BlockSaltOre extends Block { 

	public BlockSaltOre(Material p_i45394_1_) {
		super(Material.rock);
		this.setCreativeTab(CCreativeTabs.tabBlock);
		this.setBlockTextureName("cheesemod:salt_ore");
		this.setBlockName("salt_ore");
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(1.3F);
	}
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return CommonProxy.salt;
	}
	public int quantityDropped(Random r) {
		return 1;
	}
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
		return MathHelper.getRandomIntegerInRange(new Random(), 0, 2);
	}
}
