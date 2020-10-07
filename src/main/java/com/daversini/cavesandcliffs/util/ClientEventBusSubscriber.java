package com.daversini.cavesandcliffs.util;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.client.render.WardenRenderer;
import com.daversini.cavesandcliffs.init.ModEntityType;
import com.daversini.cavesandcliffs.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CavesAndCliffs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.WARDEN.get(), WardenRenderer::new);
    }

    @SubscribeEvent
    public static void onRegistryEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
