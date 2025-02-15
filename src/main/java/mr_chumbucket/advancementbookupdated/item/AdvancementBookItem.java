package mr_chumbucket.advancementbookupdated.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AdvancementBookItem extends Item {
    public AdvancementBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            this.openAdvancementGUI();
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }


    @Environment(EnvType.CLIENT)
    private void openAdvancementGUI() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player == null){
            return;
        }
        mc.setScreen(new AdvancementsScreen(mc.player.networkHandler.getAdvancementHandler()));
    }
}
