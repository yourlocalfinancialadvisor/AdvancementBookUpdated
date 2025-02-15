package mr_chumbucket.advancementbookupdated.mixin;

import mr_chumbucket.advancementbookupdated.AdvancementBookUpdatedConfig;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
	protected GameMenuScreenMixin(Text title) {
		super(title);
	}

	@Inject(method = "initWidgets()V", at = @At(value = "RETURN") )
	public void initWidgets(CallbackInfo ci) {
		if (AdvancementBookUpdatedConfig.DISABLE_ADVANCEMENT_BUTTON && this.client != null) {
			final List<Drawable> drawables = ((ScreenMixin) this).getDrawables();

			for (Drawable drawable : drawables) {
				if (drawable instanceof ClickableWidget widget && widget.getMessage().getString().equals(I18n.translate("gui.advancements"))) {
					widget.active = false;
					break;
				}
			}
		}
	}
}
