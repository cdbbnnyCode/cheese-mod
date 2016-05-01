package simplemods.cheesemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.util.EnumHelper;
import simplemods.cheesemod.achievement.Achievements;
import simplemods.cheesemod.achievement.OnCraftEvents;
import simplemods.cheesemod.blocks.BlockHotPepperCheeseOre;
import simplemods.cheesemod.blocks.BlockMoonCheese;
import simplemods.cheesemod.blocks.BlockOctagon;
import simplemods.cheesemod.blocks.BlockSaltOre;
import simplemods.cheesemod.inventory.CCreativeTabs;
import simplemods.cheesemod.items.ItemApplePie;
import simplemods.cheesemod.items.ItemBagel;
import simplemods.cheesemod.items.ItemBagelHalf;
import simplemods.cheesemod.items.ItemBagelSandwich;
import simplemods.cheesemod.items.ItemBreadSlice;
import simplemods.cheesemod.items.ItemBucketBoilingSaltyMilk;
import simplemods.cheesemod.items.ItemBucketVinegar;
import simplemods.cheesemod.items.ItemCheeseCake;
import simplemods.cheesemod.items.ItemCheeseSlice;
import simplemods.cheesemod.items.ItemCheeseWedge;
import simplemods.cheesemod.items.ItemCheeseWheel;
import simplemods.cheesemod.items.ItemCreamCheesePickaxe;
import simplemods.cheesemod.items.ItemFriedEgg;
import simplemods.cheesemod.items.ItemPoisonedApple;
import simplemods.cheesemod.items.ItemSandwich;
import simplemods.cheesemod.tileentity.TileEntityOctagon;
import simplemods.cheesemod.worldgen.OreGenerator;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public static CommonProxy proxy;
	public static Item cheese_wheel;
	public static Item cheese_wedge;
	public static Item salt;
	public static Item bucket_vinegar;
	public static Item bucket_salty_milk;
	public static Item bucket_boiling_salty_milk;
	public static Item butter;
	public static Item apple_pie;
	public static Item cheese_cake;
	public static Item cream_cheese_pickaxe;
	//food
	public static ItemFood cheese_slice;
	public static ItemFood bread_slice;
	public static ItemFood sandwich;
	public static ItemFood poisoned_apple;
	public static ItemFood fried_egg;
	public static ItemFood cream_cheese;
	public static ItemFood egg_sandwich;
	public static ItemFood /* wait for it.......*/ choco_bar /*!*/ ; //mmmmmmmmmmmmmm
	public static ItemFood moon_cheese;
	public static ItemFood brownie;
	public static ItemFood apple_pie_slice;
	public static ItemFood bagel;
	public static ItemFood bagel_half;
	public static ItemFood bagel_sandwich;
	public static ItemFood cheese_cake_slice;
	public static ItemFood hot_pepper_cheese;
	//not yet implemented
//	public static ItemSeeds dent_corn;
//	public static ItemSeeds sweet_corn_seeds;
//	public static ItemFood sweet_corn;
	//blocks
	public static Block salt_ore;
	public static Block moon_cheese_ore;
	public static Block cheese_wheel_block;
	public static Block apple_pie_block;
	public static Block cheese_cake_block;
	public static Block hot_pepper_cheese_ore;
	//achievements
	public static Achievement craftCheeseWheel;
	public static Achievement craftSandwich;
	public static Achievement craftVinegar;
	public static Achievement craftCCheese;
	public static Achievement craftBSlice;
	public static Achievement craftEggSandwich;
	//tool materials
	public static ToolMaterial materialCreamCheese = EnumHelper.addToolMaterial("CREAM_CHEESE", 1, 14, 3.2F, -1, 100);
    public void preInit(FMLPreInitializationEvent e) {
    	System.out.println("Registering blocks and items");
		//1.0
		cheese_wheel = new ItemCheeseWheel();
		cheese_wedge = new ItemCheeseWedge(); //done
		cheese_slice = new ItemCheeseSlice(1,0.4F,false); //done
		//1.2
		sandwich = new ItemSandwich(12,0.8F,false); //done
		bread_slice = new ItemBreadSlice(1,0.5F,false); //done
		//1.2.5
		poisoned_apple = new ItemPoisonedApple(3,0F,false); //done
		fried_egg = new ItemFriedEgg(4,0.6F,false); //done
		//1.3.1 items/block
		salt = new Item().setTextureName("cheesemod:salt").setMaxStackSize(64).setUnlocalizedName("salt").setCreativeTab(CCreativeTabs.tabFood); //done
		bucket_vinegar = new ItemBucketVinegar(); //done
		salt_ore = new BlockSaltOre(Material.rock); //done
		bucket_salty_milk = new Item().setTextureName("minecraft:bucket_milk").setUnlocalizedName("bucket_salt_milk"); //done
		bucket_boiling_salty_milk = new ItemBucketBoilingSaltyMilk(); //done
		egg_sandwich = (ItemFood)new ItemFood(12,0.98F,false).setMaxStackSize(5).setTextureName("cheesemod:egg_sandwich").setUnlocalizedName("egg_sandwich").setCreativeTab(CCreativeTabs.tabFood); //done
		cream_cheese = (ItemFood)new ItemFood(4,0.2F,false).setMaxStackSize(64).setTextureName("cheesemod:cream_cheese").setUnlocalizedName("cream_cheese").setCreativeTab(CCreativeTabs.tabFood);   //done
		//1.3.2 item
		choco_bar = (ItemFood)new ItemFood(3,0.4F,false).setMaxStackSize(64).setTextureName("cheesemod:chocolate").setUnlocalizedName("chocolate").setCreativeTab(CCreativeTabs.tabFood);            //done
		//1.4.0 items/blocks
		butter = new Item().setMaxStackSize(64).setTextureName("cheesemod:butter").setUnlocalizedName("butter").setCreativeTab(CCreativeTabs.tabFood);
		moon_cheese = (ItemFood)new ItemFood(3,0.4F,false).setTextureName("cheesemod:moon_cheese").setUnlocalizedName("moon_cheese").setCreativeTab(CCreativeTabs.tabFood);
		moon_cheese.setPotionEffect(Potion.nightVision.id,40,0,1F);
		moon_cheese_ore = new BlockMoonCheese(Material.rock);
		brownie = (ItemFood)new ItemFood(7,0.8F,false).setTextureName("cheesemod:brownie").setMaxStackSize(64).setUnlocalizedName("brownie").setCreativeTab(CCreativeTabs.tabFood);
		cheese_wheel_block = new BlockOctagon(Material.cake, "cheese_wheel_block", null, 1.2F, cheese_wheel, "cheese_wheel", "cheese_wheel_texture");
		apple_pie = new ItemApplePie();
		apple_pie_slice = (ItemFood)new ItemFood(6,0.5F,false).setMaxStackSize(64).setTextureName("cheesemod:apple_pie_slice").setUnlocalizedName("apple_pie_slice").setCreativeTab(CCreativeTabs.tabFood);
		apple_pie_block = new BlockOctagon(Material.cake, "apple_pie_block", null, 0.7F, apple_pie, "apple_pie", "apple_pie");
		bagel = new ItemBagel(10,0.8F,false);
		bagel_half = new ItemBagelHalf(5,0.4F,false);
		bagel_sandwich = new ItemBagelSandwich(15,1F,false);
		cheese_cake = new ItemCheeseCake();
		cheese_cake_slice = (ItemFood)new ItemFood(10,0.9F,false).setMaxStackSize(64).setTextureName("cheesemod:cheese_cake_slice").setUnlocalizedName("cheese_cake_slice").setCreativeTab(CCreativeTabs.tabFood);
		cheese_cake_block = new BlockOctagon(Material.cake, "cheese_cake_block", null, 0.5F, cheese_cake, "cheese_cake", "cheese_cake");
		hot_pepper_cheese_ore = new BlockHotPepperCheeseOre(null);
		hot_pepper_cheese = (ItemFood)new ItemFood(3,0.4F,false).setMaxStackSize(64).setTextureName("cheesemod:flaming_cheese").setUnlocalizedName("hot_pepper_cheese").setCreativeTab(CCreativeTabs.tabFood);
		hot_pepper_cheese.setPotionEffect(Potion.fireResistance.id, 30, 1, 0.7F);
		cream_cheese_pickaxe = new ItemCreamCheesePickaxe(materialCreamCheese);
		//far future item
//		dent_corn = new ItemSeeds(null,Blocks.farmland); // new ItemSeeds(Block plant, Block soil) //TODO replace null with something
		//block/item registration
		GameRegistry.registerItem(cheese_wedge, "cheese_wedge");
		GameRegistry.registerItem(cheese_slice, "cheese_slice");
		GameRegistry.registerItem(bread_slice,"bread_slice");
		GameRegistry.registerItem(sandwich, "sandwich");
		GameRegistry.registerItem(poisoned_apple, "poisoned_apple");
		GameRegistry.registerItem(fried_egg,"fried_egg");
		// 1.3.1 items/block
		GameRegistry.registerBlock(salt_ore, "salt_ore");
		GameRegistry.registerItem(bucket_vinegar, "bucket_vinegar");
		GameRegistry.registerItem(salt, "salt");
		GameRegistry.registerItem(bucket_salty_milk,"bucket_salt_milk");
		GameRegistry.registerItem(bucket_boiling_salty_milk, "bucket_boiling_salt_milk");
		GameRegistry.registerItem(egg_sandwich,"egg_sandwich"); 
		GameRegistry.registerItem(cream_cheese, "cream_cheese");
		// 1.3.2 item
		GameRegistry.registerItem(choco_bar,"choco_bar");
		// 1.4.0 items/blocks
		GameRegistry.registerItem(moon_cheese, "moon_cheese");
		GameRegistry.registerBlock(moon_cheese_ore,"moon_cheese_ore");
		GameRegistry.registerItem(brownie, "brownie");
		GameRegistry.registerItem(apple_pie_slice,"apple_pie_slice");
		registerOctagon(cheese_wheel,(BlockOctagon)cheese_wheel_block,"cheese_wheel","cheese_wheel_block");
		registerOctagon(apple_pie,(BlockOctagon)apple_pie_block,"apple_pie_block","apple_pie");
		GameRegistry.registerItem(bagel,"bagel");
		GameRegistry.registerItem(bagel_half,"bagel_half");
		GameRegistry.registerItem(bagel_sandwich,"bagel_sandwich");
		GameRegistry.registerItem(cheese_cake_slice, "cheese_cake_slice");
		registerOctagon(cheese_cake,(BlockOctagon)cheese_cake_block, "cheese_cake_block", "cheese_cake");
		GameRegistry.registerBlock(hot_pepper_cheese_ore, "hot_pepper_cheese_ore");
		GameRegistry.registerItem(hot_pepper_cheese, "hot_pepper_cheese");
		GameRegistry.registerItem(cream_cheese_pickaxe, "cream_cheese_pickaxe");
		GameRegistry.registerItem(butter, "butter");
		// ore registration
		System.out.println("Registering ores");
		OreGenerator o = new OreGenerator();
		// 1.3.1 ore
		o.registerOre(salt_ore, 32, 1, 35, 0);
		// 1.4.0 ores
		o.registerOre(moon_cheese_ore, 10, 4, 63, 1);
		o.registerOre(hot_pepper_cheese_ore, 5, 3, 127, -1);
		//---------
		GameRegistry.registerWorldGenerator(o,50);
		//achievement registration
		System.out.println("Registering achievements");
		craftCheeseWheel = Achievements.createAchievement("craft_cheese", "craft_cheese", -4, 4, cheese_wheel, null, (Achievement)null);
		craftSandwich = Achievements.createAchievement("craft_sandwich","craft_sandwich", -2, 3, sandwich, null, craftCheeseWheel).setSpecial();
		craftVinegar = Achievements.createAchievement("craft_vinegar", "craft_vinegar", -4, 2, bucket_vinegar, null, (Achievement)null);
		craftCCheese = Achievements.createAchievement("craft_cream_cheese","craft_cream_cheese", -1, 2, cream_cheese, null, craftVinegar).setSpecial();
		craftBSlice = Achievements.createAchievement("craft_bread", "craft_bread", -4, -3, bread_slice, null, null);
		craftEggSandwich = Achievements.createAchievement("craft_egg_sandwich", "craft_egg_sandwich", -2, -1, egg_sandwich, null, craftBSlice).setSpecial();
		AchievementPage page = Achievements.createAchievementPage("cheesemod", craftCheeseWheel,craftSandwich,craftVinegar,craftCCheese,craftBSlice,craftEggSandwich);
		AchievementPage.registerAchievementPage(page);
		Achievements.registerObjective(new OnCraftEvents());
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * Homemade Cream Cheese                                     *
		 *                                                           *
    	 * Bring milk and salt very slowly to the boil.              *
    	 * Remove from heat and stir in white vinegar.               *
    	 * Leave to cool.                                            *
    	 * When cool pour mixture into a muslin bag and allow to drip*
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 * Minecraft Cream Cheese          :P                                                                                                      *
    	 *                                                                                                                                         *
    	 * Bring milk and salt very quickly to the boil in a furnace. (You will need 2 buckets to get the salt into the milk: 1 empty, 1 with milk)*
    	 * Remove from heat and craft in white vinegar.                                                                                            *
    	 * You will instantaneously get cream cheese when you craft in white vinegar.                                                              *
    	 * This is due to the lack of muslin in Minecraft :P                                                                                       *
    	 * By :P                                                                                                                                   *
    	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    	 */
    }
    public void registerOctagon(Item item, BlockOctagon block, String blockName, String itemName) {
		GameRegistry.registerBlock(block, blockName);
        GameRegistry.registerItem(item, itemName);
	}
    public void load(FMLInitializationEvent e) {
    	System.out.println("Registering crafting recipes");
		ItemStack milk = new ItemStack(Items.milk_bucket);
		ItemStack cheesewheel = new ItemStack(cheese_wheel);
		GameRegistry.addShapedRecipe(
			cheesewheel,
			" # ",
			"###",
			" # ",
			'#', milk
		);
		GameRegistry.addShapelessRecipe(
			new ItemStack(cheese_wedge,8), //is made by putting 
			cheesewheel  //into a crafting table
		);
		GameRegistry.addShapelessRecipe(
			new ItemStack(cheese_slice,16),
			new ItemStack(cheese_wedge)
		);
		GameRegistry.addShapelessRecipe(
			new ItemStack(bread_slice,9),
			new ItemStack(Items.bread)
		);
		GameRegistry.addShapedRecipe(
			new ItemStack(sandwich),
			"B ",
			"MC",
			"B ",
			'B',new ItemStack(bread_slice),
			'M',new ItemStack(Items.cooked_beef),
			'C',new ItemStack(cheese_slice)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(sandwich),
				"B ",
				"MC",
				"B ",
				'B',new ItemStack(bread_slice),
				'M',new ItemStack(Items.cooked_porkchop),
				'C',new ItemStack(cheese_slice)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(sandwich),
				"B ",
				"MC",
				"B ",
				'B',new ItemStack(bread_slice),
				'M',new ItemStack(Items.cooked_chicken),
				'C',new ItemStack(cheese_slice)
		);
		GameRegistry.addSmelting(Items.egg,new ItemStack(fried_egg),0.1F);
		GameRegistry.addShapelessRecipe(
				new ItemStack(bucket_salty_milk),
				new ItemStack(Items.bucket),
				milk,
				new ItemStack(salt)
		);
		GameRegistry.addSmelting(bucket_salty_milk,new ItemStack(bucket_boiling_salty_milk),0.1F);
		GameRegistry.addShapelessRecipe(
				new ItemStack(cream_cheese,4),
				new ItemStack(bucket_boiling_salty_milk),
				new ItemStack(bucket_vinegar)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(egg_sandwich),
				"b",
				"e",
				"b",
				'b', new ItemStack(bread_slice),
				'e', new ItemStack(fried_egg)
		);
		GameRegistry.addShapelessRecipe(
				new ItemStack(bucket_vinegar),
				new ItemStack(Items.apple),
				new ItemStack(Items.water_bucket),
				new ItemStack(Items.fermented_spider_eye)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(choco_bar,8),
				" M ",
				"CCC",
				" S ",
				'C',new ItemStack(Items.dye,1,3),
				'M',new ItemStack(Items.milk_bucket),
				'S',new ItemStack(Items.sugar)
		);
		//1.4.0
		GameRegistry.addShapedRecipe(
				new ItemStack(brownie,3),
				"CCC",
				"WWW",
				'C',new ItemStack(choco_bar),
				'W',new ItemStack(Items.wheat)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(butter, 8),
				"MMM",
				'M',new ItemStack(Items.milk_bucket)
		);
		GameRegistry.addShapelessRecipe(
				new ItemStack(apple_pie),
				new ItemStack(Items.apple),
				new ItemStack(Items.egg),
				new ItemStack(Items.sugar)
		);
		GameRegistry.addShapelessRecipe(
				new ItemStack(apple_pie_slice,8),
				new ItemStack(apple_pie)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(bagel),
				" W ",
				"W W",
				" W ",
				'W',new ItemStack(Items.wheat)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(bagel,1,1),
				" W ",
				"WCW",
				" W ",
				'W',new ItemStack(Items.wheat),
				'C',new ItemStack(Items.dye,1,3)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(bagel,1,2),
				" W ",
				"WSW",
				" W ",
				'W',new ItemStack(Items.wheat),
				'S',new ItemStack(salt)
		);
		for (int i = 0; i < 3; i++) {
			GameRegistry.addShapelessRecipe(
					new ItemStack(bagel_half,2,i),
					new ItemStack(bagel,1,i)
			);
			
		}
		for (int i = 0; i < 2; i++) {
			GameRegistry.addShapedRecipe(
					new ItemStack(bagel_half,2,3+i),
					"C",
					"B",
					'C',new ItemStack(cream_cheese),
					'B',new ItemStack(bagel_half,1,i)
			);
		}
		for (int i = 0; i < 3; i+=2) {
			GameRegistry.addShapedRecipe(
					new ItemStack(bagel_sandwich),
					"B ",
					"MC",
					"B ",
					'B',new ItemStack(bagel_half,1,i),
					'M',new ItemStack(Items.cooked_beef),
					'C',new ItemStack(cheese_slice)
			);
		}
		GameRegistry.addShapelessRecipe(
				new ItemStack(cheese_cake),
				new ItemStack(Items.egg),
				new ItemStack(Items.sugar),
				new ItemStack(cream_cheese)
		);
		GameRegistry.addShapelessRecipe(
				new ItemStack(cheese_cake_slice,8),
				new ItemStack(cheese_cake)
		);
		GameRegistry.addShapedRecipe(
				new ItemStack(cream_cheese_pickaxe),
				"CCC",
				" S ",
				" S ",
				'C', new ItemStack(cream_cheese),
				'S', new ItemStack(Items.stick)
		);
		GameRegistry.registerTileEntity(TileEntityOctagon.class, "tileCheeseWheel");
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
