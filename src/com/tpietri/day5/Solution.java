package com.tpietri.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<String> badStrings;
    public Solution() {
        this.badStrings = new ArrayList();
        this.badStrings.add("ab");
        this.badStrings.add("cd");
        this.badStrings.add("pq");
        this.badStrings.add("xy");
    }

    public boolean isStringNice(String input) {
        int vowelsCount = 0;
        boolean twiceInARow = false;
        boolean doesNotContainBadStrings = true;
        Character lastChar = null;
        for(int i=0 ; i<input.length() && doesNotContainBadStrings ; i++) {
            Character c = input.charAt(i);
            // Count the number of vowels
            if(c.equals('a')  || c.equals('e') || c.equals('i') || c.equals('o') || c.equals('u')) {
                vowelsCount++;
            }

            //Find if one char appear twice in a row
            if(c.equals(lastChar)) {
                twiceInARow = true;
            }

            if(lastChar != null) {
                String currentPair = lastChar.toString() + c.toString();
                if(this.badStrings.contains(currentPair)) {
                    doesNotContainBadStrings = false;
                }
            }

            lastChar = c;
        }
        return ((vowelsCount>=3) && twiceInARow && doesNotContainBadStrings);
    }

    public boolean isStringNice2(String input) {
        boolean oneRepeat = false;

        for(int i=0 ; i<input.length() - 2 && !oneRepeat ; i++) {
            oneRepeat = (input.charAt(i) == input.charAt(i+2));
        }
        if(!oneRepeat) {
            return false;
        }
        boolean onePair = false;
        for(int i=0 ; i<input.length()-3 && !onePair; i++) {
            String iPair = input.substring(i,i+2);
            for(int j=i+2 ; j<input.length()-1 && !onePair; j++) {
                String jPair = input.substring(j,j+2);
                onePair = iPair.equals(jPair);
            }
        }
        return onePair;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/com/tpietri/day5/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String currentLine = "";
        int nbOfNiceString1 = 0;
        int nbOfNiceString2 = 0;

        //Reading all the lines
        Solution solution = new Solution();
        while((currentLine = bufferedReader.readLine()) != null) {
            if(solution.isStringNice(currentLine)) {
               nbOfNiceString1++;
            }
            if(solution.isStringNice2(currentLine)) {
                nbOfNiceString2++;
            }
        }

        System.out.println(nbOfNiceString1);
        System.out.println(nbOfNiceString2);
    }
}
