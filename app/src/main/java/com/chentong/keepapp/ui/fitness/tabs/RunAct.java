package com.chentong.keepapp.ui.fitness.tabs;

public class RunAct {

    private String title;
    private String content;

    private int imageID;

    public RunAct(String title, String content, int imageID) {
        this.title = title;
        this.content = content;
        this.imageID = imageID;
    }
    public String getTitle(){
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImageID() {
        return imageID;
    }
}
