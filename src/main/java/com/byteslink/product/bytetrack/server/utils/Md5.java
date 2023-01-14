package com.byteslink.product.bytetrack.server.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public Md5() {
    }

    public static String MD5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest(s.getBytes("UTF-8"));
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for(int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return new String(str);
        } catch (Exception var10) {
            return null;
        }
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static byte[] md5Digest(byte[] src) {
        MessageDigest alg = null;

        try {
            alg = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
        }

        return alg.digest(src);
    }

    public static String md5Digest(String src) {
        try {
            return byteArrayToHexString(md5Digest(src.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            String desStr = "李黎MengXiangTongXing2014";
            String desStr_after = md5Digest(desStr);
            System.out.println("111111加密后：desStr_after:" + desStr_after + " length:" + desStr_after.length());
            if (desStr_after.equalsIgnoreCase("96e79218965eb72c92a549dd5a330112")) {
                System.out.println("一致");
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
