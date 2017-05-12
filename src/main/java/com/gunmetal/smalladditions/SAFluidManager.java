package com.gunmetal.smalladditions;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAFluidManager {
	
	public static Fluid fluidMercury;
	public static BlockFluidFinite liquidMercury;
	
	public static void registerFluids() {
		fluidMercury = createFluid("Mercury", "mercury", true);
	}
	
	public static void registerFluidBlocks(BlockFluidFinite input) {
		String fluidName = input.getFluid().getUnlocalizedName();
		input.setUnlocalizedName(fluidName);
		GameRegistry.registerBlock(input, fluidName);
	}
	
	public static Fluid createFluid(String name, String textureName, boolean hasFlowIcon) {
		ResourceLocation still = new ResourceLocation(textureName + "_still");
		ResourceLocation flowing;
		if (hasFlowIcon) {
			flowing = new ResourceLocation(textureName + "_flow");
		} else {
			flowing = still;
		}
		Fluid fluid = new Fluid(name, still, flowing);
		return fluid;
	}
}
