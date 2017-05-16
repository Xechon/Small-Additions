package com.gunmetal.smalladditions;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod (modid = Constants.MODID, version = Constants.VERSION, name = Constants.MODNAME) //identifies this class to Forge as a mod class
public class Main {
	
	@EventHandler //Preinit event; registers blocks/items/content with the game registry
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.register(SABlockManager.grassystone); //register grassystone block
		GameRegistry.register(SABlockManager.orecinnabar);
		GameRegistry.register(SAItemManager.mercuryDrop);
		GameRegistry.register(SAItemManager.gStoneItem.setRegistryName(SABlockManager.grassystone.getRegistryName())); //register grassystone itemblock
		GameRegistry.register(SAItemManager.cOreItem.setRegistryName(SABlockManager.orecinnabar.getRegistryName()));
		SAFluidManager.register();
		
		if(e.getSide() == Side.CLIENT) { //If the PreInitializationEvent is clientside, load the model for grassystone
			ModelLoader.setCustomModelResourceLocation(SAItemManager.gStoneItem, 0, new ModelResourceLocation(SAItemManager.gStoneItem.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.cOreItem, 0, new ModelResourceLocation(SAItemManager.cOreItem.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.mercuryDrop, 0, new ModelResourceLocation(SAItemManager.mercuryDrop.getRegistryName(), "inventory"));
			SAModelManager.INSTANCE.registerFluidModel(SAFluidManager.liquidMercury);
		}
	}
	
	@EventHandler //Init event; registers crafting recipes and other recipes
	public void init(FMLInitializationEvent e) {
		GameRegistry.addRecipe(new ItemStack(SABlockManager.grassystone), //grassystone crafting recipe  
				"B",
				"A",
				'A', Blocks.STONE, 'B', Blocks.GRASS);
		GameRegistry.addSmelting(SABlockManager.orecinnabar, new ItemStack(SAItemManager.mercuryDrop), 3.0F);
	}
	
	@EventHandler //Postinit event; lets this mod communicate with other mods, and vice versa
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
