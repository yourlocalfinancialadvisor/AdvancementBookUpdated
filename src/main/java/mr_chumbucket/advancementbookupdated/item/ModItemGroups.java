package mr_chumbucket.advancementbookupdated.item;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ADVANCEMENT_BOOK = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AdvancementBookUpdated.MOD_ID, "advancement_book"),
            FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup." + AdvancementBookUpdated.MOD_ID + ".advancement_book"))
            .icon(() -> new ItemStack(ModItems.ADVANCEMENT_BOOK))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.ADVANCEMENT_BOOK);
                entries.add(ModItems.ADVANCEMENT_BOOKSTAND);
            })
            .build()
    );

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(AdvancementBookUpdated.MOD_ID, id));
    }

    public static void load() {
        AdvancementBookUpdated.LOGGER.info("Loading item groups!");
    }
}
