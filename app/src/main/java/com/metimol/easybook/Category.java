package com.metimol.easybook;

import java.util.Objects;

public class Category {
    private final String id;
    private final String name;
    private final int image;

    public Category(String id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(image, category.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }
}