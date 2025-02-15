package mr_chumbucket.advancementbookupdated;

import mr_chumbucket.advancementbookupdated.block.entity.ModBlockEntityTypes;
import mr_chumbucket.advancementbookupdated.renderer.AdvancementBookStandRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

public class AdvancementBookUpdatedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Block entity renderer
		BlockEntityRendererFactories.register(ModBlockEntityTypes.ADVANCEMENT_BOOKSTAND, AdvancementBookStandRenderer::new);

		// Programmer art resource pack
		FabricLoader.getInstance().getModContainer(AdvancementBookUpdated.MOD_ID).ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(Identifier.of(AdvancementBookUpdated.MOD_ID, "advancement_book_programmer_art"), modContainer, ResourcePackActivationType.NORMAL);
		});
	}
}
