package com.gunmetal.smalladditions.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TestGui extends GuiBase {
	
	public TestGui(/*EntityPlayer player, ItemStack book*/) {
		super();
		//super(player, book);
	}
	
	public void buildGui() {
		this.drawRect(50, 50, -50, -50, backgroundColor);
	}

}
