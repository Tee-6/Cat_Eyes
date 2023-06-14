package com.tee_six.cateyes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.lwjgl.glfw.GLFW;

import com.tee_six.cateyes.config.ModConfigs;

@Environment(EnvType.CLIENT)
public class CatEyes implements ClientModInitializer {

	private static KeyBinding toggleBTN;
	Boolean activated = false;

	@Override
	public void onInitializeClient() {
		ModConfigs.registerConfigs();

		toggleBTN = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"Toggle Cat Eyes", //the keybinding's name
			InputUtil.Type.KEYSYM, //KEYSYM for keyboard, MOUSE for mouse.
			GLFW.GLFW_KEY_V, // The keycode of the key
			"Cat Eyes" //the keybinding's category.
		));

		ClientEntityEvents.ENTITY_LOAD.register((entity, clientWorld) -> {
			if (ModConfigs.ACTIVATED == true) {
				activated = true;
			}
		});

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleBTN.wasPressed()) {
				activated = false;
				if (ModConfigs.ACTIVATED == true) {
					client.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
					ModConfigs.ACTIVATED = false;
				} else {
					client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, -1));
					ModConfigs.ACTIVATED = true;
					
					if (client.player.hasStatusEffect(StatusEffects.BLINDNESS) && ModConfigs.BLINDNESS_IMMUNITY == true) {
						client.player.removeStatusEffect(StatusEffects.BLINDNESS);
					}
				}
			}
			if (activated == true) {
				activated = false;

				client.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, -1));
				ModConfigs.ACTIVATED = true;

				if (client.player.hasStatusEffect(StatusEffects.BLINDNESS) && ModConfigs.BLINDNESS_IMMUNITY == true) {
					client.player.removeStatusEffect(StatusEffects.BLINDNESS);
				}
			}
		});
	}
}