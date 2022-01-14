package mod.bwtaw;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.Keyboard;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class BetterWallThanAWindow implements ClientModInitializer {
	public static boolean hidePlayers = false;
	private static KeyBinding keyBinding;
	@Override
	public void onInitializeClient() {
		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.bwtaw.hide", // The translation key of the keybinding's name
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_F12,
				"key.category.bwtaw" // The translation key of the keybinding's category.
		));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
				hidePlayers=!hidePlayers;
					client.player.sendMessage(new LiteralText("Players are now "+ ((hidePlayers)?"Hidden":"Shown")),false);
			}
		});
	}
}
