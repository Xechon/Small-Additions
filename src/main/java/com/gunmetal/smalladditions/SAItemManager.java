package com.gunmetal.smalladditions;

import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.UniversalBucket;

public class SAItemManager {	
	public static MercuryDrop mercuryDrop = new MercuryDrop();
	public static ItemBlock gStoneItem = new ItemBlock(SABlockManager.grassystone);
	public static ItemBlock cOreItem = new ItemBlock(SABlockManager.orecinnabar);
	public static UniversalBucket HgBucket = new UniversalBucket(1000, new ItemStack(Items.BUCKET), false);
}
