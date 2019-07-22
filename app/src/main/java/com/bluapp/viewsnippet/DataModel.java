package com.bluapp.viewsnippet;

public class DataModel {
    private String title;
    private String details;
    private String progress;
    private String color;
    private int imagePath;

    public DataModel() {
    }

    public DataModel(String title, String details, String progress, String color, int imagePath) {
        this.title = title;
        this.details = details;
        this.progress = progress;
        this.color = color;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getProgress() {
        return progress;
    }

    public String getColor() {
        return color;
    }

    public int getImagePath() {
        return imagePath;
    }
}
