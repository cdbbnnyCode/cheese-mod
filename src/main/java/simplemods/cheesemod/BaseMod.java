package simplemods.cheesemod;

import simplemods.cheesemod.inventory.CCreativeTabs;
import simplemods.cheesemod.items.*;
import simplemods.cheesemod.achievement.Achievements;
import simplemods.cheesemod.achievement.OnCraftEvents;
import simplemods.cheesemod.blocks.*;
import simplemods.cheesemod.environment.RainbowProvider;
import simplemods.cheesemod.tileentity.RenderTileEntityOctagon;
import simplemods.cheesemod.tileentity.TileEntityOctagon;
import simplemods.cheesemod.worldgen.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = BaseMod.MODID, name = BaseMod.MODNAME,version = BaseMod.MODVER)
public class BaseMod {
	//neccessary things
	public static final String MODID = "cheesemod";
	public static final String MODNAME = "Cheese Mod";
	public static final String MODVER = "1.4.0"; //update 3rd digit after minor update, 2nd digit after medium update or 3rd digit gets to 10, and 1st digit after major update or 2nd digit gets to 10
	
	@Instance(value = BaseMod.MODID)
	public static BaseMod instance;
	//proxy
	@SidedProxy(clientSide="simplemods.cheesemod.ClientProxy",serverSide="simplemods.cheesemod.ServerProxy")
	public static CommonProxy proxy;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.load(event);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
