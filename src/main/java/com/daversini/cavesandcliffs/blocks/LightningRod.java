package com.daversini.cavesandcliffs.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class LightningRod extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(7, 0, 7, 9, 11, 9), Block.makeCuboidShape(5.5, 0, 5.5, 10.5, 16, 10.5), IBooleanFunction.SECOND); //Second shape: y1 = 11
    private static final VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(7, 0, 7, 9, 11, 9), Block.makeCuboidShape(5.5, 0, 5.5, 10.5, 16, 10.5), IBooleanFunction.SECOND);
    private static final VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(7, 0, 7, 9, 11, 9), Block.makeCuboidShape(5.5, 0, 5.5, 10.5, 16, 10.5), IBooleanFunction.SECOND);
    private static final VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(7, 0, 7, 9, 11, 9), Block.makeCuboidShape(5.5, 0, 5.5, 10.5, 16, 10.5), IBooleanFunction.SECOND);

    public LightningRod() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f, 4.0f)
                .sound(SoundType.METAL)
                .harvestLevel(0)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE));
    }

     @Nullable
     @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6F;
    }
}
