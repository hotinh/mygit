package myshiro.chapter11.main.dao;

import myshiro.chapter11.main.entity.Permission;

public interface PermissionDao {
	public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
