package com.cosmicspd.modules;

public class Category {
    public final String name;
    private final int hash;

    public Category(String name) {
        this.name = name;
        this.hash = name.hashCode();
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
