package simplemods.cheesemod.items;

import java.util.List;

import simplemods.cheesemod.inventory.CCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBagel extends ItemFood {
	private IIcon[] icons = new IIcon[3];
	private String[] names = {"plain","chocolate","everything"};
	public ItemBagel(int healthBoost, float saturationBoost, boolean isWolfsFavoriteMeat) {
		super(healthBoost,saturationBoost,isWolfsFavoriteMeat);
		setHasSubtypes(true);
		setCreativeTab(CCreativeTabs.tabFood);
		setMaxStackSize(64);
		setUnlocalizedName("bagel");
	}
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 2)  meta = 0;
		return icons[meta];
	}
	@Override
	public void registerIcons(IIconRegister reg) {
		icons[0] = reg.registerIcon("cheesemod:bagel_plain");
		icons[1] = reg.registerIcon("cheesemod:bagel_chocolate");
		icons[2] = reg.registerIcon("cheesemod:bagel_everything");
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
	}
}
