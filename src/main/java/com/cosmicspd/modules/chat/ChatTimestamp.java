package com.cosmicspd.modules.chat;

import com.cosmicspd.modules.Categories;
import com.cosmicspd.modules.Module;
import com.cosmicspd.modules.Modules;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.text.Text;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public class ChatTimestamp extends Module {
    public boolean secEnabled;
    public boolean militaryTime;
    protected boolean active;

    public ChatTimestamp() {
        super("chatTimestamp", Categories.CHAT, "adds a timestamp to the beginning of every chat message.");
        secEnabled = false;
        militaryTime = false;
        active = true;

        ClientReceiveMessageEvents.ALLOW_CHAT.register((message, signedMessage, sender, params, receptionTimestamp) -> {
            if (active) {
                String timestamp = formatTime(receptionTimestamp);
                mc.getInstance().inGameHud.getChatHud().addMessage(Text.literal(timestamp + " ").append(message));
                return false;
            }
            return true;
        });
    }

    public String formatTime(Instant instant) {
        LocalTime time = LocalTime.ofInstant(instant, ZoneId.systemDefault());
        String timestamp = "[";

        if (!militaryTime) timestamp += String.format("%02d", (time.getHour() % 12 == 0) ? "12" : time.getHour() % 12);
        else timestamp += String.format("%02d", time.getHour());

        timestamp += ":" + String.format("%02d", time.getMinute());

        if (secEnabled) timestamp += ":" + String.format("%02d", time.getSecond());

        if (!militaryTime) timestamp += (time.getHour() < 12) ? "am]" : "pm]";
        else timestamp += "]";

        return timestamp;
    }

    public void toggle() {
        if (!active) Modules.activate(this);
        else Modules.deactivate(this);

        active = !active;
    }

    public boolean status() {
        return active;
    }
}
