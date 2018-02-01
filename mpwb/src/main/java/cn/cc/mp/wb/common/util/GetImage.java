package cn.cc.mp.wb.common.util;

import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.net.HttpURLConnection;  
import java.net.URL;  

public class GetImage {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        String url = "http://g.hiphotos.baidu.com/image/pic/item/c8ea15ce36d3d539f09733493187e950342ab095.jpg";  
        byte[] btImg = getImageFromNetByUrl(url);
        
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start);
        
        if (null != btImg && btImg.length > 0) {
            System.out.println("读取到：" + btImg.length + " 字节");  
            String fileName = "百度.gif";  
            writeImageToDisk(btImg, fileName);  
        } else {  
            System.out.println("没有从该连接获得内容");  
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
    public static byte[] getImageFromNetByUrl(String strUrl) {
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
            return btImg;  
        } catch (Exception e) {
            e.printStackTrace();  
        }
        return null;  
    }
    
    public static void writeImageToDisk(byte[] img, String fileName) {
        try {
            File file = new File("e:\\" + fileName);  
            FileOutputStream fops = new FileOutputStream(file);  
            fops.write(img);  
            fops.flush();  
            fops.close();
            System.out.println("图片已经写入到C盘");  
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
    
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len=inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);  
        }
        inStream.close();  
        return outStream.toByteArray();  
    }
}
