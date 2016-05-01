package simplemods.cheesemod;

import net.minecraftforge.common.DimensionManager;
import simplemods.cheesemod.environment.RainbowProvider;
import simplemods.cheesemod.tileentity.RenderTileEntityOctagon;
import simplemods.cheesemod.tileentity.TileEntityOctagon;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOctagon.class, new RenderTileEntityOctagon());
	}

	@Override
	public void load(FMLInitializationEvent event) {
		super.load(event);
		//new world provider to change what happens when the rain stops... C=
		System.out.println("Replacing world provider for dimension 0");
		DimensionManager.unregisterProviderType(0);
		DimensionManager.registerProviderType(0,RainbowProvider.class, true);
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

}
