package com.gunmetal.smalladditions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;

public class FluidMercury extends Fluid implements IFluidBlock{
	
	public FluidMercury() {
		super("Mercury", new ResourceLocation("smalladditions:blocks/mercurystill"), new ResourceLocation("smalladditions:blocks/mercuryflowing"));
		
	}

	@Override
	public Fluid getFluid() {
		return this;
	}

	@Override
	public FluidStack drain(World world, BlockPos pos, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDrain(World world, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getFilledPercentage(World world, BlockPos pos) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
