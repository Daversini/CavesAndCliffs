package com.daversini.cavesandcliffs.world.gen;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.init.ModEntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = CavesAndCliffs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {

    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {

        for (Biome biome : ForgeRegistries.BIOMES) {

            //Nether Mobs
            if (biome.getCategory() == Biome.Category.NETHER) {

                //End Mobs
            } else if (biome.getCategory() == Biome.Category.THEEND) {

                //Overworld Mobs
            } else {
                if (biome.getCategory() != Biome.Category.OCEAN) {
                    biome.getSpawns(EntityClassification.MONSTER)
                            .add(new Biome.SpawnListEntry(ModEntityType.WARDEN.get(), 2, 1, 1)); //Rarity: 2, Min group size: 1, Max group size: 1
                }
            }
        }
    }
}
