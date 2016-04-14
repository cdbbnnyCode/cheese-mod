package simplemods.cheesemod.achievement;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements {
	public static Achievement createAchievement(String name, String unlocalizedName, int x, int y, Item displayItem, Block displayBlock, Achievement prerequisite) {
		Achievement a;
		if (displayItem != null) {
			a = new Achievement(name,unlocalizedName,x,y,displayItem, prerequisite == null ? (Achievement)null : prerequisite);
		} else {
			a = new Achievement(name,unlocalizedName,x,y,displayBlock, prerequisite == null ? (Achievement)null : prerequisite);
		}
		return a;
	}
	public static AchievementPage createAchievementPage(String name, Achievement... achievements) {
		return new AchievementPage(name, achievements);
	}
	public static void registerObjective(Object objective) {
		FMLCommonHandler.instance().bus().register(objective);
	}
}
