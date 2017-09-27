package myshiro.chapter06.main.service;

import myshiro.chapter06.main.entity.Permission;

public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
