package com.gunmetal.smalladditions;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAFluidManager {
	
	public static Fluid fluidMercury;
	public static BlockFluidFinite liquidMercury = new LiquidMercury();
	
	public static void register() {
		registerFluids();
		registerFluidBlocks(liquidMercury);
	}
	
	public static void registerFluids() {
		fluidMercury = createFluid("Mercury", "mercury", true);
		setBucketforFluids(fluidMercury);
		FluidRegistry.registerFluid(fluidMercury);
	}
	
	public static void registerFluidBlocks(BlockFluidFinite input) {
		String fluidName = input.getFluid().getUnlocalizedName();
		input.setUnlocalizedName(fluidName);
		GameRegistry.register(input);
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

	public static void setBucketforFluids(Fluid fluid) {
		FluidRegistry.addBucketForFluid(fluid);
	}
}
