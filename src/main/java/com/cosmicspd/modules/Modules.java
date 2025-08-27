package com.cosmicspd.modules;

// import com.cosmicspd.modules.combat.*;
// import com.cosmicspd.modules.player.*;
// import com.cosmicspd.modules.movement.*;
// import com.cosmicspd.modules.render.*;
// import com.cosmicspd.modules.world.*;
import com.cosmicspd.modules.chat.*;
// import com.cosmicspd.modules.misc.*;
// import com.cosmicspd.modules.client.*;
import com.cosmicspd.manager.System;
import java.util.*;

public class Modules extends System<Modules> {
    private static List<Category> CATEGORIES = new ArrayList<>();
    private static List<Module> MODULES = new ArrayList<>();
    private static List<Module> active = new ArrayList<>();

    private static HashMap<Class<? extends Module>, Module> moduleObjs = new HashMap<>();

    private static boolean initialized = false;

    public Modules() {
        super("modules");
    }

    public static void registerCategory(Category category) {
        if (Categories.initialized) throw new IllegalStateException("categories already initialized");
        CATEGORIES.add(category);
    }

    private static void add(Module module, Category category) {
        MODULES.add(module);
        moduleObjs.put(module.getClass(), module);
        category.addModule(module);
    }

    public static Module get(Class<? extends Module> modClass) { return moduleObjs.get(modClass); }

    public static void activate(Module module) {
        active.add(module);
    }
    public static void deactivate(Module module) {
        active.remove(module);
    }

    public void init() {
        Categories.init();

        init_cmbt(); // combat
        init_plyr(); // player
        init_mvmt(); // movement
        init_rndr(); // render
        init_wrld(); // world
        init_chat(); // chat
        init_misc(); // misc.
        init_clnt(); // client

        initialized = true;
    }

    private static void init_cmbt() {}
    private static void init_plyr() {}
    private static void init_mvmt() {}
    private static void init_rndr() {}
    private static void init_wrld() {}
    private static void init_chat() {
        add(new TestMsg(), Categories.CHAT);
        add(new ChatTimestamp(), Categories.CHAT);
    }
    private static void init_misc() {}
    private static void init_clnt() {}


}
