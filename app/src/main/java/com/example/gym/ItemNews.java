package com.example.gym;

public class ItemNews {
    private String name;
    private int imageId;
    private String text;
    public ItemNews(String name, int imageId, String text) {
        this.name = name;
        this.imageId = imageId;
        this.text=text;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public String getText() {
        return text;
    }


}
