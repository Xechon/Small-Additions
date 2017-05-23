package com.gunmetal.smalladditions.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract class GuiBase extends GuiScreen {
	
	protected ItemStack openedBook;
	protected EntityPlayer thisPlayer;
	protected int widthx = 196;
	protected int widthy = 196;
	protected int backgroundColor = 10395294;
	
	public GuiBase(/*EntityPlayer player, ItemStack book*/) {
		//openedBook = book;
		//thisPlayer = player;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	public void draw(GuiScreen displayedScreen) {
		drawScreen(0, 0, 0.0F);
		this.mc.displayGuiScreen(displayedScreen);
	}
	
	public abstract void buildGui();	
}
