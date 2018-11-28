package com.tpietri.day4;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {
    private MessageDigest messageDigest;
    public Solution() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance("MD5");
    }

    public int findLowestValidDecimal5Zeros(String key) {
        this.messageDigest.update(key.getBytes());
        byte[] md5 = this.messageDigest.digest();
        int i=1;
        while(true) {
            String input = key + i;
            String hash = DatatypeConverter.printHexBinary(this.messageDigest.digest(input.getBytes()));
            boolean hasFiveLeadingZero = true;
            for(int j=0 ; j<5 && hasFiveLeadingZero ; j++) {
                if(hash.charAt(j) != '0') {
                    hasFiveLeadingZero = false;
                }
            }
            if(hasFiveLeadingZero) {
                return i;
            }
            i++;
        }
    }

    public int findLowestValidDecimal6Zeros(String key) {
        this.messageDigest.update(key.getBytes());
        byte[] md5 = this.messageDigest.digest();
        int i=1;
        while(true) {
            String input = key + i;
            String hash = DatatypeConverter.printHexBinary(this.messageDigest.digest(input.getBytes()));
            boolean hasFiveLeadingZero = true;
            for(int j=0 ; j<6 && hasFiveLeadingZero ; j++) {
                if(hash.charAt(j) != '0') {
                    hasFiveLeadingZero = false;
                }
            }
            if(hasFiveLeadingZero) {
                return i;
            }
            i++;
        }
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "yzbqklnj";
        int output5Zeros = new Solution().findLowestValidDecimal5Zeros(input);
        System.out.println(output5Zeros);

        int output6Zeros = new Solution().findLowestValidDecimal6Zeros(input);
        System.out.println(output6Zeros);
    }
}
