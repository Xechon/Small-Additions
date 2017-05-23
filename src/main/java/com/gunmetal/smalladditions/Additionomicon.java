package com.gunmetal.smalladditions;

import com.gunmetal.smalladditions.gui.TestGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Additionomicon extends Item {
	public static final String NAME = "additionbook";
	
	public static TestGui bookGui = new TestGui();
	
	public Additionomicon() {
		super();
		this.setRegistryName(NAME);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(Constants.SACTAB);
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		bookGui.buildGui();
		bookGui.draw(bookGui);
        return new ActionResult(EnumActionResult.PASS, itemStackIn); 
	}
}
