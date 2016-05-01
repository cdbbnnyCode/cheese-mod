package simplemods.cheesemod.environment;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IRenderHandler;

public class RainbowProvider extends WorldProvider {
	private static boolean initialized = false;
	private boolean wasRaining = false;
	private boolean showRainbow = false;
	private int rainbowTicks = 5000;
	private int disappearTime = 13000; //the maximum time for the rainbow to show
	private int appearTime = 600;//the minimum time for the rainbow to show
	private boolean wouldShowRainbow = false;//the rainbow would show if the sun was up
	private IRenderHandler weatherRenderer; //the custom weather renderer.
	public RainbowProvider() {
		weatherRenderer = new IRenderHandler() {
			@Override
			public void render(float partialTicks, WorldClient world,
					Minecraft mc) {
				ResourceLocation rainbow = new ResourceLocation("cheesemod:textures/environment/sky/rainbow.png");
				UV[] uv  = new UV[] { UV.uv(1.0D, 0.0D), UV.uv(0.0D, 0.0D), UV.uv(0.0D, 1.0D), UV.uv(1.0D, 1.0D) };
				if (showRainbow) {
					rainbowTicks--;
					if (rainbowTicks < 0) {
						rainbowTicks = 5000;
						showRainbow = false;
						return;
					}
					GL11.glPushMatrix();
					TextureManager renderEngine = Minecraft.getMinecraft().getTextureManager();
					GL11.glDisable(GL11.GL_FOG);
					GL11.glDisable(GL11.GL_ALPHA_TEST);
					GL11.glEnable(GL11.GL_BLEND);
					OpenGlHelper.glBlendFunc(770, 771, 1, 0);
					GL11.glDepthMask(false);
					Tessellator tessellator = Tessellator.instance;
					renderEngine.bindTexture(rainbow);
					GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
					tessellator.startDrawingQuads();
					int col = 0xffffff;
			        tessellator.setColorOpaque_I(col); 
			        tessellator.addVertexWithUV(-100.0D, -100.0D, -100.0D, uv[0].u, uv[0].v); 
			        tessellator.addVertexWithUV(-100.0D, -100.0D, 100.0D, uv[1].u, uv[1].v); 
			        tessellator.addVertexWithUV(100.0D, -100.0D, 100.0D, uv[2].u, uv[2].v); 
			        tessellator.addVertexWithUV(100.0D, -100.0D, -100.0D, uv[3].u, uv[3].v); 
			        tessellator.draw(); 
			        GL11.glPopMatrix(); 
			        GL11.glDepthMask(true); 
			        GL11.glEnable(GL11.GL_TEXTURE_2D); 
			        GL11.glEnable(GL11.GL_ALPHA_TEST); 
				}
			}
		};
	}
	private static class UV {
		private final double u;
		private final double v;
			
		private UV(double u, double v) {
				this.u = u;
				this.v = v;
		}
		public static UV uv(double u, double v) {
			return new UV(u,v);
		}
		
	}
	@Override
	public String getDimensionName() {
		return "Overworld";
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	public void updateWeather() {
		super.updateWeather();
		if (!worldObj.isRaining() && !worldObj.isThundering() && wasRaining) {
			showRainbow = true;
			wasRaining = false;
		} else {
			if (worldObj.isRaining() || worldObj.isThundering()) {
				wasRaining = true;
				showRainbow = false;
				rainbowTicks = 5000;
			}
		}
		wouldShowRainbow = showRainbow;
		if (worldObj.getWorldTime() % 24000 < appearTime || worldObj.getWorldTime() % 24000 > disappearTime) {
			showRainbow = false;
			rainbowTicks = 5000;
		} else {
			showRainbow = wouldShowRainbow;
		}
		if (showRainbow) {
			setWeatherRenderer(weatherRenderer);
		} else {
			setWeatherRenderer(null);//switch to default renderer if it is raining
		}
	}
	
}