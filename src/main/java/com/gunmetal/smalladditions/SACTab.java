package com.gunmetal.smalladditions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SACTab extends CreativeTabs {
	public SACTab() {
		super("Small Additions");
	}
	
	public Item getTabIconItem() {
		return SAItemManager.mercuryDrop;
	}

}
