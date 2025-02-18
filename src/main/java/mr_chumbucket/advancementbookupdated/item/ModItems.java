package mr_chumbucket.advancementbookupdated.item;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import mr_chumbucket.advancementbookupdated.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ADVANCEMENT_BOOK = register("advancement_book", new AdvancementBookItem(new Item.Settings().maxCount(1)));
    public static final Item ADVANCEMENT_BOOKSTAND = register("advancement_bookstand", ModBlocks.ADVANCEMENT_BOOKSTAND);

    public static Item register(String id, Block block) {
        return register(id, new BlockItem(block, new Item.Settings()));
    }

    public static Item register(String id, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(AdvancementBookUpdated.MOD_ID, id), item);
    }

    public static void load() {
        AdvancementBookUpdated.LOGGER.info("Loading items!");
    }
}
