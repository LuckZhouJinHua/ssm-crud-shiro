package cn.zjh.dao;

import cn.zjh.entity.Permission;
import cn.zjh.entity.Role;
import cn.zjh.entity.User;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface UserDao {

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);

    void create(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

    User findByName(String username);

    User findById(Long id);

    void deleteAllUserRoles(Long id);
}
