package com.cosmicspd.manager;

// represents a homesick (sub)system. some examples include: modules, ?, ?, and ?
// TODO: fill out this class more
public abstract class System<T> {
    private final String name;

    public void init() {}
    public System(String name) {
        this.name = name;
    }

}
