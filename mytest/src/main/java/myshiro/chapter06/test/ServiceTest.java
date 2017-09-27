package myshiro.chapter06.test;

import org.junit.Assert;
import org.junit.Test;

import myshiro.chapter06.main.entity.Permission;
import myshiro.chapter06.main.entity.Role;
import myshiro.chapter06.main.entity.User;

import java.util.Set;

public class ServiceTest extends BaseTest {

	@Test
	public void testUserRolePermissionRelation() {
		
		//zhang
		u1 = new User("zhang", password);
		r1 = new Role("admin", "管理员", Boolean.TRUE);
        Set<String> roles = userService.findRoles(u1.getUsername());
        Assert.assertEquals(1, roles.size());
        Assert.assertTrue(roles.contains(r1.getRole()));
        
        p3 = new Permission("menu:create", "菜单模块新增", Boolean.TRUE);
        Set<String> permissions = userService.findPermissions(u1.getUsername());
        Assert.assertEquals(3, permissions.size());
        Assert.assertTrue(permissions.contains(p3.getPermission()));

        //li
        u2 = new User("li", password);
        roles = userService.findRoles(u2.getUsername());
        Assert.assertEquals(0, roles.size());
        permissions = userService.findPermissions(u2.getUsername());
        Assert.assertEquals(0, permissions.size());


        //解除 admin-menu:update关联
//        roleService.uncorrelationPermissions(r1.getId(), p3.getId());
//        permissions = userService.findPermissions(u1.getUsername());
//        Assert.assertEquals(2, permissions.size());
//        Assert.assertFalse(permissions.contains(p3.getPermission()));


        //删除一个permission
//        permissionService.deletePermission(p2.getId());
//        permissions = userService.findPermissions(u1.getUsername());
//        Assert.assertEquals(1, permissions.size());

        //解除 zhang-admin关联
//        userService.uncorrelationRoles(u1.getId(), r1.getId());
//        roles = userService.findRoles(u1.getUsername());
//        Assert.assertEquals(0, roles.size());
	}
	
}
