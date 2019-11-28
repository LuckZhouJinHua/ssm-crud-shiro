package cn.zjh.dao;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface RoleDao {

    void correlationPermissions(Long roleId, Long[] permissionIds);

    void uncorrelationPermissions(Long roleId, Long[] permissionIds);

    Role findById(Long id);
    
    void create(Role role);

    void delete(Long id);

    List<Role> findAll();

    List<Permission> findRolePermissionByRoleId(Long id);

    List<Permission> findPermissionByRoleId(Long id);

    void update(Role role);

    void deleteAllRolePermissions(Long id);

    void updateUserRole_Id(Role role);
}
