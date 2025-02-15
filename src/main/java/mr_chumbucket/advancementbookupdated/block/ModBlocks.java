package mr_chumbucket.advancementbookupdated.block;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ADVANCEMENT_BOOKSTAND = register("advancement_bookstand",
            new AdvancementBookstandBlock(AbstractBlock.Settings.create().mapColor(MapColor.RED).strength(5.0F, 1200.0F)));

    public static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(AdvancementBookUpdated.MOD_ID, id), block);
    }

    public static void load() {
        AdvancementBookUpdated.LOGGER.info("Loading blocks!");
    }
}