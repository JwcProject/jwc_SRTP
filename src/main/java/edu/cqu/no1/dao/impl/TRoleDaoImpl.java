package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TRoleDao;
import edu.cqu.no1.domain.TRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zl on 2015/7/4.
 */
@Repository
@Transactional
public class TRoleDaoImpl extends BaseDaoImpl<TRole> implements TRoleDao {
    public TRole getRoleByName(String name) {
        List<TRole> list=findByProperty(TRole.class, "name", name);
        return list.size()==0?null:list.get(0);
    }
}
