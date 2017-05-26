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
	
	public abstract boolean doesGuiPauseGame();
	public abstract void buildGui();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {}	
}
