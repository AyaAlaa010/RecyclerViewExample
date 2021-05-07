package com.example.recyclerviewexample;

import java.io.Serializable;

public class story implements Serializable {
    private String name;
    private int imageStory;
    String description="my description";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public story(String name, int imageStory) {
        this.name = name;
        this.imageStory = imageStory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageStory() {
        return imageStory;
    }

    public void setImageStory(int imageStory) {
        this.imageStory = imageStory;
    }


}
