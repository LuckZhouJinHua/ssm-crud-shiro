package cn.zjh.mapper;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;
import cn.zjh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface UserMapper {

    void correlationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);

    void uncorrelationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);

    boolean exists(@Param("userId") Long userId, @Param("roleId") Long roleId);

    void create(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

    User findByName(String username);

    User findById(Long id);

    void deleteAllUserRoles(Long id);
}
