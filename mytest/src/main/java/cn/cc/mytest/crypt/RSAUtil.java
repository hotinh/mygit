package cn.cc.mytest.crypt;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加密工具
 */
public class RSAUtil {

    public static final String PUBLIC_KEY = "RSA_Public_Key";
    public static final String PRIVATE_KEY = "RSA_Private_Key";

    /**
     * 初始化密钥
     * @return
     * @throws Exception
     */
    public static Map<String,Object> initKey() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);//512-65536 & 64的倍数
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String,Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static RSAPublicKey getPublicKey(Map<String,Object> keyMap) {
        return (RSAPublicKey) keyMap.get(PUBLIC_KEY);
    }

    public static RSAPrivateKey getPrivateKey(Map<String,Object> keyMap){
        return (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
    }

    /**
     * 使用公钥对数据进行加密
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, RSAPublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用私钥解密
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, RSAPrivateKey privateKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        String data = "周杰伦-东风破";
        Map<String, Object> keyMap = initKey();

        byte[] miwen = encrypt(data.getBytes(),getPublicKey(keyMap));
        System.out.println("加密后的内容："+BytesToHex.fromBytesToHex(miwen));

        byte[] plain = decrypt(miwen, getPrivateKey(keyMap));
        System.out.println("解密后的内容："+new String(plain));

    }
}
