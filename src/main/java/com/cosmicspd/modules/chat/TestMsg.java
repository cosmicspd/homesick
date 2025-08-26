package com.cosmicspd.modules.chat;

import com.cosmicspd.modules.Categories;
import com.cosmicspd.modules.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class TestMsg extends Module {
    private final KeyBinding keybind;

    public TestMsg() {
        super("testmsg",
                Categories.CHAT,
                "posts test message into chat when activated"
                );

        keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.homesick.testmsg",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_HOME,
                "category.homesick.chat"
                ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keybind.wasPressed()) {
                sendTestMsg();
            }
        });
    }

    public void sendTestMsg() {
        MinecraftClient.getInstance().player.sendMessage(Text.literal("§5§omissing home..."), false);
    }

}
