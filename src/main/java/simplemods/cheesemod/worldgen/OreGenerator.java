package simplemods.cheesemod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
/**
 * The OreGenerator class
 * Generates ores
 * How to use:
 * <ol>
 *   <li> Instantiate the class
 *	 <li> Add ores using the <code>registerOre(Block, int, int, int, int)</code> method
 *   <li> Register as a worldgen by putting <blockquote>
 *   		<code>GameRegistry.registerWorldGenerator(<u>your ore gen object name here</u>)</code>
 *   </blockquote>
 *   in your BaseMod class
 * </ol>
 *
 **/
public class OreGenerator implements IWorldGenerator {
	private Ore[] ores = new Ore[127];
	private int numOfOres;
	public OreGenerator() {
		numOfOres = 0;
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int i = 0; i < numOfOres; i++) {
			if (ores[i].getDim() == world.provider.dimensionId) {
				ores[i].setRandom(random);
				ores[i].setChunkXZ(chunkX * 16, chunkZ * 16);
//				System.out.println("[cheesemod][Ore Gen]Generating ore " + ores[i].getBlock().getUnlocalizedName());
				for (int j = 0; j < ores[i].getTries(); j++) {
					if (ores[i].getDim() == -1) {
						new WorldGenMinable(ores[i].getBlock(),ores[i].getBlocksPerVein(),Blocks.netherrack).generate(world, random, ores[i].getX(), ores[i].getY(), ores[i].getZ());
					} else if (ores[i].getDim() == 1) {
						new WorldGenMinable(ores[i].getBlock(),ores[i].getBlocksPerVein(),Blocks.end_stone).generate(world, random, ores[i].getX(), ores[i].getY(), ores[i].getZ());
					} else {
						new WorldGenMinable(ores[i].getBlock(),ores[i].getBlocksPerVein()).generate(world, random, ores[i].getX(), ores[i].getY(), ores[i].getZ());
					}
				}
			}
		}
	}
	public void registerOre(Block ore, int blocksPerVein, int tries, int maxY, int dim) {
		numOfOres++;
		if(numOfOres > 127) {
			System.err.println("[cheesemod][Ore Registration]Ore array full");
			numOfOres = 127;
			return;
		}
		if (ore == null) {
			System.err.println("[cheesemod][Ore Registration]Ore cannot be null");
			numOfOres--;
			return;
		}
		if (tries == 0) {
			System.err.println("[cheesemod][Ore Registration]Tries cannot be 0");
			numOfOres--;
			return;
		}
		if (dim < -1 || dim > 1) {
			System.err.println("[cheesemod][Ore Registration]Invalid dimension)");
			numOfOres--;
			return;
		}
		if (maxY > 255 || maxY < 0) {
			System.err.println("[cheesemod][Ore Registration]Invalid max Y position");
			numOfOres--;
			return;
		}
		if (blocksPerVein <= 0) {
			System.err.println("[cheesemod][Ore Registration]Blocks Per Vein must be positive");
			numOfOres--;
			return;
		}
		ores[numOfOres - 1] = new Ore(ore,blocksPerVein,maxY,tries,dim);
	}
}
class Ore {
	private Block b;
	private int blocksPerVein;
	private int chunkX;
	private int chunkZ;
	private int y;
	private int tries;
	private Random r;
	private int dimension;
	public Ore (Block block, int blocksPerVein,int y, int tries, int dimension) {
		b = block;
		this.blocksPerVein = blocksPerVein;
		this.y = y;
		this.tries = tries;
		this.dimension = dimension;
	}
	public void setRandom(Random r) {
		this.r = r;
	}
	public void setChunkXZ(int cX, int cZ) {
		chunkX = cX;
		chunkZ = cZ;
	}
	public Block getBlock() {
		return b;
	}
	public int getBlocksPerVein() {
		return blocksPerVein;
	}
	public int getX() {
		return r.nextInt(16) + chunkX;
	}
	public int getY() {
		return r.nextInt(y);
	}
	public int getZ() {
		return r.nextInt(16) + chunkZ;
	}
	public int getTries() {
		return tries;
	}
	public int getDim() {
		return dimension;
	}
}