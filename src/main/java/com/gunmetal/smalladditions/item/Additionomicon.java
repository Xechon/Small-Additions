package com.gunmetal.smalladditions.item;

import com.gunmetal.smalladditions.Main;
import com.gunmetal.smalladditions.gui.AddBookGui;
import com.gunmetal.smalladditions.util.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Additionomicon extends Item {
	public static final String NAME = "additionbook";
	
	public static AddBookGui bookGui = new AddBookGui();
	
	public Additionomicon() {
		super();
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.openGui(Main.instance, 0, worldIn, 0, 0, 0);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn); 
	}
}
