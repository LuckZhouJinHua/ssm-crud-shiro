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
public interface RoleMapper {

    void correlationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    void uncorrelationPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    boolean exists(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    Role findById(Long id);

    void create(Role role);

    void deleteUserRole(Long roleId);

    void deleteRole(Long roleId);

    List<Role> findAll();

    List<Permission> findRolePermissionByRoleId(Long id);

    List<Permission> findPermissionByRoleId(Long id);

    void update(Role role);

    void deleteAllRolePermissions(Long id);

    void updateUserRole_Id(Role role);
}
