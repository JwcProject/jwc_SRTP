package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.TAuthorityDao;
import edu.cqu.no1.domain.TAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zl on 2015/7/4.
 */
@Repository
@Transactional
public class TAuthorityDaoImpl extends BaseDaoImpl<TAuthority> implements TAuthorityDao {
}
