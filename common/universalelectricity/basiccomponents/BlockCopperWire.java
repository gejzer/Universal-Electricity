package universalelectricity.basiccomponents;

import java.util.Random;

import universalelectricity.extend.BlockConductor;

import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockCopperWire extends BlockConductor
{
    public BlockCopperWire(int id)
    {
        super(id, Material.cloth);
        this.setBlockName("Copper Wire");
        this.setStepSound(soundClothFootstep);
        this.setResistance(0.2F);
        this.setBlockBounds(0.30F, 0.30F, 0.30F, 0.70F, 0.70F, 0.70F);
        this.setRequiresSelfNotify();
        this.blockIndexInTexture = 7;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
    */
    @Override
    public int getRenderType()
    {
        return -1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BasicComponents.itemCopperWire.shiftedIndex;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    @Override
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityCopperWire();
    }

    @Override
    public String getTextureFile()
    {
        return BasicComponents.blockTextureFile;
    }
}