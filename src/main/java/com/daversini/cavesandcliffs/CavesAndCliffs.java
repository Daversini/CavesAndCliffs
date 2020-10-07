package com.daversini.cavesandcliffs;

import com.daversini.cavesandcliffs.entities.WardenEntity;
import com.daversini.cavesandcliffs.init.ModBlocks;
import com.daversini.cavesandcliffs.init.ModEntityType;
import com.daversini.cavesandcliffs.init.ModItems;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cavesandcliffs")
public class CavesAndCliffs {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cavesandcliffs";

    public CavesAndCliffs() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityType.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityType.WARDEN.get(), WardenEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    //Mod Tab
    public static final ItemGroup TAB = new ItemGroup("cavesAndCliffsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.WARDEN_SPAWN_EGG.get());
        }
    };
}
