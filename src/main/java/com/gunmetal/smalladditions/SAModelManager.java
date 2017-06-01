package com.gunmetal.smalladditions;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;

public class SAModelManager {
	public static final SAModelManager INSTANCE = new SAModelManager();
	private static final String FLUID_RESOURCE_PATH = Constants.RESOURCE_PREFIX + "fluid";
	
	private SAModelManager() {
		
	}
	
	private void registerFluidModels(Fluid fluid) {
		
	}
	
	void registerFluidModel(BlockFluidBase fluidBlock) {
		final Item item = Item.getItemFromBlock(fluidBlock);
		assert item != null;
		ModelBakery.registerItemVariants(item);
		final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(FLUID_RESOURCE_PATH, fluidBlock.getFluid().getName());
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return modelResourceLocation;
			}
		});
		ModelLoader.setCustomStateMapper(fluidBlock, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState p_178132_1_) {
				return modelResourceLocation;
			}
		});
	}
}
