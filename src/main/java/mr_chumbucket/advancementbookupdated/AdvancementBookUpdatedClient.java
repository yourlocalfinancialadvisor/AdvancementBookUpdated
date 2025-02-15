package mr_chumbucket.advancementbookupdated;

import mr_chumbucket.advancementbookupdated.block.entity.ModBlockEntityTypes;
import mr_chumbucket.advancementbookupdated.renderer.AdvancementBookStandRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class AdvancementBookUpdatedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockEntityRendererFactories.register(ModBlockEntityTypes.ADVANCEMENT_BOOKSTAND, AdvancementBookStandRenderer::new);
	}
}
