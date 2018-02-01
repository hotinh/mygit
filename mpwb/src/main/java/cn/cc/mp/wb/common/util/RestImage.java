package cn.cc.mp.wb.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestImage {

    
    
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "http://g.hiphotos.baidu.com/image/pic/item/c8ea15ce36d3d539f09733493187e950342ab095.jpg";
        
        ResponseEntity<byte[]> r = restTemplate.getForEntity(url, byte[].class);
        
        byte[] btImg = r.getBody();
        
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start);
        
        System.out.println("读取到：" + btImg.length + " 字节");  
        String fileName = "百度.gif";
        writeImageToDisk(btImg, fileName);
        
        long end = System.currentTimeMillis();
        System.out.println(end-start);
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
}
