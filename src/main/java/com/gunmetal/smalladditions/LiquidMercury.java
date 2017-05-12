package com.gunmetal.smalladditions;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LiquidMercury extends BlockFluidFinite implements IFluidBlock {
	
	private FluidMercury fluidMercury = new FluidMercury();
	
	public LiquidMercury() { 
		super(new FluidMercury(), Material.WATER);
		this.setUnlocalizedName("liquidMercury");
		this.setRegistryName("liquidMercury");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) {
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.LIQUID;
	}
	
	@Override
	public Fluid getFluid() {
		return fluidMercury;
	}
}
