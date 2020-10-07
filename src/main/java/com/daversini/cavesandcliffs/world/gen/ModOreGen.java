package com.daversini.cavesandcliffs.world.gen;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = CavesAndCliffs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    //Filler block END Dimension
    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE));
    //TIP: Posso far generare il minerale vicino al blocco che voglio

    @SubscribeEvent
    public static void generateOre(FMLLoadCompleteEvent event) {
        for (Biome biome: ForgeRegistries.BIOMES) {

            //Nether Generation
            if (biome.getCategory() == Biome.Category.NETHER) {
                //genOre(biome, 12, 5, 5, 80, OreFeatureConfig.FillerBlockType.NETHERRACK, //Rarity: 12, Lowest Y value: 5, Highest Y value: 75 (80 - 5)
                //RegistryHandler.RUBY_ORE.get().getDefaultState(), 4);   //Ore generated: RUBY_ORE, Max Vein: 4

                //End Generation
            } else if (biome.getCategory() == Biome.Category.THEEND) {
                //genOre(biome, 18, 5, 3, 80, END_STONE, //Rarity: 18, Lowest Y value: 3, Highest Y value: 75 (80 - 5)
                //RegistryHandler.RUBY_ORE.get().getDefaultState(), 12);   //Ore generated: RUBY_ORE, Max Vein: 12

                //World Generation
            } else {
                genOre(biome, 10, 8, 5, 50, OreFeatureConfig.FillerBlockType.NATURAL_STONE, //Rarity: 10, Lowest Y value: 8, Highest Y value: 45 (50 - 5)
                        ModBlocks.COPPER_ORE.get().getDefaultState(), 6);   //Ore generated: RUBY_ORE, Max Vein: 6
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}

