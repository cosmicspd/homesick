package com.cosmicspd.modules;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected final MinecraftClient mc;

    public final String name;
    public final Category category;
    public final String description;


    public Module(String name, Category category, String description) {
        this.mc = MinecraftClient.getInstance();

        this.name = name;
        this.category = category;
        this.description = description;
    }
}

