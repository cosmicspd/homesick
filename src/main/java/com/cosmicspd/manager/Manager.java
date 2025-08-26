package com.cosmicspd.manager;

import com.cosmicspd.modules.Modules;
import java.util.HashMap;

// to explain, the client will have the main Homesick file.
// this will then init the manager who will initialize & manage each subsystem
public class Manager {
    private static final HashMap<Class<? extends System>, System<?>> systems = new HashMap();

    public static void init() {
        add(new Modules());
    }

    public static System<?> add(System<?> system) {
        systems.put(system.getClass(), system);
        system.init();

        return system;
    }

}
