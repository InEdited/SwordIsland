package dev.InEdited.swordIsland.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Utils {

    //this method takes a path of a file and returns it as a string
    public static String loadFileAsString(String path){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while((line =bufferedReader.readLine())!=null){
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static int parseInt(String number){
        return Integer.parseInt(number);
    }

    //a function that returns a random integer number between two given values (including them)

    public static int randInt(int min,int max){
        Random rand = new Random();

        int randumNum = rand.nextInt((max - min) + 1) + min;
        return randumNum;
    }
}
