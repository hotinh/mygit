package cn.cc.mytest.crypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class AESUtil {
	
	private static String DEFAULT_CIPER = "AES";
	
	private final static String ENCODING = "UTF-8";
	
	//Test
    public static void main(String[] args) throws Exception {
    	
    	byte[] desKey = AESUtil.initKey("反倒是");
    	
        System.out.println("DES KEY : " + BytesToHex.fromBytesToHex(desKey));
        
        String s = "佛挡杀佛";
    	
        byte[] desResult = AESUtil.encrypt(s.getBytes(), desKey);
        System.out.println(s + ">>>DES 加密结果>>>" + BytesToHex.fromBytesToHex(desResult));
        
        byte[] desPlain = AESUtil.decrypt(desResult, desKey);
        System.out.println(s + ">>>DES 解密结果>>>" + new String(desPlain));
        
        
        String ss = "佛挡杀佛";
        String s1 = encryptStr(ss, desKey);
        System.out.println(s1);
        String s2 = decryptStr(s1, desKey);
        System.out.println(s2);
    }
    
    /*
     * 生成密钥
     */
    public static byte[] initKey(String str) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(DEFAULT_CIPER);
        
        System.out.println(keyGen.getAlgorithm());
        System.out.println(keyGen.getProvider());
        
//        keyGen.init(128);
//        keyGen.init(params);
        if (str == null) {
        	keyGen.init(128);
        } else {
        	keyGen.init(128, new SecureRandom(str.getBytes()));
        }
        
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    
    /*
     * DES 加密
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, DEFAULT_CIPER);
        
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }
    
    
    /*
     * DES 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception{
        SecretKey secretKey = new SecretKeySpec(key, DEFAULT_CIPER);
        
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPER);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }

    public static String encryptStr(String content, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, DEFAULT_CIPER);
        
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] data = content.getBytes(ENCODING);
        byte[] cipherBytes = cipher.doFinal(data);
        
        return Hex.encodeHexString(cipherBytes);
    }
    
    public static String decryptStr(String content, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, DEFAULT_CIPER);
        
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPER);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] data = Hex.decodeHex(content.toCharArray());
        byte[] plainBytes = cipher.doFinal(data);
        
        return new String(plainBytes, ENCODING);
    }
}

