package cn.cc.mp.wb.web;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.cc.mp.wb.common.util.DateUtil;
import eu.bitwalker.useragentutils.UserAgent;

@RestController
@RequestMapping("/file")
public class FileController {
    
    @Value("${file.upload.dir}")
    private String uploadDir;

    @PostMapping("/upload/1")
    public void upload1(@RequestParam("file") MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
        if (file.isEmpty()) {
            return;
        }

        
        String contentType = file.getContentType();
        System.out.println(contentType);
        
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        
        uploadDir = uploadDir.endsWith(File.separator) ? uploadDir : uploadDir + File.separator;
        
        String suffix = filename.substring(filename.indexOf("."), filename.length());
        System.out.println(suffix);
        
        String sss = uploadDir + DateUtil.getCurrentDateTime() + suffix;
        System.out.println(sss);
        
        File saveFile = new File(sss);
        
        try {
            file.transferTo(saveFile);
        } catch (IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();  
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
    
    @GetMapping("/download/11")
    public void download11(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String filename = "E:\\www\\fdf.txt";
        
        File file = new File(filename);
        //判断文件是否存在
        if(!file.exists()) {
            return;
        }
        //判断文件类型
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
         
        //设置文件响应大小
        response.setContentLengthLong(file.length());
         
        //文件名编码，解决乱码问题
        String fileName = file.getName();
        String encodedFileName = null;
        String userAgentString = request.getHeader("User-Agent");
        String browser = UserAgent.parseUserAgentString(userAgentString).getBrowser().getGroup().getName();
        if (browser.equals("Chrome") || browser.equals("Internet Exploer") || browser.equals("Safari")) {
            encodedFileName = URLEncoder.encode(fileName,"utf-8").replaceAll("\\+", "%20");
        } else {
            encodedFileName = MimeUtility.decodeText(fileName);
        }
         
        //设置Content-Disposition响应头，一方面可以指定下载的文件名，另一方面可以引导浏览器弹出文件下载窗口
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + encodedFileName + "\"");
         
        //文件下载
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
    
    @GetMapping("/download/1")
    public void download1(HttpServletResponse response) {
        String filename = "E:\\www\\fdf.txt";
        
        File file = new File(filename);
        
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition","attachment;fileName=1");
        
        BufferedInputStream bis = null;
        
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            OutputStream os = response.getOutputStream();
            
            IOUtils.copy(bis, os);
            
            IOUtils.closeQuietly(os);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bis);
        }
    }
    
    @GetMapping("/download/2")
    public void download2(HttpServletRequest request, HttpServletResponse response) {
        String filename = "E:\\www\\fdf.txt";
        
        File file = new File(filename);
        
        ServletContext context = request.getServletContext();
        
        String mimeType = context.getMimeType(filename);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found  
            mimeType = "application/octet-stream";  
            System.out.println("context getMimeType is null");  
        }  
        System.out.println("MIME type: " + mimeType); 
        
        // set content attributes for the response  
        response.setContentType(mimeType);  
        response.setContentLength((int) file.length());  
        
        // set headers for the response  
        String headerKey = "Content-Disposition";  
        String headerValue = String.format("attachment; filename=\"%s\"",  
                file.getName());  
        response.setHeader(headerKey, headerValue);  
        
        BufferedInputStream bis = null;
        
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            OutputStream os = response.getOutputStream();
            
            IOUtils.copy(bis, os);
            
            response.flushBuffer();
            
            IOUtils.closeQuietly(os);
            
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(bis);
        }
    }
    
    @GetMapping("/download/3")
    public ResponseEntity<InputStreamResource> download3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = "E:\\www\\2222.zip";
        
        FileSystemResource file = new FileSystemResource(filename);
        
        ServletContext context = request.getServletContext();
        String mimeType = context.getMimeType(filename);
        if (mimeType == null) {
            mimeType = "application/octet-stream";  
            System.out.println("context getMimeType is null");  
        }  
        System.out.println("MIME type: " + mimeType);
        
        HttpHeaders headers = new HttpHeaders();  
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
        headers.add("Pragma", "no-cache");  
        headers.add("Expires", "0"); 
        
        return ResponseEntity  
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())  
                .contentType(MediaType.parseMediaType(mimeType))
                .body(new InputStreamResource(file.getInputStream()));  
    }
    
    @GetMapping("/download/4")
    public ResponseEntity<byte[]> download4() throws IOException {
        String filename = "E:\\www\\fdf.txt";
        
        File file = new File(filename);
        InputStream is = new FileInputStream(file);
        System.out.println(file.getName());
        
        byte[] data = null;
        data = new byte[is.available()];
        is.read(data);
        IOUtils.closeQuietly(is);
        
        HttpHeaders headers = new HttpHeaders();  
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));  
        headers.add("Pragma", "no-cache");  
        headers.add("Expires", "0"); 
        
        return ResponseEntity
                .ok()
                .headers(headers)  
                .contentLength(file.length())  
                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }
    
    @GetMapping("/download/5")
    public ResponseEntity<byte[]> download5(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String filename = "E:\\www\\fdf.txt";
        
        File file = new File(filename);
        
        ServletContext context = request.getServletContext();
        
        /*String mimeType = context.getMimeType(filename);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found  
            mimeType = "application/octet-stream";  
            System.out.println("context getMimeType is null");  
        }  
        System.out.println("MIME type: " + mimeType);*/
        
        //判断文件类型
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if(mimeType == null) {
            mimeType = "application/octet-stream";
        }
        
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", file.getName());
        headers.add("Content-Disposition", "attachment;fileName=\"" + file.getName() + "\"");
//        headers.add("", headerValue);
        
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType(mimeType))
                .body(FileUtils.readFileToByteArray(file));
    }
    
}
