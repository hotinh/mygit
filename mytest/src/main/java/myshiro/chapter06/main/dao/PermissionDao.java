package myshiro.chapter06.main.dao;

import myshiro.chapter06.main.entity.Permission;

public interface PermissionDao {
	public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
