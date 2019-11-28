package cn.zjh.service;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
@Service
public interface PermissionService extends BaseService<Permission> {

    /**
     * 根据权限id查询其所关联的角色数据
     *
     * @param id
     * @return
     */
    List<Role> findRoleByPermissionId(Long id);

    /**
     * 删除此权限关联的所有角色id
     *
     * @param id
     */
    void deleteAllPermissionsRoles(Long id);

    /**
     * 更新此角色的权限依赖关系
     *
     * @param permissionId
     * @param roleId
     */
    void correlationRoles(Long permissionId, Long roleId);
}
