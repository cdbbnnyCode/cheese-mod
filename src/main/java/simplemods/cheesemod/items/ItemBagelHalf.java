package simplemods.cheesemod.items;

import java.util.List;

import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBagelHalf extends ItemFood {
	private IIcon[] icons = new IIcon[5]; // 3 - plain; 2 - cream-cheese
	private String[] names = {"plain","chocolate","everything","plain-cc","chocolate-cc"};
	public ItemBagelHalf(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		setCreativeTab(CCreativeTabs.tabFood);
		setMaxStackSize(64);
		setUnlocalizedName("bagel_half");
	}
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 2)  meta = 0;
		return icons[meta];
	}
	@Override
	public void registerIcons(IIconRegister reg) {
		icons[0] = reg.registerIcon("cheesemod:bagel_half_plain");
		icons[1] = reg.registerIcon("cheesemod:bagel_half_chocolate");
		icons[2] = reg.registerIcon("cheesemod:bagel_half_everything");
		icons[3] = reg.registerIcon("cheesemod:bagel_half_plain_cc");
		icons[4] = reg.registerIcon("cheesemod:bagel_half_chocolate_cc");
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + names[stack.getItemDamage()];
	}
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List l) {
		l.add(new ItemStack(item,1,0));
		l.add(new ItemStack(item,1,1));
		l.add(new ItemStack(item,1,2));
		l.add(new ItemStack(item,1,3));
		l.add(new ItemStack(item,1,4));
	}
}
