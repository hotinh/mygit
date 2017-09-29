package myshiro.chapter11.main.service;

import myshiro.chapter11.main.entity.Role;

public interface RoleService {
	public Role createRole(Role role);
	public void deleteRole(Long roleId);
	public void correlationPermissions(Long roleId, Long... permissionId);
	public void uncorrelationPermissions(Long roleId, Long... permissionId);
}
