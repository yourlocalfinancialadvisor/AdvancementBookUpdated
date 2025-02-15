package mr_chumbucket.advancementbookupdated.block.entity;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import mr_chumbucket.advancementbookupdated.block.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {
    public static final BlockEntityType<AdvancementBookStandBlockEntity> ADVANCEMENT_BOOKSTAND = register("advancement_bookstand",
            BlockEntityType.Builder.create(AdvancementBookStandBlockEntity::new, ModBlocks.ADVANCEMENT_BOOKSTAND).build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType<T> blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AdvancementBookUpdated.MOD_ID, id), blockEntityType);
    }

    public static void load() {
        AdvancementBookUpdated.LOGGER.info("Loading block entity types!");
    }
}
