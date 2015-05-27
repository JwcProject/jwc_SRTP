package edu.cqu.no1.dao.impl;

import edu.cqu.no1.dao.UnitStatisticDAO;
import edu.cqu.no1.domain.ResultDistribut;
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
    @Override
    public List unitProjectScore(String unitId, String jqId) {
        String sql =
                "Select Distinct t.Project_Score As Labels, Count(t.Project_Score) As Data\n" +
                        "  From t_Project t\n" +
                        " where t.Unit_Id = :unitId and t.jq_id =:jqId\n" +
                        "   and t.project_score is not null\n" +
                        " Group By t.Project_Score\n" +
                        " Order By t.project_score";

        Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql);
        query.setString("unitId", unitId);
        query.setString("jqId", jqId);
        List result = query.list();

        if (null != result && result.size() > 0) {
            return result;
        } else {
            return null;
        }

    }


    @Override
    public List<ResultDistribut> getUnitResultDistribut(String unitId, PageBean pageBean) {
        try {
            String sql =

                    "Select Rownum Id,\n" +
                            "       Res.*,\n" +
                            "       (Res.Prosum - Res.Endsum) Delaysum,\n" +
                            "       Decode(Res.Decsum, 0, 0, Round((Res.Prosum / Res.Decsum), 3)) Prorate,\n" +
                            "       Decode(Res.Prosum, 0, 0, Round((Res.Bestsum / Res.Prosum), 3)) Bestrate,\n" +
                            "       Decode(Res.Prosum, 0, 0, Round((Res.Endsum / Res.Prosum), 3)) Endrate,\n" +
                            "       Decode(Res.Prosum,\n" +
                            "              0,\n" +
                            "              0,\n" +
                            "              Round(((Res.Prosum - Res.Endsum) / Res.Prosum), 3)) Delayrate\n" +
                            "  From (Select d.Jq_Id,:unitId college,\n" +
                            "               (Select u.Unit_Name From t_Unit u Where u.Unit_Id = :unitId) Collegename,\n" +
                            "               (Select j.Jq_Year || '年 第' || j.Qici || '期'\n" +
                            "                  From t_Jieqi j\n" +
                            "                 Where j.Jq_Id = d.Jq_Id) Jqname,\n" +
                            "               Count(d.Declar_Id) Decsum,\n" +
                            "               (Select Count(p.Project_Id)\n" +
                            "                  From t_Project p\n" +
                            "                 Where p.Jq_Id = d.Jq_Id\n" +
                            "                   And p.Unit_Id = :unitId) Prosum,\n" +
                            "               (Select Count(p.Project_Id)\n" +
                            "                  From t_Project p\n" +
                            "                 Where p.Project_Score = '优秀'\n" +
                            "                   And p.Jq_Id = d.Jq_Id\n" +
                            "                   And p.Unit_Id = :unitId) Bestsum,\n" +
                            "               (Select Count(p.Project_Id)\n" +
                            "                  From t_Project p\n" +
                            "                 Where p.Project_Score = '不及格'\n" +
                            "                   And p.Jq_Id = d.Jq_Id\n" +
                            "                   And p.Unit_Id = :unitId) Badsum,\n" +
                            "               (Select Count(Ep.Endproject_Id)\n" +
                            "                  From t_End_Project Ep\n" +
                            "                 Where Ep.Jq_Id = d.Jq_Id\n" +
                            "                   And Ep.Unit_Id = :unitId) Endsum\n" +
                            "          From t_Declaration d\n" +
                            "         Where d.Isdeleted = 'N' and d.college= :unitId\n" +
                            "         Group By d.Jq_Id) Res";


            Query query = getSessionFactory().getCurrentSession().createSQLQuery(sql).addEntity(ResultDistribut.class);
            query.setString("unitId", unitId);

            if (pageBean != null) {
                query.setFirstResult(pageBean.getBeginIndex());
                query.setMaxResults(pageBean.getPageCapibility());
            }

            List<ResultDistribut> result = query.list();

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

    @Override
    public int getUnitResultDistributCount(String unitId) {
        try {
            String queryStr = "select count(1) from (select t.jq_id from t_declaration t where t.isdeleted='N' and t.college=:unitId Group By t.Jq_Id) Res";

            Query query = getSessionFactory().getCurrentSession().createSQLQuery(queryStr);
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
