package com.zy.blog.util;

import java.security.MessageDigest;
import java.util.Random;

public class MD5Utils {

    private static String hex(byte[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            stringBuffer.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return stringBuffer.toString();
    }

    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return hex(digest);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }

    public static String getSaltMD5(String password,Integer salt) {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(salt).append(salt);
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String saltString = sBuilder.toString();
        password = md5Hex(password + saltString);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = saltString.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }


    private static boolean getSaltverifyMD5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }

}
