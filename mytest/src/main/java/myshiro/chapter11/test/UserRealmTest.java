package myshiro.chapter11.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;

import myshiro.chapter11.main.realm.UserRealm;

import org.junit.*;

public class UserRealmTest extends BaseTest {

	@Override
    public void tearDown() throws Exception {
        userService.changePassword(u1.getId(), password);
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
        userRealm.clearCachedAuthenticationInfo(subject().getPrincipals());

        super.tearDown();
    }
	
	@Test
    public void testClearCachedAuthenticationInfo() {
      login("classpath:myshiro/auth-11.ini", u1.getUsername(), password);
      userService.changePassword(u1.getId(), password + "1");

      RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
      UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
      userRealm.clearCachedAuthenticationInfo(subject().getPrincipals());

      login("classpath:myshiro/auth-11.ini", u1.getUsername(), password + "1");


  }

  @Test
  public void testClearCachedAuthorizationInfo() {
      login("classpath:myshiro/auth-11.ini", u1.getUsername(), password);
      subject().checkRole(r1.getRole());
      userService.correlationRoles(u1.getId(), r2.getId());

      RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
      UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
      userRealm.clearCachedAuthorizationInfo(subject().getPrincipals());

      subject().checkRole(r2.getRole());
  }



  @Test
  public void testClearCache() {
      login("classpath:myshiro/auth-11.ini", u1.getUsername(), password);
      subject().checkRole(r1.getRole());

      userService.changePassword(u1.getId(), password + "1");
      userService.correlationRoles(u1.getId(), r2.getId());

      RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
      UserRealm userRealm = (UserRealm) securityManager.getRealms().iterator().next();
      userRealm.clearCache(subject().getPrincipals());

      login("classpath:myshiro/auth-11.ini", u1.getUsername(), password + "1");
      subject().checkRole(r2.getRole());
  }
}
