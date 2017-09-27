package myshiro.chapter06.main.service;

import myshiro.chapter06.main.dao.PermissionDao;
import myshiro.chapter06.main.dao.PermissionDaoImpl;
import myshiro.chapter06.main.entity.Permission;

/**
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}

