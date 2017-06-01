package com.gunmetal.smalladditions;

import com.gunmetal.smalladditions.gui.SAGUIManager;
import com.gunmetal.smalladditions.util.Constants;
import com.gunmetal.smalladditions.util.SABlockManager;
import com.gunmetal.smalladditions.util.SAFluidManager;
import com.gunmetal.smalladditions.util.SAItemManager;
import com.gunmetal.smalladditions.util.SAModelManager;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

/** This class represents the hub of the entire mod.
 *  The <code>@Mod</code> annotation tells the Forge compiler that this class is to be recognized as a modification for Minecraft.
 *  This class registers blocks, fluids, items, crafting recipes, ore dictionary entries, and everything else.
 *  It is a bit like a <code>main()</code> method, but it's an entire class, instead.
 *  Any other classes that the mod uses are called from here. 
 *  The three methods in this class are called 'initialization events.'
 *  These methods are ONLY EVER called by Forge itself, as the game is starting.
 *  <br>
 *  <br>
 *  
 *  Some vocabulary: <br>
 *  "Side only": Minecraft is split into the client, and the server. Certain things can only be run on either 'side' of the game. <br>
 *  "Client": Handles rendering, visuals, and gameplay input. <br>
 *  "Server": Handles physics, game calculations, storing of information, etc. <br>
 *  "Item": Any 2D item in the player's inventory, or in the world. These can be stored in chests and usually do not represent blocks. <br>
 *  "Block": A 3D block in the player's world. These CAN NOT be stored in the inventory or in chests. <br>
 *  "ItemBlock": A hybrid of Block and Item. When a block is broken, it drops an ItemBlock. An ItemBlock is used to represent a block in the player's inventory, or in chests. <br>
 *  "Tile entity": An entity that looks and functions like a block, but has additional functionality, such as special drops. A good example of a tile entity is coal ore.
 *  
 * @author Lucas Crow / Gunmetal_Gears
 *
 */
@Mod (modid = Constants.MODID, version = Constants.VERSION, name = Constants.MODNAME) //identifies this class to Forge as a mod class
public class Main { 
	static { //Static initializer to set up the Forge bucket system
		FluidRegistry.enableUniversalBucket();
	}
	
	@Instance //This is the only instance of this class. It is required for client-server communication.
	public static Main instance = new Main();
	
	/** Pre-Initialization event. This is called when Forge starts up, and begins the registration process.
	 *  This includes registering Blocks, Items, and ItemBlocks (these are separate things).
	 *  This is also used to read configuration files, among other things.
	 * 
	 * @param e The event itself. This parameter can be used to call side-only methods. 
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.register(SABlockManager.grassystone); //register grassystone block
		GameRegistry.register(SABlockManager.orecinnabar);
		GameRegistry.register(SAItemManager.mercuryDrop);
		GameRegistry.register(SAItemManager.gStoneItem.setRegistryName(SABlockManager.grassystone.getRegistryName())); //register grassystone itemblock
		GameRegistry.register(SAItemManager.cOreItem.setRegistryName(SABlockManager.orecinnabar.getRegistryName()));
		GameRegistry.register(SAItemManager.additionbook);
		SAFluidManager.register();
		SAItemManager.registerItems();
		GameRegistry.register(SAItemManager.HgBucket);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new SAGUIManager());
		
		if(e.getSide() == Side.CLIENT) { //If the PreInitializationEvent is clientside, load the model for grassystone
			ModelLoader.setCustomModelResourceLocation(SAItemManager.gStoneItem, 0, new ModelResourceLocation(SAItemManager.gStoneItem.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.cOreItem, 0, new ModelResourceLocation(SAItemManager.cOreItem.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.mercuryDrop, 0, new ModelResourceLocation(SAItemManager.mercuryDrop.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.HgBucket, 0, new ModelResourceLocation(SAItemManager.HgBucket.getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(SAItemManager.additionbook, 0, new ModelResourceLocation(SAItemManager.additionbook.getRegistryName(), "inventory"));
			SAModelManager.INSTANCE.registerFluidModel(SAFluidManager.liquidMercury);
		}
	}
	
	/** Initialization event. This is called when Forge is in the middle of starting up, and represents the majority of the registration process.
	 *  This event is used to register crafting recipes and ore dictionary entries.
	 *  Any data structures that the mod needs are created here.
	 *  This is also where communication with other mods begins.
	 *  
	 * @param e The event itself. This parameter can be used to call side-only methods.
	 */
	@EventHandler
	public void init(FMLInitializationEvent e) {
		//SHAPED RECIPES
		GameRegistry.addRecipe(new ItemStack(SABlockManager.grassystone), //grassystone crafting recipe  
				"B",
				"A",
				'A', Blocks.STONE, 'B', Blocks.GRASS);
		//SHAPELESS RECIPES
		GameRegistry.addShapelessRecipe(UniversalBucket.getFilledBucket(SAItemManager.HgBucket, SAFluidManager.fluidMercury), SAItemManager.mercuryDrop, SAItemManager.mercuryDrop, SAItemManager.mercuryDrop, Items.BUCKET);
		
		//FURNACE RECIPES
		GameRegistry.addSmelting(SABlockManager.orecinnabar, new ItemStack(SAItemManager.mercuryDrop), 3.0F);
	}
	
	/** Post-initialization event. This is called when Forge is finishing startup, and is where the mods communicate with one another.
	 *  This event is used to turn on or off specific parts of mods, depending if others are present.
	 *  For example: if two mods add a copper ingot, this is where one of them would be disabled in favor of the other.
	 *  This is where mod setup is completed.
	 *  
	 * @param e The event itself. This parameter can be used to call side-only methods.
	 */
	@EventHandler 
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
