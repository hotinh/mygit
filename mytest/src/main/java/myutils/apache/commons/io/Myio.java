package myutils.apache.commons.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.*;

public class Myio {

    public static void main(String[] args) throws IOException {
//        fd();
//        fd2();
//        fd3();
//        fd4();
//        fd5();
        fd6();
    }
    
    public static void fd6() throws IOException {
        File file = new File("E:\\www\\fdf.txt");
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try {
            while(it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }
    
    public static void fd5() throws IOException {
        long freeSpace = FileSystemUtils.freeSpace("C:/");
        System.out.println(freeSpace);
    }
    
    public static void fd4() {
        String filename = "E:\\www\\";
        String normalized = FilenameUtils.normalize(filename);
        System.out.println(normalized);
    }
    
    public static void fd3() throws IOException {
        File file = new File("E:\\www\\fdf.txt");
        List<String> lines = FileUtils.readLines(file, Charset.defaultCharset());
        lines.forEach(System.out :: println);
    }
    
    public static void fd2() throws IOException {
        InputStream in = new URL("http://commons.apache.org").openStream();
        try {
            System.out.println(IOUtils.toString(in));
        } finally {
          IOUtils.closeQuietly(in);  
        }
    }
    
    public static void fd() throws IOException {
        InputStream in  
            = new URL("http://commons.apache.org").openStream();
//            = new File("");
        try {
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            in.close();
        }
    }
    
}
