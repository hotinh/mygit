package myshiro.chapter11.main.service;

import myshiro.chapter11.main.entity.Permission;

public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
