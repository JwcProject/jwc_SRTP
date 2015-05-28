package edu.cqu.no1.dao.impl;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import edu.cqu.no1.dao.*;
import edu.cqu.no1.domain.TExpertLib;
import edu.cqu.no1.domain.TExpertTeacher;
import edu.cqu.no1.util.PageBean;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZKQ on 2015/5/27.
 */

@Repository
public class TExpertTeacherDAOImpl extends BaseDaoImpl<TExpertTeacher> implements edu.cqu.no1.dao.TExpertTeacherDAO {

    private static final Logger log = LoggerFactory
            .getLogger(TExpertTeacherDAO.class);
    // property constants
    public static final String ISDELETED = "isdeleted";



    @Override
    public List findByIsdeleted(Object isdeleted) {
        return findByProperty(ISDELETED, isdeleted);
    }



    public static TExpertTeacherDAO getFromApplicationContext(
            ApplicationContext ctx) {
        return (TExpertTeacherDAO) ctx.getBean("TExpertTeacherDAO");
    }

    //根据届期id，专家库类型，获取专家库
    @Override
    public List<TExpertLib> findExpertLibByJqid(String jqId, String type)
    {
        log.debug("get expert lib by jqid");
        try
        {
            if(null != jqId && !"".equals(jqId.trim()) && null != type && ("01".equals(type.trim()) || "02".equals(type.trim())))
            {
                String sql = "Select * From t_expert_lib l Where l.isdeleted='N' and l.jq_id = :jqId And l.type= :type";
                Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(TExpertLib.class);

                query.setString("jqId", jqId);
                query.setString("type", type);

                @SuppressWarnings("unchecked")
                List<TExpertLib> tmpList = query.list();

                if(null != tmpList && tmpList.size() > 0)
                {
                    return tmpList;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                log.error("parameter is null");
                return null;
            }
        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            throw e;
        }
    }

    //根据届期id，专家库类型，登陆教师ID，获取本学院专家库
    @Override
    public List<TExpertLib> findUnitExpertLibByJqid(String jqId, String type, String teacherCode)
    {
        log.debug("get expert lib by jqid");
        try
        {
            if(null != jqId && !"".equals(jqId.trim()) && null != type && null != teacherCode && !"".equals(teacherCode.trim()) && ("01".equals(type.trim()) || "02".equals(type.trim())))
            {
                String sql =
                        "Select *\n" +
                                "  From t_Expert_Lib l\n" +
                                " Where l.Unit_Id In\n" +
                                "       (Select t.Unit_Id From t_Teacher t Where t.Tea_Code = :teacherCode)\n" +
                                "   And l.Isdeleted = 'N'\n" +
                                "   And l.Jq_Id = :jqId \n" +
                                "   And l.Type = :type ";
                Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(TExpertLib.class);

                query.setString("teacherCode", teacherCode);
                query.setString("jqId", jqId);
                query.setString("type", type);

                @SuppressWarnings("unchecked")
                List<TExpertLib> tmpList = query.list();

                if(null != tmpList && tmpList.size() > 0)
                {
                    return tmpList;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                log.error("parameter is null");
                return null;
            }
        }
        catch(RuntimeException e)
        {
            log.error(e.toString());
            throw e;
        }
    }

    //通过单个老师的id找到最近的专家教师对象
    @Override
    public TExpertTeacher getExpertTeachersByTeaId(String teaId, String type){
        log.debug("get expertTeachers by teacher id");
        try {
            String queryStr =
                    "select t.*\n" +
                            "  from t_expert_teacher t , (select l.lib_id\n" +
                            "  from t_expert_lib l\n" +
                            " where l.lib_id in\n" +
                            "       (select tt.lib_id\n" +
                            "          from t_expert_teacher tt\n" +
                            "         where tt.isdeleted = 'N'\n" +
                            "           and tt.tea_id =:teaId)\n" +
                            "            and l.type =:type And Rownum = 1\n" +
                            " order by l.creat_on Desc ) tmp\n" +
                            " where t.isdeleted = 'N'\n" +
                            "   and t.tea_id =:teaId\n" +
                            "   and t.lib_id = tmp.lib_id ";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
            sqlQuery.setString("teaId", teaId);
            sqlQuery.setString("type", type);
            List list = sqlQuery.list();

            if (null!= sqlQuery.list() && sqlQuery.list().size()>0) {
                return (TExpertTeacher)sqlQuery.addEntity(TExpertTeacher.class).list().get(0);
            } else {
                return null;
            }

        } catch (RuntimeException re) {
            log.error("get expertTeachers by teacher id failed", re);
            throw re;
        }
    }

    //通过届期找到对应的专家教师
    @Override
    public List findExpertTeachersByJQid(String jqId){
        log.debug("get expertTeachers by jieqi id");
        try {
            String queryStr = "From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId in (select l.libId from TExpertLib l where l.TJieqi.jqId=:jqId)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);
            return query.list();
        } catch (RuntimeException re) {
            log.error("get expertTeachers by jieqi id failed", re);
            throw re;
        }
    }

    //获取本届期已经分配的专家教师
    @Override
    public List findAssignedExpertTeachers(String jqId, String type, String teaCode){
        log.debug("get Assigned expertTeachers");
        try {

            String queryStr = "From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId in (select l.libId from TExpertLib l where l.isdeleted='N' and l.TJieqi.jqId=:jqId and l.type=:type) and e.TTeacher.teaId in(select t.teaId from TTeacher t where t.isdeleted='N' and t.TUnit.unitId=(select tt.TUnit.unitId from TTeacher tt where tt.isdeleted='N' and tt.teaCode=:teaCode))";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jqId);
            query.setString("type", type);
            query.setString("teaCode", teaCode);

            return query.list();

        } catch (RuntimeException re) {
            log.error("get expertTeachers by jieqi id failed", re);
            throw re;
        }
    }

    //通过专家库id得到专家教师
    @Override
    public List getExpetTeachersByExpertLib(String libId)
    {
        log.debug("get expertTeachers by expertLib");
        try {

            String queryStr = "From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId=:libId)";

            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("libId", libId);

            return query.list();

        } catch (RuntimeException re) {
            log.error("get expertTeachers by expertLib", re);
            throw re;
        }
    }

    /**
     *
     *TODO 根据专家库ID获取某一期的专家教师（分页）
     *authoy lzh
     *@param expLibId
     *@return
     */
    @Override
    public List findExpTeaByExpLibId(String expLibId, PageBean pageBean){
        log.debug("get expertTeachers by expertLib id");
        try {
            String queryStr = "From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId =:expLibId";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("expLibId", expLibId);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException re) {
            log.error("get expertTeachers by expertLib id failed", re);
            throw re;
        }
    }

    @Override
    public int findExpTeaCountByExpLibId(String expLibId){
        log.debug("get expertTeachers count by expertLib id");
        try {
            String queryStr = "select count(*) From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId =:expLibId)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("expLibId", expLibId);
            List list =  query.list();
            int count = 0;
            if(list.size() > 0){
                count = new Integer(""+list.get(0));
            }
            return count;
        } catch (RuntimeException re) {
            log.error("get expertTeachers count by expertLib id failed", re);
            throw re;
        }
    }

    /**
     *
     *TODO 根据专家库ID获取某一期的专家教师（不分页）
     *authoy lzh
     *@param expLibId
     *@return
     */
    @Override
    public List findExpTeaByExpLibId(String expLibId){
        log.debug("get expertTeachers by expertLib id");
        try {
            String queryStr = "From TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.libId =:expLibId)";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("expLibId", expLibId);
            return query.list();
        } catch (RuntimeException re) {
            log.error("get expertTeachers by expertLib id failed", re);
            throw re;
        }
    }

    //修改评审教师的用户类型
    @Override
    public void changeReviewUserType(String libId)
    {
        log.debug("change review teacher user type");
        try {
            String querString =
                    "Update T_User u\n" +
                            "   Set U.User_Type = '04'\n" +
                            " Where U.User_Id In\n" +
                            "       (Select t.tea_code\n" +
                            "          From t_teacher t\n" +
                            "         Where t.tea_id In\n" +
                            "               (Select et.tea_id\n" +
                            "                  From t_expert_teacher et\n" +
                            "                 Where et.lib_id =:libId))";
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(querString);
            sqlQuery.setString("libId", libId);
            sqlQuery.executeUpdate();

        } catch (RuntimeException re) {
            log.error("change review teacher user type failed", re);
            throw re;
        }
    }



    /**
     *
     *TODO 根据教职工号获取专家教师对象
     *authoy lzh
     *@param teaCode
     *@return
     */
    @Override
    public TExpertTeacher findExpTeaByCode(String teaCode){
        log.debug("get expertTeachers by teaCode");
        try {
            String queryStr = "from TExpertTeacher e where e.isdeleted='N' and e.TTeacher.teaCode=:code";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("code", teaCode);
            List list =  query.list();
            TExpertTeacher teacher = null;
            if(list.size()>0){
                teacher = (TExpertTeacher) list.get(0);
            }
            return teacher;
        } catch (RuntimeException re) {
            log.error("get expertTeachers by jieqi id failed", re);
            throw re;
        }
    }
    @Override
    public int getExpTeaCountByQici(String jieqiId, String type){
        log.debug("getExpTeaCountByQici");
        try {
            String queryStr = "select count(*) from TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.TJieqi.jqId=:jqId and e.TExpertLib.type=:type";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jieqiId);
            query.setString("type", type);
            List list = query.list();
            int count = 0;
            if (list.size() > 0) {
                count = new Integer("" + list.get(0));
            }
            return count;
        } catch (RuntimeException re) {
            log.error("getExpTeaCountByQici", re);
            throw re;
        }
    }
    @Override
    public List getExpertTeachersByQici(String jieqiId,
                                        String type, PageBean pageBean){
        log.debug("getExpertTeachersByQici");
        try {
            String queryStr = "from TExpertTeacher e where e.isdeleted='N' and e.TExpertLib.TJieqi.jqId=:jqId and e.TExpertLib.type=:type";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryStr);
            query.setString("jqId", jieqiId);
            query.setString("type", type);
            query.setFirstResult(pageBean.getBeginIndex());
            query.setMaxResults(pageBean.getPageCapibility());
            return query.list();
        } catch (RuntimeException re) {
            log.error("getExpertTeachersByQici", re);
            throw re;
        }
    }
}