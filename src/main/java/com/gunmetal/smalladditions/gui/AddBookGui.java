package com.gunmetal.smalladditions.gui;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class AddBookGui extends GuiBase {
	
	public static final float TICKS = 0.0F;
	public static final int WHITE = 16777215;
	
	public AddBookGui() {
	}
	
	@Override
	public void initGui() {
		int centerX = (this.width - 256) / 2;
		int centerY = (this.height - 256) / 2;
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, centerX, centerY - 100, 180, 20, "ButtonText"));
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		int centerX = (this.width - 256) / 2;
		int centerY = (this.height - 256) / 2;
		this.drawDefaultBackground();
		this.mc.renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":" + "textures/gui/addbook.png"));
		drawTexturedModalRect(centerX, centerY, 0, 0, 256, 256); 
		this.drawCenteredString(mc.fontRendererObj, "Additionomicon", centerX + 128, centerY + 16, WHITE);		
		
		
		super.drawScreen(0, 0, TICKS);
		this.mc.displayGuiScreen(this);
	}

	@Override
	public void buildGui() {
		// TODO 
	}
	
	public void buttonPressed(GuiButton button) {
		switch (button.id) {
		case 0:
			
		case 1:
			//do something with button id 1 here
		case 2:
			//button 2
		case 3: 
			//etc...
		}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}