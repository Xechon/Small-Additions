package com.gunmetal.smalladditions;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OreCinnabar extends Block {
	
	public static final String NAME = "orecinnabar";
	
	public OreCinnabar( ) {
		super(Material.ROCK);
		this.blockSoundType = SoundType.STONE;
		this.blockHardness = 2.0F;
		this.blockResistance = 15.0F;
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
		this.setRegistryName(Constants.MODID, NAME);
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
	
	public String getName() { //getter method for this block's name
		return NAME;
	}
	
	

}
