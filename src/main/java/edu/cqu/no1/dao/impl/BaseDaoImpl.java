package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.BaseDao;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */

@Transactional
@Repository
abstract public class BaseDaoImpl<T> implements BaseDao<T> {

    // DAO组件进行持久化操作底层依赖的SessionFactory组件
    @Resource
    private SessionFactory sessionFactory;

    // 依赖注入SessionFactory所需的setter方法
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    // 保存实体
    @Override
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession()
                .save(entity);
    }

    // 更新实体
    @Override
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    // 删除实体
    @Override
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    // 根据ID删除实体
    @Override
    public void delete(Serializable id) {
        Class<T> entityClazz = getEntityClass();
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName()
                        + " en where en.id = ?")
                .setParameter("0", id)
                .executeUpdate();
    }


    // 获取所有实体
    @Override
    public List<T> findAll() {
        Class<T> entityClazz = getEntityClass();
        String hql = "from " + entityClazz.getSimpleName();

        return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).list();
    }


    //删除所有isdeleted字段为N的记录
    @Override
    public boolean removeALLDeleted() {
        try {
            Class<T> entityClazz = getEntityClass();
            String className = entityClazz.getSimpleName();
            String queryString = "delete " + className + " as model where model.isdeleted = 'Y'";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


//    // 根据HQL语句查询实体
//    @SuppressWarnings("unchecked")
//    protected List<T> find(String hql) {
//        return (List<T>) getSessionFactory().getCurrentSession()
//                .createQuery(hql)
//                .list();
//    }

//    // 根据带占位符参数HQL语句查询实体
//    @SuppressWarnings("unchecked")
//    protected List<T> find(String hql, Object... params) {
//        // 创建查询
//        Query query = getSessionFactory().getCurrentSession()
//                .createQuery(hql);
//        // 为包含占位符的HQL语句设置参数
//        for (int i = 0, len = params.length; i < len; i++) {
//            query.setParameter(i + "", params[i]);
//        }
//        return (List<T>) query.list();
//    }
//
//    /**
//     * 使用hql 语句进行分页查询操作
//     *
//     * @param hql      需要查询的hql语句
//     * @param pageNo   查询第pageNo页的记录
//     * @param pageSize 每页需要显示的记录数
//     * @return 当前页的所有记录
//     */
//    @SuppressWarnings("unchecked")
//    protected List<T> findByPage(String hql,
//                                 int pageNo, int pageSize) {
//        // 创建查询
//        return getSessionFactory().getCurrentSession()
//                .createQuery(hql)
//                        // 执行分页
//                .setFirstResult((pageNo - 1) * pageSize)
//                .setMaxResults(pageSize)
//                .list();
//    }
//
//    /**
//     * 使用hql 语句进行分页查询操作
//     *
//     * @param hql      需要查询的hql语句
//     * @param params   如果hql带占位符参数，params用于传入占位符参数
//     * @param pageNo   查询第pageNo页的记录
//     * @param pageSize 每页需要显示的记录数
//     * @return 当前页的所有记录
//     */
//    @SuppressWarnings("unchecked")
//    protected List<T> findByPage(String hql, int pageNo, int pageSize
//            , Object... params) {
//        // 创建查询
//        Query query = getSessionFactory().getCurrentSession()
//                .createQuery(hql);
//        // 为包含占位符的HQL语句设置参数
//        for (int i = 0, len = params.length; i < len; i++) {
//            query.setParameter(i + "", params[i]);
//        }
//        // 执行分页，并返回查询结果
//        return query.setFirstResult((pageNo - 1) * pageSize)
//                .setMaxResults(pageSize)
//                .list();
//    }


    @Override
    public T findById(String id) {
        try {
            Class<T> entityClass = getEntityClass();
            T instance = (T) getSessionFactory().getCurrentSession().get(entityClass, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Override
    public List<T> findByExample(T instance) {

        Session session = getSessionFactory().getCurrentSession();
        List<T> results = session.createCriteria(getClass()).add(Example.create(instance)).list();

        return results;

    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List findByProperty(String propertyName, Object value) {
        Class<T> entityClass = getEntityClass();
        String className = entityClass.getSimpleName();

        String queryString = "from " + className + " as model where model."
                + propertyName + "= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setParameter(0, value);
        return query.list();
    }

    @Override
    public T merge(T detachedInstance) {

        T result = (T) getSessionFactory().getCurrentSession().merge(detachedInstance);
        return result;
    }

    @Override
    public void attachDirty(T instance) {
        getSessionFactory().getCurrentSession().saveOrUpdate(instance);
    }

    @Override
    public void attachClean(T instance) {
        getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
    }
}
