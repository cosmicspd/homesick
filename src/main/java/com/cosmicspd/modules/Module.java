package com.cosmicspd.modules;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected final MinecraftClient client;

    public final String name;
    public final Category category;
    public final String description;


    public Module(String name, Category category, String description) {
        this.client = MinecraftClient.getInstance();

        this.name = name;
        this.category = category;
        this.description = description;
    }
}

