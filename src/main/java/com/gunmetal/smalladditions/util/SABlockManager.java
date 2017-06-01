package com.gunmetal.smalladditions.util;

import java.util.ArrayList;

import com.gunmetal.smalladditions.block.GrassyStone;
import com.gunmetal.smalladditions.block.OreCinnabar;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/** This class designates a sort of 'hub' for all the blocks in the mod Small Additions.
 *  It creates a list that contains all the blocks in the mod. It also registers them automatically.
 *  DO NOT REGISTER SA BLOCKS OUTSIDE OF THIS CLASS!
 */
public class SABlockManager {
	public static GrassyStone grassystone = new GrassyStone();
	public static OreCinnabar orecinnabar = new OreCinnabar();
	
	public static ArrayList<Block> modblocks = new ArrayList<Block>();
	
	public static void addBlocks() {
		modblocks.add(grassystone);
		modblocks.add(orecinnabar);
	}
	
	public static void registerBlocks() {
		addBlocks();
		for (int i = 0; i < modblocks.size(); i++) {
			//modblocks.get(i).setRegistryName(Constants.MODID, modblocks.get(i).getName()); #TODO
			GameRegistry.register(modblocks.get(i));
		}
	}
}
