package test.testerer.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import test.testerer.block.ModBlockEntities;

public class C4BlockEntity extends BlockEntity {
    public C4BlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.C4_BLOCK_ENTITY, pos, state);
    }
}
