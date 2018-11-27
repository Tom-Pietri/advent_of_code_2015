package com.tpietri.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    public int getDimensionForOneBox(String input) {
        //Input with format LENGTHxWIDTHxHEIGHT
        String[] dimensions = input.split("x");
        int length = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        int height = Integer.parseInt(dimensions[2]);
        int lengthWidthSideSize = length*width;
        int widthHeightSideSize = width*height;
        int heightLengthSideSize = height*length;
        int output = 2*lengthWidthSideSize
                + 2*widthHeightSideSize
                + 2*heightLengthSideSize
                //The smallest side
                + Math.min(heightLengthSideSize, Math.min(lengthWidthSideSize, widthHeightSideSize));
        return output;
    }

    public int getDimensionOfRibon(String input) {
        //Input with format LENGTHxWIDTHxHEIGHT
        String[] dimensions = input.split("x");
        int length = Integer.parseInt(dimensions[0]);
        int width = Integer.parseInt(dimensions[1]);
        int height = Integer.parseInt(dimensions[2]);

        // Smallest distance arround it's sizes
        int ribonAroundLength = Math.min(Math.min((length+width), (length+height)),(width+height)) * 2;

        //Cubic feet volume of the present
        int presentVolume = length * width * height;



        int output = presentVolume + ribonAroundLength;
        return output;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/com/tpietri/day2/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String currentLine = "";
        int totalSquareFeet = 0;
        int totalRibon = 0;
        Solution solution = new Solution();
        //Reading all the lines
        while((currentLine = bufferedReader.readLine()) != null) {
            totalSquareFeet += solution.getDimensionForOneBox(currentLine);
            totalRibon += solution.getDimensionOfRibon(currentLine);
        }
        System.out.println(totalSquareFeet);
        System.out.println(totalRibon);
    }
}
