package com.gunmetal.smalladditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestBlock extends Block{
	
	public TestBlock() {
		super(Material.ROCK);
		this.setRegistryName("testblock");
		this.setUnlocalizedName("testblock");
		this.setCreativeTab(Constants.SACTAB);
	}
	
	@Override 
	public boolean isOpaqueCube(IBlockState iBlockState) {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() { 
		return BlockRenderLayer.SOLID;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) { 
		return true;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}

}
