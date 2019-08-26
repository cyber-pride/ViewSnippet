package com.bluapp.viewsnippet;

public class DocHistoryModel {
    private String datetime;
    private String name;
    private String details;

    public DocHistoryModel() {
    }

    public DocHistoryModel(String datetime, String name, String details) {
        this.datetime = datetime;
        this.name = name;
        this.details = details;
    }

    public String getDateTime() {
        return datetime;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }
}
