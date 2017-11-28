package cn.cc.text.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

	@Test
	public void testHelloWorld() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	
	@Test
	public void testCustomRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myshiro/auth-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
	}
	
	@Test
	public void testCustomMultiRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myshiro/auth-multi-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wang","123");
		try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		subject.logout();
	}
	
	@Test
	public void testJDBCRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myshiro/auth-jdbc-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		subject.logout();
	}
	
	@After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
