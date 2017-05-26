package com.gunmetal.smalladditions.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class AddBookGui extends GuiBase {
	
	public static final int X = 0;
	public static final int Y = 0;
	public static final float TICKS = 0.0F;
	public static final int WHITE = 16777215;
	
	public AddBookGui() {
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, 100, 100, 180, 20, "ButtonText"));
		drawScreen(X, Y, TICKS);
        /*Parameters:
         * button id used when checking what to do when a button is pressed
         * The X position of the button
         * The Y position of the button
         * The width
         * The height (keep this at 20 if you can)
         * The text to be displayed on the button*/
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawCenteredString(mc.fontRendererObj, "What a wonderful world", 100, 100, WHITE);
		//drawTexturedModalRect(TICKS, TICKS, Y, Y, 128, 128); #TODO; needs a TextureManager, will come later when GUI textures are made
		
		
		this.mc.displayGuiScreen(this);
	}

	@Override
	public void buildGui() {
		// TODO 
	}
	
	public void buttonPressed(GuiButton button) {
		switch (button.id) {
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