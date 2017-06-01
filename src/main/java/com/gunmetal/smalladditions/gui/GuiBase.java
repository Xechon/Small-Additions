package com.gunmetal.smalladditions.gui;

import net.minecraft.client.gui.GuiScreen;

public abstract class GuiBase extends GuiScreen {
	
	public GuiBase() {
	}
	
	public abstract boolean doesGuiPauseGame();
	public abstract void buildGui();
	public abstract void initGui();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {super.drawScreen(mouseX, mouseY, partialTicks);}	
}
