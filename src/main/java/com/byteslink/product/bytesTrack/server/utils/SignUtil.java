package com.byteslink.product.bytesTrack.server.utils;

/**
 * @author Cain
 * @date 2020/8/6 11:46
 * @description
 */
public class SignUtil {
    public static String buildTradeSign(String body, String secureKey, String nonce, String timestamp) {
        return Md5.md5Digest(body + secureKey + nonce + timestamp).toLowerCase();
    }
}