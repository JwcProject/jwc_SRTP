package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.UserDao;
import edu.cqu.no1.domain.User;
import edu.cqu.no1.exception.ExistMultiUserException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/26.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public User findByUsername(String username) throws ExistMultiUserException {
        String hql = "select en from " +
                User.class.getSimpleName() +
                " en where en.username=:username";
        List<User> list = getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .setParameter("username", username)
                .list();
        if (list.size() > 1) {
            throw new ExistMultiUserException(username);
        }
        return list.size() == 0 ? null : list.get(0);
    }
}
