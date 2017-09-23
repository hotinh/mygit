package cn.cc.mytest.crypt;

import java.io.IOException;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Util {

  public static String encrypt(byte[] data) {
	  return Base64.getEncoder().encodeToString(data);
  }
  
  public static String decrypt(String data) throws IOException {
    return new String(Base64.getDecoder().decode(data),StandardCharsets.UTF_8);
  }
  
  public static void main(String[] args) throws IOException {
    String data = "1234567890";
    
    String result = Base64Util.encrypt(data.getBytes());
    System.out.println(data +" 使用Base64编码的结果： "+result);
    
    String result2 = Base64Util.decrypt(result);
    System.out.println(result + "使用Base64解码的结果：" +result2);
    
  }
}

