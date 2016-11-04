package raqbit.forgemod.ircr.mc.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import raqbit.forgemod.ircr.mc.blocks.tileentity.MaunzInterfaceTileEntity;

/**
 * Created by Raqbit on 30-10-16.
 */
public class ModBlocks {

    public static Block maunzInterface;

    public static void init()
    {
        GameRegistry.registerBlock(maunzInterface = new MaunzInterface(Material.iron, "maunzInterface"), "maunzInterface");
    }

    public static void initTileEntities()
    {
        GameRegistry.registerTileEntity(MaunzInterfaceTileEntity.class, "maunz_interface_tile_entity");
    }
}
