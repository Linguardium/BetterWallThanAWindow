package mod.bwtaw.mixin;

import mod.bwtaw.BetterWallThanAWindow;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public class PlayerRendererMixin {
    @Inject(at=@At("HEAD"), method="render", cancellable = true)
    private void hidePlayers(AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo info) {
        if (BetterWallThanAWindow.hidePlayers) {
            info.cancel();
        }
    }
    @Inject(at=@At("HEAD"), method="renderLabelIfPresent", cancellable = true)
    protected void hideLabel(AbstractClientPlayerEntity abstractClientPlayerEntity, Text text, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, CallbackInfo info) {
        if (BetterWallThanAWindow.hidePlayers) {
            info.cancel();
        }
    }
}
