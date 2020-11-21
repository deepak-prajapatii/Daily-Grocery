package com.riseinsteps.dailygrocery.model;

public class CategoryModel {
    private int id;
    private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public CategoryModel(int id, int image) {
        this.id = id;
        this.image = image;
    }
}
