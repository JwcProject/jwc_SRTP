package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.sun.istack.internal.Nullable;
import edu.cqu.no1.dao.StatisticDAO;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class StatisticDAOImpl extends BaseDaoImpl implements StatisticDAO {
    private static final Logger log = LoggerFactory.getLogger(StatisticDAOImpl.class);

    // 全校项目成绩分布统计
    @Nullable
    public List<Map> SchooleProjectScore(String jqQici) {
        log.debug("全校项目成绩分布统计");
        try {
            if(null != jqQici && !"".equals(jqQici.trim())) {
                String hql = "select new Map(projectScore, count(projectId)) from TProject" +
                        " where projectScore is not null and TJieqi.jqId = :jqQici group by projectScore";

                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString("jqQici", jqQici);
                List<Map> result = query.list();

                if(null != result && result.size() > 0) {
                    return result;
                }
                else {
                    log.debug("全校项目成绩分布统计list is null");
                    return null;
                }
            }
            else {
                log.error("全校项目成绩分布统计-参数 is null");
                return null;
            }

        }
        catch(RuntimeException e) {
            log.error(e.toString());
            throw e;
        }
    }

    // 全校数据指标 数据条数
    public int getSchoolResultDistributCount(String college, String jqYear, String jqQici) {
        log.debug("全校项目成绩分布数据指标，数据条目");
        try {
            String hql = "select count(*) from TDeclaration where isdeleted = 'N'";

            if(null != college && !"".equals(college.trim())) {
                hql += " and TUnit.unitName like :college";
            }

            if(null != jqQici && !"".equals(jqQici.trim())) {
                hql += " and TJieqi.jqId = :jqQici";
            }
            else if(null != jqYear && !"".equals(jqYear.trim())) {
                hql += " and TJieqi.jqYear = :jqYear";
            }

            hql += " group by TJieqi, TUnit";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            if(null != college && !"".equals(college.trim())) {
                query.setString("college", "%"+college+"%");

            }
            if(null != jqQici && !"".equals(jqQici.trim())) {
                query.setString("jqQici", jqQici);
            }
            else if(null != jqYear && !"".equals(jqYear.trim())) {
                query.setString("jqYear", jqYear);
            }

            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }

            return count;
        }
        catch(RuntimeException e) {
            log.error(e.toString());
            throw e;
        }
    }

    // 全校数据指标 List
    @Nullable
    public List<TResultDistribut> getSchoolResultDistribut(String college, String jqYear, String jqQici, PageBean pageBean) {
        log.debug("全校数据指标");
        try {
            String hql = "select d.TJieqi.jqId, d.TUnit.unitId, u.unitName, jq.jqYear || '年 第' || jq.qici || '期', count(d)," +
                    " count(pro), count(best), count(bad), count(ed)" +
                    " from TDeclaration d, TEndProject ed, TProject pro, TProject best, TProject bad" +
                    " join d.TUnit u join d.TJieqi jq" +
                    " where pro.TJieqi = d.TJieqi and pro.TUnit = d.TUnit" +
                    " and best.TJieqi = d.TJieqi and best.TUnit = d.TUnit" +
                    " and bad.TJieqi = d.TJieqi and bad.TUnit = d.TUnit" +
                    " and d.isdeleted = 'N' and best.projectScore = '优秀' and bad.projectScore = '不及格'" +
                    " and ed.TJieqi = d.TJieqi and ed.TUnit = d.TUnit";

            if(null != college && !"".equals(college.trim())) {
                hql += " and d.TUnit.unitName like :college";
            }

            if(null != jqQici && !"".equals(jqQici.trim())) {
                hql += " and d.TJieqi.jqId = :jqQici";
            }
            else if(null != jqYear && !"".equals(jqYear.trim())) {
                hql += " and d.TJieqi.jqYear = :jqYear";
            }

            hql += " group by d.TJieqi, d.TUnit";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            if(null != college && !"".equals(college.trim())) {
                query.setString("college", "%"+college+"%");

            }
            if(null != jqQici && !"".equals(jqQici.trim())) {
                query.setString("jqQici", jqQici);
            }
            else if(null != jqYear && !"".equals(jqYear.trim())) {
                query.setString("jqYear", jqYear);
            }

            if (null != pageBean) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }

            @SuppressWarnings("unchecked")
            List<Object[]> result = query.list();

            if(null != result && result.size() > 0) {
                List<TResultDistribut> list = new ArrayList<TResultDistribut>();
                for (int i = 0; i < result.size(); ++i) {
                    Object[] objs = result.get(i);
                    int decsum = (Integer)objs[4];
                    int prosum = (Integer)objs[5];
                    int bestsum = (Integer)objs[6];
                    int badsum = (Integer)objs[7];
                    int endsum = (Integer)objs[8];
                    int delaysum = prosum - endsum;
                    double prorate = Math.round(prosum * 1.0 / decsum * 1000) / 1000;
                    double bestrate = Math.round(bestsum * 1.0 / prosum * 1000) / 1000;
                    double endrate = Math.round(endsum * 1.0 / prosum * 1000) / 1000;
                    double delayrate = Math.round(delaysum * 1.0 / prosum * 1000) / 1000;
                    TResultDistribut tResultDistribut = new TResultDistribut();
                    tResultDistribut.setId(String.valueOf(i));
                    tResultDistribut.setJqId((String)objs[0]);
                    tResultDistribut.setCollege((String)objs[1]);
                    tResultDistribut.setCollegename((String)objs[2]);
                    tResultDistribut.setJqname((String)objs[3]);
                    tResultDistribut.setDecsum(decsum * 1.0);
                    tResultDistribut.setProsum(prosum * 1.0);
                    tResultDistribut.setBestsum(bestsum * 1.0);
                    tResultDistribut.setBadsum(badsum * 1.0);
                    tResultDistribut.setEndsum(endsum * 1.0);
                    tResultDistribut.setDelaysum(delaysum * 1.0);
                    tResultDistribut.setProrate(prorate);
                    tResultDistribut.setBestrate(bestrate);
                    tResultDistribut.setEndrate(endrate);
                    tResultDistribut.setDelayrate(delayrate);
                    list.add(tResultDistribut);
                }
                return list;
            }
            else {
                log.debug("全校数据指标list is null");
                return null;
            }
        } catch (RuntimeException e) {
            log.error(e.toString());
            e.printStackTrace();
            throw e;
        }
    }

    // 按期次查看各学院数据
    @Nullable
    public List<TResultDistribut> getSchoolStatisticsData(String jqQici) {
        log.debug("按期次查看各学院统计数据，参数-期次");
        return getSchoolResultDistribut(null, null, jqQici, null);
    }

    // 按学院查看各期次统计数据
    @Nullable
    public List<TResultDistribut> getSchoolStatisticDataByCollege(String college) {
        log.debug("按学院查看各期次统计数据,参数-学院");
        return getSchoolResultDistribut(college, null, null, null);
    }


    // 根据学院名称参数，判断参数是否合法
    
    public int getCollegeCountByName(String college) {
        log.debug("根据学院名称参数，查询学院取值，判断参数是否合法");
        try {
            int count = 0;
            if(null != college && !"".equals(college.trim())) {
                String hql = "select count(*) from TUnit where unitName like :college";

                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString("college", "%"+college+"%");

                List tmpList = query.list();

                if(null != tmpList && tmpList.size() >0) {
                    count = Integer.parseInt(tmpList.get(0).toString());
                }
            } else {
                log.debug("学院名称参数- null");
            }

            return count;
        } catch (RuntimeException e) {
            log.error(e.toString());
            e.printStackTrace();
            throw e;
        }
    }

    // 根据届期id获取当前届期信息
    @Nullable
    public TJieqi getJieqiById(String id) {
        log.debug("根据届期id获取当前届期信息");
        try {
            if(null != id && !"".equals(id.trim())) {
                String hql = "from TJieqi where jqId = :id";
                Query query = getSessionFactory().getCurrentSession().createQuery(hql);
                query.setString("id", id);

                @SuppressWarnings("unchecked")
                List<TJieqi> tmpList = query.list();

                if(null != tmpList && tmpList.size() > 0) {
                    return tmpList.get(0);
                } else {
                    log.debug("根据届期id获取当前届期值为 null");
                    return null;
                }
            } else {
                log.error("参数届期id为空");
                return null;
            }
        } catch(RuntimeException e) {
            log.error(e.toString());
            throw e;
        }
    }

    // 获取当前结题届期id
    @Nullable
    public TJieqi getCurrentJieqi() {
        log.debug("获取当前结题届期");
        try {
            String hql = "from TJieqi where endprojectState = '01' and isdeleted = 'N'";

            Query query = getSessionFactory().getCurrentSession().createQuery(hql);

            @SuppressWarnings("unchecked")
            List<TJieqi>  tmpList = query.list();

            if(null != tmpList && tmpList.size() > 0) {
                return tmpList.get(0);
            } else {
                return null;
            }
        } catch(RuntimeException e) {
            log.error("获取当前结题届期：Runtime Exception");
            throw e;
        }
    }
}
