package com.gunmetal.smalladditions.block;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GrassyStone extends Block {
	
	private final String NAME = "grassystone";
	public GrassyStone() { //This constructor defines some properties of this Block.
		super(Material.ROCK);
		this.blockSoundType = SoundType.STONE;
		this.blockHardness = 1.5F;
		this.blockResistance = 10.0F;
		this.setCreativeTab(Constants.SACTAB);
		this.setUnlocalizedName(NAME);
		this.setRegistryName(Constants.MODID, NAME);
	}
	
	@Override //all of these Override anns just mean that these methods must override something, else throw a runtime exception
	public boolean isOpaqueCube(IBlockState iBlockState) { //somewhat pointless method that defines this block as opaque
		return true;
	}
	
	@SideOnly(Side.CLIENT) //means that this code is only run client-side
	public BlockRenderLayer getBlockLayer() { //defines this block's render type as solid (otherwise is translucent)
		return BlockRenderLayer.SOLID;
	}
	
	@Override
	public boolean isFullCube(IBlockState iBlockState) { //defines this block as a cube (non-cubes would be stairs or slabs, for example)
		return true;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) { //defines what enumrendertype this block uses (model, in this case)
		return EnumBlockRenderType.MODEL;
	}
	
	public String getName() { //getter method for this block's name
		return NAME;
	}
}
