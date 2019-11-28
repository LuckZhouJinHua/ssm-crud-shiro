package cn.zjh.dao;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface PermissionDao {

    void create(Permission permission);

    void delete(Long id);

    List<Permission> findAll();

    void update(Permission permission);

    Permission findById(Long id);

    List<Role> findRoleByPermissionId(Long id);

    void deleteAllPermissionsRoles(Long id);

    void correlationRoles(Long permissionId, Long roleId);
}
