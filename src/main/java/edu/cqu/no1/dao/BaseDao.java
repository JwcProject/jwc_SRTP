package edu.cqu.no1.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */


public interface BaseDao<T>
{
    SessionFactory getSessionFactory();

    // 保存实体
    Serializable save(T entity);
    // 更新实体
    void update(T entity);
    // 根据实例删除
    void delete(T entity);
    // 根据ID删除
    void delete(Serializable id);
    // 获取所有实体
    List<T> findAll();

    boolean removeALLDeleted();

    T findById(String id);

    List findByExample(T instance);

    List findByProperty(String propertyName, Object value);

    T merge(T detachedInstance);

    void attachDirty(T instance);

    void attachClean(T instance);
}
