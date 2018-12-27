package com.example.gym;

public class ItemGym{
        private String name;
        private int imageId;
        public ItemGym(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }
        public String getName(){
            return name;
        }
        public int getImageId(){
            return imageId;
        }
}
