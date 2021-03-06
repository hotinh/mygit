package cn.cc.mytest.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MessageDigestUtil {

  /**
   * 计算MD5值
   */
  public static String encryptMD5(byte[] data) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");//MD5,MD2
    messageDigest.update(data);
    return BytesToHex.fromBytesToHex(messageDigest.digest());
  }

  /**
   * 计算文件的MD5值（指纹签名）
   */
  public static String getFileMD5(String path) throws Exception {
    FileInputStream fis = new FileInputStream(new File(path));
    DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));
    try {
      byte[] buffer = new byte[1024];
      int read = dis.read(buffer, 0, 1024);
      while (read != -1) {
        read = dis.read(buffer, 0, 1024);
      }
      MessageDigest md = dis.getMessageDigest();
      return BytesToHex.fromBytesToHex(md.digest());
    } finally {
      dis.close();
      fis.close();
    }

  }

  /**
   * 计算SHA值
   */
  public static String encryptSHA(byte[] data) throws Exception {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA");//SHA,SHA1,SHA-1,SHA-256,SHA-384,SHA-512
    messageDigest.update(data);
    return BytesToHex.fromBytesToHex(messageDigest.digest());
  }

  /**
   * 初始化HMAC密钥
   */
  public static byte[] initHmacKey() throws Exception {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");//HmacMD5,HmacSHA1,HmacSHA256,HmacSHA384,HmacSHA512
    return keyGenerator.generateKey().getEncoded();
  }

  /**
   * 使用Hmac生成的密钥对数据进行加密
   */
  public static String encryptHmac(byte[] data, byte[] key) throws Exception {
    SecretKey secretKey = new SecretKeySpec(key, "HmacSHA512");
    Mac mac = Mac.getInstance("HmacSHA512");
    mac.init(secretKey);
    return BytesToHex.fromBytesToHex(mac.doFinal(data));
  }

  public static void main(String[] args) throws Exception {
    String data = "123456";
//    String path = "/Users/admin/Downloads/httpd-2.4.20.tar.gz";
    
    System.out.println(data + " 的MD5值： " + MessageDigestUtil.encryptMD5(data.getBytes()));
//    System.out.println(path + " 的文件MD5签名： " + MessageDigestUtil.getFileMD5(path));
    System.out.println(data + " 的SHA值： " + MessageDigestUtil.encryptSHA(data.getBytes()));

    byte[] hmacKey = initHmacKey();
    System.out.println("初始化Hmac密钥：" + BytesToHex.fromBytesToHex(hmacKey));
    System.out.println(data + " 是的Hmac加密值为： " + MessageDigestUtil.encryptHmac(data.getBytes(), hmacKey));
  }

}
