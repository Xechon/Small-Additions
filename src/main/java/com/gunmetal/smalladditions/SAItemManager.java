package com.gunmetal.smalladditions;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.UniversalBucket;

public class SAItemManager {
	
	public static MercuryDrop mercuryDrop = new MercuryDrop();
	public static ItemBlock gStoneItem = new ItemBlock(SABlockManager.grassystone);
	public static ItemBlock cOreItem = new ItemBlock(SABlockManager.orecinnabar);
	public static UniversalBucket mercuryBucket = new UniversalBucket();
	
	public static void registerItems() {
		mercuryBucket.setCreativeTab(Constants.SACTAB);
		mercuryBucket.setRegistryName("mercurybucket");
		mercuryBucket.getFilledBucket(mercuryBucket, SAFluidManager.fluidMercury);
	}
}
