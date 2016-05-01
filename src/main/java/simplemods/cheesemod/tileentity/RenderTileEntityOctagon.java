package simplemods.cheesemod.tileentity;

import org.lwjgl.opengl.GL11;

import simplemods.cheesemod.BaseMod;
import simplemods.cheesemod.blocks.BlockOctagon;
import simplemods.cheesemod.models.ModelCheeseWheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
public class RenderTileEntityOctagon extends TileEntitySpecialRenderer {
	ResourceLocation texture;
	ModelBase model;
	public RenderTileEntityOctagon(){
        model = new ModelCheeseWheel();
	}
	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_,
			double p_147500_4_, double p_147500_6_, float p_147500_8_) {
		TileEntityOctagon te2 = (TileEntityOctagon) p_147500_1_;
		texture = new ResourceLocation(BaseMod.MODID, "textures/blocks/" + ((BlockOctagon)te2.getBlockType()).blockTexture + ".png");
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslated(p_147500_2_ + 0.5, p_147500_4_ + 0.5, p_147500_6_ + 0.5);
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef(0F,1F,0F);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0F, 0F, 1F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
