package cn.zjh.service;

import java.util.List;

/**
 * @author Casual developer
 * @version 1.0
 * @date 2019/11/27
 */
public interface BaseService<T> {

    /**
     * 根据ID查询其所有数据
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 创建用户
     *
     * @param t
     */
    void create(T t);

    /**
     * 根据用户ID删除用户信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新用户信息
     *
     * @param t
     */
    void update(T t);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

}
