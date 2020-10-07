package com.daversini.cavesandcliffs.client.render;

import com.daversini.cavesandcliffs.CavesAndCliffs;
import com.daversini.cavesandcliffs.client.model.WardenModel;
import com.daversini.cavesandcliffs.entities.WardenEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WardenRenderer extends MobRenderer<WardenEntity, WardenModel<WardenEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CavesAndCliffs.MOD_ID, "textures/entity/warden.png");

    public WardenRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new WardenModel<>(), 0.8f);
    }

    @Override
    public ResourceLocation getEntityTexture(WardenEntity entity) {
        return TEXTURE;
    }
}
