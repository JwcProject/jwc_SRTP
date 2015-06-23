package edu.cqu.no1.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */


@Transactional
public interface BaseDao<T>
{

    SessionFactory getSessionFactory();

    // 根据ID加载实体
    T get(Class<T> entityClazz , Serializable id);
    // 保存实体
    Serializable save(T entity);
    // 更新实体
    void update(T entity);
    // 删除实体
    void delete(T entity);
    // 根据ID删除实体
    void delete(Class<T> entityClazz , Serializable id);
    // 获取所有实体
    List<T> findAll(Class<T> entityClazz);
    // 获取实体总数
    long findCount(Class<T> entityClazz);


    boolean removeALLDeleted();


    T findById(String id);

    List findByExample(T instance);

    List findByProperty(String propertyName, Object value);

    T merge(T detachedInstance);

    void attachDirty(T instance);

    void attachClean(T instance);
}
