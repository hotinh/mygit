package myshiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroTest.class);

	public static void main(String[] args) {
		// Using the IniSecurityManagerFactory, which will user the an INI file
		// as the security file.
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:auth.ini");
		
		// Setting up the SecurityManager...
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject user = SecurityUtils.getSubject();
		logger.info("User is authenticated: " + user.isAuthenticated());
		
		UsernamePasswordToken token = new UsernamePasswordToken("bj","123");
		user.login(token);
		logger.info("User is authenticated: " + user.isAuthenticated());
		
	}

}
