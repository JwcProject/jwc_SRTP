package edu.cqu.no1.dao;

import edu.cqu.no1.domain.User;
import edu.cqu.no1.exception.ExistMultiUserException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZKQ on 2015/5/26.
 */
@Transactional
public interface UserDao extends BaseDao<User>{
    User findByUsername(String username)throws ExistMultiUserException;
}
