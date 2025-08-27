package com.cosmicspd.modules;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public final String name;
    private final int hash;
    private final List<Module> MODULES = new ArrayList<>();
    // icon?

    public Category(String name) {
        this.name = name;
        this.hash = name.hashCode();
    }

    public List<Module> getModules() {
        return MODULES;
    }

    public void addModule(Module module) {
        MODULES.add(module);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category other = (Category) o;
        return hash == other.hash;
    }

    @Override
    public int hashCode() {
        return hash;
    }
}
