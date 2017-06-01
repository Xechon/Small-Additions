package com.gunmetal.smalladditions.util;

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
