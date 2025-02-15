package mr_chumbucket.advancementbookupdated.mixin;

import com.mojang.authlib.GameProfile;
import mr_chumbucket.advancementbookupdated.AdvancementBookUpdated;
import mr_chumbucket.advancementbookupdated.data.IGivenBook;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandlerListener;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity implements ScreenHandlerListener, IGivenBook {
	private ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Unique
	private boolean givenBook = false;

	@Inject(at = @At("TAIL"), method="readCustomDataFromNbt(Lnet/minecraft/nbt/NbtCompound;)V")
	private void readCustomDataFromTag(NbtCompound tag, CallbackInfo info) {
		if(tag.contains(AdvancementBookUpdated.MOD_ID+"mod")) {
			NbtCompound advancementBookTag = tag.getCompound(AdvancementBookUpdated.MOD_ID+"mod");
			if(advancementBookTag.contains("givenBook")) {
				this.givenBook = advancementBookTag.getBoolean("givenBook"); 
			}
			
		}
	}
	
	@Inject(at = @At("TAIL"), method="writeCustomDataToNbt(Lnet/minecraft/nbt/NbtCompound;)V")
	private void writeCustomDataToTag(NbtCompound tag, CallbackInfo info) {
		NbtCompound advancementBookTag = new NbtCompound();
		advancementBookTag.putBoolean("givenBook", this.givenBook);
		tag.put(AdvancementBookUpdated.MOD_ID+"mod", advancementBookTag);
	}

	@Override
	public boolean advancement_book_updated$isGivenBook() {
		return givenBook;
	}
	
	@Override
	public void advancement_book_updated$setGivenBook(boolean givenBook) {
		this.givenBook = givenBook;
	}
}
