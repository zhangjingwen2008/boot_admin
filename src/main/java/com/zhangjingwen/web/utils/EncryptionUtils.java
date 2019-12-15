package com.zhangjingwen.web.utils;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Hex;

public class EncryptionUtils {

    //获取十六进制字符串md5加密
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}
