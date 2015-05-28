package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sun.istack.internal.Nullable;
import edu.cqu.no1.dao.StatisticDAO;
import edu.cqu.no1.domain.ResultDistribut;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class StatisticDAOImpl extends BaseDaoImpl implements StatisticDAO {
    private static final Logger log = LoggerFactory.getLogger(StatisticDAOImpl.class);

    // 全校项目成绩分布统计
    @Nullable
    public List SchooleProjectScore(String jqQici)
    {
        log.debug("全校项目成绩分布统计");
        try
        {
            if(null != jqQici && !"".equals(jqQici.trim()))
            {
                String hql = "select distinct t.projectScore, count(t.projectScore)" +
                        "  from TProject t where t.projectScore is not null and t.jqId = :jqQici" +
                        " group by t.projectScore order by t.projectScore";

                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString("jqQici", jqQici);
                List result = query.list();

                if(null != result && result.size() > 0)
                {
                    return result;
                }
                else
                {
                    log.debug("全校项目成绩分布统计list is null");
                    return null;
                }
            }
            else
            {
                log.error("全校项目成绩分布统计-参数 is null");
                return null;
            }

        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            throw e;
        }
    }

    // 全校数据指标 数据条数
    public int getSchoolResultDistributCount(String college, String jqYear, String jqQici)
    {
        log.debug("全校项目成绩分布数据指标，数据条目");
        try
        {
            String hql = "select count(*) from TDeclaration d where isdeleted = 'N'";

            if(null != college && !"".equals(college.trim()))
            {
                hql += " and college in (select unitId from TUnit where unitName like :college)";

            }

            if(null != jqQici && !"".equals(jqQici.trim()))
            {
                hql += "  and jqId = :jqQici";

            }
            else if(null != jqYear && !"".equals(jqYear.trim()))
            {
                hql += " and jqId in (select jqId from TJieqi where jqYear = :jqYear";

            }

            hql += "  group by jqId, college";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            if(null != college && !"".equals(college.trim()))
            {
                query.setString("college", "%"+college+"%");

            }
            if(null != jqQici && !"".equals(jqQici.trim()))
            {
                query.setString("jqQici", jqQici);
            }
            else if(null != jqYear && !"".equals(jqYear.trim()))
            {
                query.setString("jqYear", jqYear);
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            throw e;
        }
    }

    // 全校数据指标 List
    @Nullable
    public List<ResultDistribut> getSchoolResultDistribut(String college, String jqYear, String jqQici, PageBean pageBean)
    {
        log.debug("全校数据指标");
        try
        {
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
                    " and ep.jqId = d.jqId and ep.unitId = d.college";

            if(null != college && !"".equals(college.trim()))
            {
                hql += " and d.college in (select unitId from TUnit where unitName like :college)";
            }

            if(null != jqQici && !"".equals(jqQici.trim()))
            {
                hql += " and d.jqId = :jqQici";
            }
            else if(null != jqYear && !"".equals(jqYear.trim()))
            {
                hql += " and d.jqId in (select jqId from TJieqi where jqYear = :jqYear)";
            }

            hql += " group by d.jqId, d.college";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            if(null != college && !"".equals(college.trim()))
            {
                query.setString("college", "%"+college+"%");

            }
            if(null != jqQici && !"".equals(jqQici.trim()))
            {
                query.setString("jqQici", jqQici);
            }
            else if(null != jqYear && !"".equals(jqYear.trim()))
            {
                query.setString("jqYear", jqYear);
            }

            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }
            @SuppressWarnings("unchecked")
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

            if(result.size() > 0)
            {
                return result;
            }
            else
            {
                log.debug("全校数据指标list is null");
                return null;
            }

        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            e.printStackTrace();
            throw e;
        }
    }

    // 按期次查看各学院数据
    @Nullable
    public List<ResultDistribut> getSchoolStatisticsData(String jqQici)
    {
        log.debug("按期次查看各学院统计数据，参数-期次");
        return getSchoolResultDistribut(null, null, jqQici, null);
    }

    // 按学院查看各期次统计数据
    @Nullable
    public List<ResultDistribut> getSchoolStatisticDataByCollege(String college)
    {
        log.debug("按学院查看各期次统计数据,参数-学院");
       return getSchoolResultDistribut(college, null, null, null);
    }


    // 根据学院名称参数，判断参数是否合法
    public int getCollegeCountByName(String college)
    {
        log.debug("根据学院名称参数，查询学院取值，判断参数是否合法");
        try
        {
            int count = 0;
            if(null != college && !"".equals(college.trim()))
            {
                String sql = "select count(1) from t_unit u where u.unit_name like :college";

                Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
                query.setString("college", "%"+college+"%");

                List tmpList = query.list();

                if(null != tmpList && tmpList.size() >0)
                {
                    count = Integer.parseInt(tmpList.get(0).toString());
                }
            }
            else
            {
                log.debug("学院名称参数- null");
            }

            return count;
        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            e.printStackTrace();
            throw e;
        }
    }

    // 根据届期id获取当前届期信息
    @Nullable
    public TJieqi getJieqiById(String id)
    {
        log.debug("根据届期id获取当前届期信息");
        try
        {
            if(null != id && !"".equals(id.trim()))
            {
                String hql = "from TJieqi where jqId = :id";
                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString("id", id);

                @SuppressWarnings("unchecked")
                List<TJieqi> tmpList = query.list();

                if(null != tmpList && tmpList.size() > 0)
                {
                    return tmpList.get(0);
                }
                else
                {
                    log.debug("根据届期id获取当前届期值为 null");
                    return null;
                }
            }
            else
            {
                log.error("参数届期id为空");
                return null;
            }
        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            throw e;
        }
    }

    // 获取当前结题届期id
    // I cannot see the `current` means.
    @Nullable
    public TJieqi getCurrentJieqi()
    {
        log.debug("获取当前结题届期");
        try
        {
            String hql = "from TJieqi  where endprojectState = '01' and isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            @SuppressWarnings("unchecked")
            List<TJieqi>  tmpList = query.list();

            if(null != tmpList && tmpList.size() > 0)
            {
                return tmpList.get(0);
            }
            else
            {
                return null;
            }
        }
        catch(RuntimeException e)
        {
            log.error("获取当前结题届期：Runtime Exception");
            throw e;
        }
    }
}
