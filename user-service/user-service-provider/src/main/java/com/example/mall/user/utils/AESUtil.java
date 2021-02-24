package com.example.mall.user.utils;

import lombok.Setter;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author dingrui
 * @date 2021-02-22
 * @description 加密
 */
public class AESUtil {
    /**
     * 加密或解密内容
     */
    @Setter
    private String content;

    /**
     * 加密密钥
     */
    private String secret;

    public AESUtil(String content) {
        this.content = content;
        this.secret = "iwofnoadnsa922342mnjaolkdsao9423242niosadopa_a02402sad";
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @return 加密后内容
     * @description 加密
     */
    public String encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        Key key = getKey();
        byte[] result = null;
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 加密
        result = cipher.doFinal(content.getBytes("UTF-8"));
        // 将二进制转换成16进制
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            String hex = Integer.toHexString(result[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @return 解密后内容
     * @description 解密
     */
    public String decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //将16进制转为二进制
        if (content.length() < 1) {
            return null;
        }
        byte[] result = new byte[content.length() / 2];
        for (int i = 0; i < content.length() / 2; i++) {
            int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }

        Key key = getKey();
        byte[] decrypt = null;
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //解密
        decrypt = cipher.doFinal(result);
        assert decrypt != null;
        return new String(decrypt);
    }

    /**
     * @author dingrui
     * @date 2021/2/22
     * @return
     * @description 根据私钥内容获得私钥
     */
    private Key getKey() throws NoSuchAlgorithmException {
        SecretKey key = null;
        // 创建密钥生成器
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        // 初始化密钥
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(secret.getBytes());
        generator.init(128, random);
        // 生成密钥
        key = generator.generateKey();
        return key;
    }
}
