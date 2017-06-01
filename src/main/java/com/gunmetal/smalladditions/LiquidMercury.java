package com.gunmetal.smalladditions;

import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LiquidMercury extends BlockFluidClassic implements IFluidBlock {
	
	
	public LiquidMercury(Fluid fluid) {
		super(fluid, new MaterialLiquid(MapColor.SILVER));
		this.setUnlocalizedName(Constants.RESOURCE_PREFIX + "liquid_mercury");
		this.setRegistryName("liquid_mercury");
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
	public Fluid getFluid() {
		return definedFluid;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {  
	        entity.motionX *= 0.1D;
	        entity.motionZ *= 0.1D;
	    }
	  
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (playerIn.getHeldEquipment().equals(Items.BUCKET)) {
			
		}
	}
	
	@Override
	public Vec3d modifyAcceleration(World worldIn, BlockPos pos, Entity entityIn, Vec3d motion)
    {
        return motion;
    }
}
