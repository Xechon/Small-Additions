package com.gunmetal.smalladditions.util;

import com.gunmetal.smalladditions.fluid.LiquidMercury;

import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SAFluidManager {
	
	public static Fluid fluidMercury;
	public static BlockFluidBase liquidMercury;
	
	public static void register() {
		registerFluids();
		liquidMercury = new LiquidMercury(fluidMercury);
		registerFluidBlock(liquidMercury);
	}
	
	public static void registerFluids() {
		fluidMercury = createFluid("liquid_mercury", "liquid_mercury", true);
		FluidRegistry.registerFluid(fluidMercury);
		setBucketforFluids(fluidMercury);
	}
	
	public static void registerFluidBlock(BlockFluidBase input) {
		String fluidName = input.getFluid().getUnlocalizedName();
		input.setUnlocalizedName(fluidName);
		GameRegistry.register(input);
		GameRegistry.register(new ItemBlock(input).setRegistryName(input.getRegistryName()));
	}
	
	public static Fluid createFluid(String name, String textureName, boolean hasFlowIcon) {
		String texturePrefix = Constants.RESOURCE_PREFIX + "blocks/";
		ResourceLocation still = new ResourceLocation(texturePrefix + textureName + "_still");
		ResourceLocation flowing;
		if (hasFlowIcon) {
			flowing = new ResourceLocation(texturePrefix + textureName + "_flow");
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
