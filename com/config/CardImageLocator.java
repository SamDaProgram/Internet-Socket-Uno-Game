package com.config;

import java.io.File;
public class CardImageLocator {

    private static final String DIRECTORY = "com/assets/cards/";
    private static String fileName;
    private static int i = 0;
    public static String getFileName(int value) throws Exception {
        if (value <= 790) {
            fileName = CardData.getColor(value) + "_" + CardData.getValue(value) + ".png";

        }
            File f = new File(DIRECTORY+fileName);
            if (f.exists() && !f.isDirectory()) {
              //  System.out.println(Presets.LOGPRESET+"File Directory for card ID "+i+": "+DIRECTORY+fileName+"\""); //remove comment to enable
                return DIRECTORY+fileName;
            } else {
                System.out.println(Presets.ERRORPRESET+"Unable to locate asset \""+ DIRECTORY+fileName+"\" with identifier "+ i);
                return null;
            }

    }
    public static void main(String[] args) throws Exception {
        for (i= 0; i < 111; i++) {
           getFileName(i);
        }

    }

}
