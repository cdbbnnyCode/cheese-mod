package simplemods.cheesemod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockDentCorn extends BlockBush implements IGrowable {
	public BlockDentCorn() {
		this.setTickRandomly(true);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setCreativeTab((CreativeTabs)null);
	}
	public void updateTick (World world, int x, int y, int z, Random rand) {
		super.updateTick(world,x,y,z,rand);
		int meta = world.getBlockMetadata(x, y, z);
		//is it already fully grown?
		if (world.getBlockMetadata(x,y,z) == 3) {
			return;
		}
		//is there insufficient light?
		if (world.getBlockLightValue(x, y, z) < 9) {
			return;
		}
		//if the ground is wet, grow faster
		if (rand.nextInt(isFertile(world,x,y-1,z) ? 25 : 12) > 0) {
			return;
		}
		//if none of these are true, then update the metadata
		world.setBlockMetadataWithNotify(x,y,z,meta++,2);
	}
	protected boolean canPlaceBlockOn(Block ground) {
		return ground == Blocks.farmland;
	}
	@Override
	public boolean func_149851_a(World world, int p_149851_2_,
			int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return world.getBlockMetadata(p_149851_2_, p_149851_3_, p_149851_4_) != 3;
	}

	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_,
			int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}

	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_,
			int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		
	}
}
