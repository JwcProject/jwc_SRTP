package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.UnitStatisticDAO;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class UnitStatisticDAOImpl extends BaseDaoImpl implements UnitStatisticDAO {
    //获取学院项目成绩分布统计

    public List unitProjectScore(String unitId, String jqId) {
        String hql = "select new Map(projectScore, count(projectId)) from TProject where" +
                " TUnit.unitId = :unitId and TJieqi.jqId = :jqId and projectScore is not null" +
                " group by projectScore order by projectScore";
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString("unitId", unitId);
        query.setString("jqId", jqId);
        List result = query.list();

        if (null != result && result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }


    public List<TResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean) {
        try {
            String hql = "select d.TJieqi.jqId, d.TUnit.unitId, u.unitName, jq.jqYear || '年 第' || jq.qici || '期', count(d)," +
                    " count(pro), count(best), count(bad), count(ed)" +
                    " from TDeclaration d, TEndProject ed, TProject pro, TProject best, TProject bad" +
                    " join d.TUnit u join d.TJieqi jq" +
                    " where pro.TJieqi = d.TJieqi and pro.TUnit = d.TUnit" +
                    " and best.TJieqi = d.TJieqi and best.TUnit = d.TUnit" +
                    " and bad.TJieqi = d.TJieqi and bad.TUnit = d.TUnit" +
                    " and d.isdeleted = 'N' and best.projectScore = '优秀' and bad.projectScore = '不及格'" +
                    " and ed.TJieqi = d.TJieqi and ed.TUnit = d.TUnit and d.TUnit.unitId = :unitId" +
                    " group by d.TJieqi";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("unitId", unitId);
            if (pageBean != null) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            List<TResultDistribut> result = query.list();
            if (null != result && result.size() > 0) {
                return result;
            } else return null;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int getUnitResultDistributCount(String unitId) {
        try {
            String hql = "select count(*) from TDeclaration where isdeleted = 'N' and TUnit.unitId = :unitId" +
                    " group by TJieqi";
            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("unitId", unitId);
            List list = query.list();
            int count = 0;
            if (null != list && list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            return count;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
