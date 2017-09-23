package cn.cc.mytest.mymail;

import java.util.*;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class MyHtmlMail {

	public static void main(String[] args) throws Exception{
		List<String> receivers = new ArrayList<String>();
	    receivers.add("1012891486@qq.com");
	    
	    
	    HtmlEmail email = new HtmlEmail();
	    
	    // 这里是SMTP发送服务器的名字：，163的如下：
//	    email.setHostName(Configuration.MAIL_SENDER_SMTP_HOST);
	    email.setHostName("smtp.163.com");
	    
	    // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
//	    email.setAuthentication(Configuration.MAIL_SENDER_USERNAME, Configuration.MAIL_SENDER_PASSWORD);
	    email.setAuthentication("chen-sir441@163.com", "dahuatech34049");
	    
	    // 字符编码集的设置
	    email.setCharset("UTF-8");
	    
	    // 收件人的邮箱
	    email.addTo("1012891486@qq.com");
//	    email.addTo(receivers.stream().toArray(String[]::new));
	    
	    // 发送人的邮箱
	    email.setFrom("chen-sir441@163.com");
	    
	    // 邮件标题
	    email.setSubject("helloWord");
	    
	    // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
	    email.setMsg("helloWordContent<br>sfds");
//	    email.setHtmlMsg("helloWordContent<br>sfds");
	    
	    // 发送
	    email.send();
	    
	    
	}
}



