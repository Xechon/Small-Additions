package com.gunmetal.smalladditions;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod (modid = Main.MODID, version = Main.VERSION, name = Main.NAME) //identifies this class to Forge as a mod class
public class Main {
	
	public static final String NAME = "Small Additions";
	public static final String MODID = "smalladditions";
	public static final String VERSION = "1.0";
	
	public static GrassyStone grassystone = new GrassyStone();
	public static ItemBlock gStoneItem = new ItemBlock(grassystone);
	
	@EventHandler //Preinit event; registers blocks/items/content with the game registry
	public void preInit(FMLPreInitializationEvent e) {
		//grassystone.setRegistryName(MODID,"grassystone");
		
		// Xechon: Added this line to register actual block
		GameRegistry.register(grassystone);
		
		// Xechon: Changed this line to actually use the ItemBlock created in gStoneItem, and to use the registry name
		//  of its block
		GameRegistry.register(gStoneItem.setRegistryName(grassystone.getRegistryName()));
		
		// Xechon: Added this code to properly register item model
		if(e.getSide() == Side.CLIENT) {
			ModelLoader.setCustomModelResourceLocation(gStoneItem, 0, new ModelResourceLocation(gStoneItem.
					getRegistryName(), "inventory"));
		}
	}
	
	@EventHandler //Init event; registers blocks into the running program itself
	public void init(FMLInitializationEvent e) {
		// Xechon: Removed this line - should do this on client side only, better to use ModelLoader as above, and can
		//  use getRegistryName() instead of using MODID + ":" + getUnlocalizedName().substring(5); Also should be done
		//  in preInit
		// Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(gStoneItem, 0,
		// new ModelResourceLocation(MODID + ":" + grassystone.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
	@EventHandler //Postinit event; lets this mod communicate with other mods, and vice versa
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
