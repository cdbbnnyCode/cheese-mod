package simplemods.cheesemod.blocks;

import java.util.Random;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.tileentity.RenderTileEntityOctagon;
import simplemods.cheesemod.tileentity.TileEntityOctagon;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlockOctagon extends BlockContainer {
	private IIcon icon;
	private Item item;
	private String itemTexture;
	public String blockTexture;
	public BlockOctagon(Material material, String name, CreativeTabs tab, float hardness, Item item, String itemTexture, String blockTexture) {
		super(material);
		this.setBlockName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.item = item;
		this.itemTexture = itemTexture;
		this.blockTexture = blockTexture;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityOctagon();
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
    public boolean isOpaqueCube(){
        return false;
    }
	public Item getItem(World w, int x, int y, int z) {
		return item;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return item;
	}

	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return icon;
	}

	public void registerBlockIcons(IIconRegister reg) {
		icon = reg.registerIcon("cheesemod:" + itemTexture + "_item");
	}
	
	
}
