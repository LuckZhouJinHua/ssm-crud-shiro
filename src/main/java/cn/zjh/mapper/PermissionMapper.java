package cn.zjh.mapper;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface PermissionMapper {
    
    void create(Permission permission);

    void deleteRolePermission(Long permissionId);

    void deletePermission(Long permissionId);

    List<Permission> findAll();

    void update(Permission permission);

    Permission findById(Long id);

    List<Role> findRoleByPermissionId(Long id);

    void deleteAllPermissionsRoles(Long id);

    void correlationRoles(@Param("permissionId") Long permissionId, @Param("roleId") Long roleId);
}
