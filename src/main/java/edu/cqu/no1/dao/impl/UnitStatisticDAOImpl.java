package edu.cqu.no1.dao.impl;

import com.sun.istack.internal.Nullable;
import edu.cqu.no1.dao.UnitStatisticDAO;
import edu.cqu.no1.domain.ResultDistribut;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class UnitStatisticDAOImpl extends BaseDaoImpl implements UnitStatisticDAO {


    //获取学院项目成绩分布统计
    @Nullable
    public List<Map> unitProjectScore(String unitId, String jqId) {
        String hql = "select new Map(projectScore, projectScore) from TProject" +
                " where unitId = :unitId and jqId = :jqId and projectScore is not null" +
                " group by projectScore order by projectScore";

        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString("unitId", unitId);
        query.setString("jqId", jqId);
        @SuppressWarnings("unchecked")
        List<Map> result = query.list();

        if (null != result && result.size() > 0) {
            return result;
        } else {
            return null;
        }

    }

    @Nullable
    public List<ResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean) {
        try {
            String hql = "select d.jqId, d.college, u.unitName," +
                    " concat(j.jqYear, '年 第', j.qici, '期') as jqname, count(d) as decsum," +
                    " count(p1) as prosum, count(p2) as bestsum, count(p3) as badsum, count(ep) as endsum" +
                    " from TDeclaration d, TUnit u, TJieqi j, TProject  p1, TProject p2, TProject p3, TEndProject ep" +
                    " where d.isdeleted = 'N'" +
                    " and u.unitId = d.college" +
                    " and j.jqId = d.jqId" +
                    " and p1.jqId = d.jqId and p1.unitId = d.college" +
                    " and p2.jqId = d.jqId and p2.unitId = d.college and p2.projectScore = '优秀'" +
                    " and p3.jqId = d.jqId and p3.unitId = d.college and p3.projectScore = '不及格'" +
                    " and ep.jqId = d.jqId and ep.unitId = d.college" +
                    " and d.college = :unitId group by d.jqId";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);
            query.setString("unitId", unitId);

            if (pageBean != null) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }

            List<Object[]> middleResult = query.list();
            List<ResultDistribut> result = new ArrayList<ResultDistribut>();
            for (int i = 0; i < middleResult.size(); ++i) {
                Object[] objs = middleResult.get(i);
                int decsum = (Integer)objs[4];
                int prosum = (Integer)objs[5];
                int bestsum = (Integer)objs[6];
                int badsum = (Integer)objs[7];
                int endsum = (Integer)objs[8];
                double prorate = Math.round(prosum * 1.0 / decsum * 1000) / 1000;
                double bestrate = Math.round(bestsum * 1.0 / prosum * 1000) / 1000;
                double endrate = Math.round(endsum * 1.0 / prosum * 1000) / 1000;
                double delayrate = Math.round((prosum - endsum) * 1.0 / prosum * 1000) / 1000;

                ResultDistribut resultDistribut = new ResultDistribut();
                resultDistribut.setId(String.valueOf(i));
                resultDistribut.setJqId((String)objs[0]);
                resultDistribut.setCollege((String)objs[1]);
                resultDistribut.setCollegename((String)objs[2]);
                resultDistribut.setJqname((String)objs[3]);
                resultDistribut.setDecsum(decsum * 1.0);
                resultDistribut.setProsum(prosum * 1.0);
                resultDistribut.setBestsum(bestsum * 1.0);
                resultDistribut.setBadsum(badsum * 1.0);
                resultDistribut.setEndsum(endsum * 1.0);
                resultDistribut.setProrate(prorate);
                resultDistribut.setBestrate(bestrate);
                resultDistribut.setEndrate(endrate);
                resultDistribut.setDelayrate(delayrate);

                result.add(resultDistribut);
            }

            if (null != result && result.size() > 0) {
                return result;
            } else {
                return null;
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int getUnitResultDistributCount(String unitId) {
        try {
            String hql = "select count(*) from TDeclaration where isdeleted = 'N' and college = :unitId group by jqId";

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
            // TODO: handle exception
        }
    }


}
