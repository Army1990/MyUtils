package com.shanpiao.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Hornen on 15/11/19.
 */
public class MD5Utilss {

    /**
     * string hash
     * @param src source string need to be hash
     * @return string or null
     */
    public static String md5(String src) {

        if(null == src || src.length() == 0) {
            return null;
        }

        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(src.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }

        return hex.toString();
    }
}
