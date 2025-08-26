package com.cosmicspd;

import com.cosmicspd.manager.Manager;
import com.cosmicspd.modules.Categories;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.MixinEnvironment;

public class Homesick implements ClientModInitializer {
	public static final String MOD_ID = "homesick";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            LOGGER.info("force loading mixins...");
            MixinEnvironment.getCurrentEnvironment().audit();
        }

        Categories.init(); // init categories so manager->modules has access
        Manager.init(); // init manager & systems

		LOGGER.info("feeling homesick? :c");
	}
}