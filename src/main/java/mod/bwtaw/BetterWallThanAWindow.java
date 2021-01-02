package mod.bwtaw;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.text.LiteralText;
import org.lwjgl.input.Keyboard;

@Environment(EnvType.CLIENT)
public class BetterWallThanAWindow implements ClientModInitializer {
	public static boolean hidePlayers = false;
	private static KeyBinding keyBinding;
	@Override
	public void onInitializeClient() {
		keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.bwtaw.hide", // The translation key of the keybinding's name
				Keyboard.KEY_F12,
				"key.category.bwtaw" // The translation key of the keybinding's category.
		));
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
				hidePlayers=!hidePlayers;
					client.player.sendMessage(new LiteralText("Players are now "+ ((hidePlayers)?"Hidden":"Shown")));
			}
		});
	}
}
