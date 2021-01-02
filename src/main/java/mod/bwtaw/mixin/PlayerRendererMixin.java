package mod.bwtaw.mixin;

import mod.bwtaw.BetterWallThanAWindow;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerRendererMixin {
    @Inject(at=@At("HEAD"), method="render", cancellable = true)
    private void hidePlayers(AbstractClientPlayerEntity abstractClientPlayerEntity, double d, double e, double f, float g, float h, CallbackInfo info) {
        if (BetterWallThanAWindow.hidePlayers) {
            info.cancel();
        }
    }
}
