package com.gunmetal.smalladditions;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.item.Item;

public class MercuryDrop extends Item {
	
	public static final String NAME = "mercurydrop";
	
	public MercuryDrop() {
		super();
		this.maxStackSize = 64;
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
	}
	
	public String getName() {
		return NAME;
	}
}
