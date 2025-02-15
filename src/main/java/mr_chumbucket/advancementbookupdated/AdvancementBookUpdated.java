package mr_chumbucket.advancementbookupdated;

import eu.midnightdust.lib.config.MidnightConfig;
import mr_chumbucket.advancementbookupdated.block.ModBlocks;
import mr_chumbucket.advancementbookupdated.block.entity.ModBlockEntityTypes;
import mr_chumbucket.advancementbookupdated.item.ModItemGroups;
import mr_chumbucket.advancementbookupdated.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancementBookUpdated implements ModInitializer {
	public static final String MOD_ID = "advancement-book-updated";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting Advancement Book Updated!");

		MidnightConfig.init(MOD_ID, AdvancementBookUpdatedConfig.class);

		ModBlockEntityTypes.load();
		ModBlocks.load();
		ModItems.load();
		ModItemGroups.load();
	}
}