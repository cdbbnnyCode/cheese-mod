package simplemods.cheesemod.achievement;

import net.minecraft.item.ItemStack;
import simplemods.cheesemod.CommonProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnCraftEvents {
	@SubscribeEvent
	public void craftingEvent(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(CommonProxy.cheese_wheel)) {
			e.player.addStat(CommonProxy.craftCheeseWheel, 1);
		} else if (e.crafting.getItem().equals(CommonProxy.sandwich)) {
			e.player.addStat(CommonProxy.craftSandwich,1);
		} else if (e.crafting.getItem().equals(CommonProxy.bucket_vinegar)) {
			e.player.addStat(CommonProxy.craftVinegar,1);
		} else if (e.crafting.getItem().equals(CommonProxy.cream_cheese)) {
			e.player.addStat(CommonProxy.craftCCheese,1);
		} else if (e.crafting.getItem().equals(CommonProxy.bread_slice)) {
			e.player.addStat(CommonProxy.craftBSlice,1);
		} else if (e.crafting.getItem().equals(CommonProxy.egg_sandwich)) {
			e.player.addStat(CommonProxy.craftEggSandwich,1);
		}
	}
}
