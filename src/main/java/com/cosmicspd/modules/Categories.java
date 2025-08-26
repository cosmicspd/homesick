package com.cosmicspd.modules;

public class Categories {
    public static final Category COMBAT = new Category("combat");
    public static final Category PLAYER = new Category("player");
    public static final Category MOVEMENT = new Category("movement");
    public static final Category RENDER = new Category("render");
    public static final Category WORLD = new Category("world");
    public static final Category CHAT = new Category("chat");
    public static final Category MISC = new Category("misc.");
    public static final Category CLIENT = new Category("settings");

    public static boolean initialized = false;

    public static void init() {
        if (initialized) return;

        Modules.registerCategory(COMBAT);
        Modules.registerCategory(PLAYER);
        Modules.registerCategory(MOVEMENT);
        Modules.registerCategory(RENDER);
        Modules.registerCategory(WORLD);
        Modules.registerCategory(CHAT);
        Modules.registerCategory(MISC);
        Modules.registerCategory(CLIENT);

        initialized = true;
    }
}
