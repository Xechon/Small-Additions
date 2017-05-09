package com.gunmetal.smalladditions;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidRegistry;
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
	
	public static FluidMercury fluidmercury = new FluidMercury();
	public static GrassyStone grassystone = new GrassyStone();
	public static ItemBlock gStoneItem = new ItemBlock(grassystone);
	public static LiquidMercury liquidmercury = new LiquidMercury();
	
	@EventHandler //Preinit event; registers blocks/items/content with the game registry
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.register(grassystone); //register grassystone block
		GameRegistry.register(liquidmercury); //register liquid mercury block
		GameRegistry.register(gStoneItem.setRegistryName(grassystone.getRegistryName())); //register grassystone itemblock
		
		FluidRegistry.registerFluid(fluidmercury); //register liquid mercury into the fluid registry (mB compatibility, tanks, etc)
		
		if(e.getSide() == Side.CLIENT) { //If the PreInitializationEvent is clientside, load the model for grassystone
			ModelLoader.setCustomModelResourceLocation(gStoneItem, 0, new ModelResourceLocation(gStoneItem.
					getRegistryName(), "inventory"));
		}
	}
	
	@EventHandler //Init event; registers blocks into the running program itself
	public void init(FMLInitializationEvent e) {
		GameRegistry.addRecipe(new ItemStack(grassystone), //grassystone crafting recipe  
				"B",
				"A",
				'A', Blocks.STONE, 'B', Blocks.GRASS);
	}
	
	@EventHandler //Postinit event; lets this mod communicate with other mods, and vice versa
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
