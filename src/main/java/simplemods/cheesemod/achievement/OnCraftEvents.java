package simplemods.cheesemod.achievement;

import net.minecraft.item.ItemStack;
import simplemods.cheesemod.BaseMod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnCraftEvents {
	@SubscribeEvent
	public void craftingEvent(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(BaseMod.cheese_wheel)) {
			e.player.addStat(BaseMod.craftCheeseWheel, 1);
		} else if (e.crafting.getItem().equals(BaseMod.sandwich)) {
			e.player.addStat(BaseMod.craftSandwich,1);
		} else if (e.crafting.getItem().equals(BaseMod.bucket_vinegar)) {
			e.player.addStat(BaseMod.craftVinegar,1);
		} else if (e.crafting.getItem().equals(BaseMod.cream_cheese)) {
			e.player.addStat(BaseMod.craftCCheese,1);
		} else if (e.crafting.getItem().equals(BaseMod.bread_slice)) {
			e.player.addStat(BaseMod.craftBSlice,1);
		} else if (e.crafting.getItem().equals(BaseMod.egg_sandwich)) {
			e.player.addStat(BaseMod.craftEggSandwich,1);
		}
	}
}
