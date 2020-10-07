package com.daversini.cavesandcliffs.init;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.blocks.CopperBlock;
import com.daversini.cavesandcliffs.blocks.CopperOre;
import com.daversini.cavesandcliffs.blocks.LightningRod;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CavesAndCliffs.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> LIGHTNING_ROD = BLOCKS.register("lightning_rod", LightningRod::new);
}
