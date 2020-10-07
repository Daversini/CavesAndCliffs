package com.daversini.cavesandcliffs.init;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.entities.WardenEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CavesAndCliffs.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<WardenEntity>> WARDEN = ENTITY_TYPES.register("warden",
            () -> EntityType.Builder.create(WardenEntity::new, EntityClassification.MONSTER)
                    .size(1.0f, 2.9f)
                    .build(new ResourceLocation(CavesAndCliffs.MOD_ID, "warden").toString()));
}
