package test.testerer.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.NotNull;
import test.testerer.ModLogger;
import test.testerer.Testerer;
import test.testerer.block.custom.C4BlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<@NotNull C4BlockEntity> C4_BLOCK_ENTITY =
            register("counter", C4BlockEntity::new, ModBlocks.C4);

    private static <T extends BlockEntity> BlockEntityType<@NotNull T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends @NotNull T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Testerer.id(name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void initialise() {
        ModLogger.devLogger("initialising mod block entities");
    }
}
