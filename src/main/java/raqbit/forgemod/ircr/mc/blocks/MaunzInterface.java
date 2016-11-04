package raqbit.forgemod.ircr.mc.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import raqbit.forgemod.ircr.IRCR;
import raqbit.forgemod.ircr.mc.blocks.tileentity.MaunzInterfaceTileEntity;

/**
 * Created by Raqbit on 30-10-16.
 */
public class MaunzInterface extends BlockContainer implements ITileEntityProvider {

    public IIcon[] icons = new IIcon[6];

    public static BlockContainer instance;

    protected MaunzInterface(Material material, String unlocalizedName) {

        super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(IRCR.MODID + ":" + unlocalizedName + "_side");
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(3F);
        this.setResistance(20.0F);
        this.setStepSound(soundTypeMetal);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {

        for (int i = 0; i < 6; i++) {
            if (i <= 1) {
                this.icons[i] = reg.registerIcon(getTextureName().substring(0, getTextureName().length() - 5) + "_top_bottom");
            } else {
                this.icons[i] = reg.registerIcon(getTextureName());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return this.icons[side];
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new MaunzInterfaceTileEntity();
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }
}
