package cn.cc.mp.wb;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileTester {

    public static void main(String[] args) {
        
        String s = "d:\\www";
        
        s = s.endsWith(File.separator) ? s : s + File.separator;
        
        System.out.println(s);
        
        LocalDateTime dateTime = LocalDateTime.now();
        
        String dd = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHssmmSSS"));
        System.out.println(dd);
    }
}
