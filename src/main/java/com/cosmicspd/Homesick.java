package com.cosmicspd;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Homesick implements ClientModInitializer {
	public static final String MOD_ID = "homesick";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static KeyBinding GUI_BIND;

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        GUI_BIND = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.homesick.gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_HOME,
                "category.homesick.binds"
        ));

		LOGGER.info("feeling homesick? :c");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (GUI_BIND.wasPressed()) {
                MinecraftClient.getInstance().player.sendMessage(Text.literal("§5§omissing home..."), false);
            }
        });
	}
}