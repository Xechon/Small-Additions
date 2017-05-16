package com.gunmetal.smalladditions;

import net.minecraft.item.Item;

public class MercuryDrop extends Item {
	
	public static final String NAME = "mercurydrop";
	
	public MercuryDrop() {
		super();
		this.maxStackSize = 64;
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
	}
	
	public String getName() {
		return NAME;
	}
}
