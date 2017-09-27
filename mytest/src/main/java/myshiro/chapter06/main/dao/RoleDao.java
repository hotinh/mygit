package myshiro.chapter06.main.dao;

import myshiro.chapter06.main.entity.Role;

public interface RoleDao {
	public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
