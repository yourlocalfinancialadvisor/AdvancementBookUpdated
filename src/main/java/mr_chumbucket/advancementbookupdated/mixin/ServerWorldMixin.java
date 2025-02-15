package mr_chumbucket.advancementbookupdated.mixin;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdatedConfig;
import mr_chumbucket.advancementbookupdated.data.IGivenBook;
import mr_chumbucket.advancementbookupdated.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
	
	@Inject(at = @At("TAIL"), method="addPlayer(Lnet/minecraft/server/network/ServerPlayerEntity;)V")
	private void addPlayer(ServerPlayerEntity player, CallbackInfo info) {
		if(AdvancementBookUpdatedConfig.GIVE_FIRST_JOIN) {
			IGivenBook playerMixin = (IGivenBook)player;
			if(!playerMixin.advancement_book_updated$isGivenBook()) {
				player.getInventory().insertStack(new ItemStack(ModItems.ADVANCEMENT_BOOK));
				playerMixin.advancement_book_updated$setGivenBook(true);
			}
		}
	}
}
