package com.jsbl.sara.Encrpition;

import java.security.MessageDigest;

public class Constaint {

    // Uat
    public static String mKey = getMD5("com.jsbl.genix" + "x2");





    public static String getMD5(String message) {
        String md5str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input = message.getBytes();
            byte[] buff = md.digest(input);
            md5str = bytesToHex(buff);

        } catch (Exception e) {
            //e.printStackTrace();
            // Log.e("SecurityUtil",e.toString());
        }
        return md5str;
    }


    private static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (byte aByte : bytes) {
            digital = aByte;

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toLowerCase();
    }

}
