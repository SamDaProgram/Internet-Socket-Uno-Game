package com.config;

import java.awt.image.CropImageFilter;

public class Image {
    public static String getFileName(int value) throws Exception {
        String fileName = null;
        if(value<=79){
            fileName= CardData.getColor(value) +"_"+ CardData.getValue(value)+".png";
        } else{

        }

        return fileName;
    }

    public static void main(String[] args) throws Exception {
        getFileName(36);
    }
}
