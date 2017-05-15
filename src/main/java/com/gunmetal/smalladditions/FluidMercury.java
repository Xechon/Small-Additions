package com.gunmetal.smalladditions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;

public class FluidMercury extends Fluid{
	
	public FluidMercury() {
		super("Mercury", new ResourceLocation("smalladditions:blocks/mercurystill"), new ResourceLocation("smalladditions:blocks/mercuryflowing"));
		this.setUnlocalizedName("fluidMercury");
	}
}
