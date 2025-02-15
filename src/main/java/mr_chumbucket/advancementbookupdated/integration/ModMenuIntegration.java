package mr_chumbucket.advancementbookupdated.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;
import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;

public final class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent, AdvancementBookUpdated.MOD_ID);
    }
}