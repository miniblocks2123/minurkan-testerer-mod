package test.testerer.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.awt.*;

public class C4Block extends BaseEntityBlock {
	public static final EnumProperty<@NotNull Direction> FACING = BlockStateProperties.FACING;
	public static final MapCodec<C4Block> CODEC = simpleCodec(C4Block::new);
	private static final VoxelShape SHAPE_NORTH = Block.box(4, 2, 13, 12, 14, 16);
	private static final VoxelShape SHAPE_SOUTH = Block.box(4, 2, 0, 12, 14, 3);
	private static final VoxelShape SHAPE_WEST = Block.box(13, 2, 4, 16, 14, 12);
	private static final VoxelShape SHAPE_EAST = Block.box(0, 2, 4, 3, 14, 12);
	private static final VoxelShape SHAPE_UP = Block.box(4, 0, 2, 12, 3, 14);
	private static final VoxelShape SHAPE_DOWN = Block.box(4, 13, 2, 12, 16, 14);

	public C4Block(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
	}

	private static VoxelShape getShapeForDirection(Direction direction) {
		return switch (direction) {
			case UP -> SHAPE_UP;
			case DOWN -> SHAPE_DOWN;
			case NORTH -> SHAPE_NORTH;
			case SOUTH -> SHAPE_SOUTH;
			case EAST -> SHAPE_EAST;
			case WEST -> SHAPE_WEST;
		};
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getClickedFace());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	protected BlockState mirror(BlockState state, Mirror mirror) {
		return super.mirror(state, mirror);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return getShapeForDirection(state.getValue(FACING));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return getShapeForDirection(state.getValue(FACING));
	}

	// Create block entity
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new C4BlockEntity(pos, state);
	}


	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		return InteractionResult.SUCCESS;
	}
}