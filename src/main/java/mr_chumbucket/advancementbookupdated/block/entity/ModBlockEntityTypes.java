package mr_chumbucket.advancementbookupdated.block.entity;

import com.mojang.datafixers.types.Type;
import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import mr_chumbucket.advancementbookupdated.block.ModBlocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModBlockEntityTypes {
    public static final BlockEntityType<AdvancementBookStandBlockEntity> ADVANCEMENT_BOOKSTAND = register("advancement_bookstand",
            BlockEntityType.Builder.create(AdvancementBookStandBlockEntity::new, ModBlocks.ADVANCEMENT_BOOKSTAND)
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String id, BlockEntityType.Builder<T> blockEntityType) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AdvancementBookUpdated.MOD_ID, id), blockEntityType.build(type));
    }

    public static void load() {
        AdvancementBookUpdated.LOGGER.info("Loading block entity types!");
    }
}
