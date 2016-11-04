package raqbit.forgemod.ircr.mc;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import raqbit.forgemod.ircr.mc.blocks.ModBlocks;

/**
 * Created by Raqbit on 30-10-16.
 */
public class Recipes {

    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.maunzInterface), "IDI","LSL","IFI",'I', Blocks.iron_block, 'D', Items.diamond, 'L', Items.leather,'S', Items.skull, 'F', Items.cooked_fished);
    }
}
