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

// TODO: activation/deactivation
// TODO: settings
public class Modules extends System<Modules> {

    private static final List<Category> CATEGORIES = new ArrayList<>();
    private static List<Module> MODULES = new ArrayList<>();
    private static List<Module> active = new ArrayList<>();

    private static HashMap<Class<? extends Module>, Module> moduleObjs = new HashMap<>();

    private static boolean initialized = false;

    public Modules() {
        super("modules");
    }

    public static void registerCategory(Category category) {
        if (Categories.initialized) throw new IllegalStateException("categories already initialized - Modules.registerCategory()");

        CATEGORIES.add(category);
    }

    private static void add(Module module) {
        MODULES.add(module);
        moduleObjs.put(module.getClass(), module);
    }

    public void init() {
        init_cmbt(); // combat
        init_plyr(); // player
        init_mvmt(); // movement
        init_rndr(); // render
        init_wrld(); // world
        init_chat(); // chat
        init_misc(); // misc
        init_clnt(); // client

        initialized = true;
    }

    private static void init_cmbt() {}
    private static void init_plyr() {}
    private static void init_mvmt() {}
    private static void init_rndr() {}
    private static void init_wrld() {}
    private static void init_chat() {
        add(new TestMsg());
    }
    private static void init_misc() {}
    private static void init_clnt() {}


}
