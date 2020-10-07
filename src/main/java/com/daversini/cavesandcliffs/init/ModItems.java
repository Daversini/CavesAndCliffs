package com.daversini.cavesandcliffs.init;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.blocks.BlockItemBase;
import com.daversini.cavesandcliffs.items.ItemBase;
import com.daversini.cavesandcliffs.items.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CavesAndCliffs.MOD_ID);

    //Block items
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore",
            () -> new BlockItemBase(ModBlocks.COPPER_ORE.get()));

    public static final RegistryObject<Item> COPPER_BLOCK = ITEMS.register("copper_block",
            () -> new BlockItemBase(ModBlocks.COPPER_BLOCK.get()));

    public static final RegistryObject<Item> LIGHTNING_ROD_ITEM = ITEMS.register("lightning_rod",
            () -> new BlockItemBase(ModBlocks.LIGHTNING_ROD.get()));


    //Items
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ItemBase::new);
    public static final RegistryObject<ModSpawnEggItem> WARDEN_SPAWN_EGG = ITEMS.register("warden_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.WARDEN, 0x0C5D6A, 0x50F0E9, new Item.Properties().group(CavesAndCliffs.TAB)));
}
