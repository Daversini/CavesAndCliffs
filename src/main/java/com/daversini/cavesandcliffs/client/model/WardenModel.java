package com.daversini.cavesandcliffs.client.model;

import com.daversini.cavesandcliffs.entities.WardenEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WardenModel<T extends WardenEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer warden_right_leg;
    private final ModelRenderer warden_left_leg;
    private final ModelRenderer warden_left_arm;
    private final ModelRenderer warden_right_arm;
    private final ModelRenderer warden_body;
    private final ModelRenderer warden_head;
    private final ModelRenderer left_horn;
    private final ModelRenderer right_horn;

    public WardenModel() {
        textureWidth = 128;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -7.0F, 0.0F);


        warden_right_leg = new ModelRenderer(this);
        warden_right_leg.setRotationPoint(-6.0F, 18.0F, 0.0F);
        body.addChild(warden_right_leg);
        warden_right_leg.setTextureOffset(58, 36).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);

        warden_left_leg = new ModelRenderer(this);
        warden_left_leg.setRotationPoint(6.0F, 18.0F, 0.0F);
        body.addChild(warden_left_leg);
        warden_left_leg.setTextureOffset(82, 36).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F, 0.0F, false);

        warden_left_arm = new ModelRenderer(this);
        warden_left_arm.setRotationPoint(11.0F, 2.0F, 0.0F);
        body.addChild(warden_left_arm);
        warden_left_arm.setTextureOffset(84, 0).addBox(-2.0F, -4.0F, -4.0F, 8.0F, 28.0F, 8.0F, 0.0F, false);

        warden_right_arm = new ModelRenderer(this);
        warden_right_arm.setRotationPoint(-11.0F, 2.0F, 0.0F);
        body.addChild(warden_right_arm);
        warden_right_arm.setTextureOffset(52, 0).addBox(-6.0F, -4.0F, -4.0F, 8.0F, 28.0F, 8.0F, 0.0F, false);

        warden_body = new ModelRenderer(this);
        warden_body.setRotationPoint(0.0F, 31.0F, 0.0F);
        body.addChild(warden_body);
        warden_body.setTextureOffset(0, 26).addBox(-9.0F, -33.0F, -5.0F, 18.0F, 20.0F, 11.0F, 0.0F, false);

        warden_head = new ModelRenderer(this);
        warden_head.setRotationPoint(0.0F, -2.0F, 0.0F);
        body.addChild(warden_head);
        warden_head.setTextureOffset(0, 0).addBox(-8.0F, -16.0F, -5.0F, 16.0F, 16.0F, 10.0F, 0.0F, false);

        left_horn = new ModelRenderer(this);
        left_horn.setRotationPoint(8.0F, -10.0F, 0.0F);
        warden_head.addChild(left_horn);
        left_horn.setTextureOffset(106, 46).addBox(0.0F, -9.0F, 0.0F, 10.0F, 10.0F, 0.0F, 0.0F, false);

        right_horn = new ModelRenderer(this);
        right_horn.setRotationPoint(-8.0F, -10.0F, 0.0F);
        warden_head.addChild(right_horn);
        right_horn.setTextureOffset(106, 36).addBox(-10.0F, -9.0F, 0.0F, 10.0F, 10.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.warden_head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.warden_head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        //this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.warden_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.warden_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.warden_right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.2F * limbSwingAmount;
        this.warden_left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
