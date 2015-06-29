package com.isse.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isse.model.ResultDistribut;
import com.isse.model.TJieqi;
import com.util.PageBean;

public class StatisticDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(StatisticDAO.class);
	
	// 全校项目成绩分布统计
	public List SchooleProjectScore(String jqQici)
	{
		log.debug("全校项目成绩分布统计");
		try
		{
			if(null != jqQici && !"".equals(jqQici.trim()))
			{
				String sql = "Select Distinct t.Project_Score As Labels, Count(t.Project_Score) As Data\n" +
							"  From t_Project t Where t.project_score Is Not Null and t.jq_id = :jqQici\n" + 
							" Group By t.Project_Score Order By t.project_score";
				Query query = this.getSession().createSQLQuery(sql);
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
			String sql = 
				"Select count(1) nbr\n" +
				"  From (Select d.Jq_Id,\n" + 
				"               d.College\n" + 
				"          From t_Declaration d\n" + 
				"         Where d.Isdeleted = 'N'\n" ;
			
				if(null != college && !"".equals(college.trim()))
				{
					sql += " And d.college In (Select u.unit_id From t_unit u Where u.unit_name like :college) \n";
		
				}
				
				if(null != jqQici && !"".equals(jqQici.trim()))
				{
					sql += "  And d.jq_id = :jqQici  \n";
					
				}
				else if(null != jqYear && !"".equals(jqYear.trim()))
				{
					sql += "  And d.jq_id In (Select j.jq_id From t_jieqi j Where j.jq_year = :jqYear ) \n";
					
				}
			
				sql += "  Group By d.Jq_Id, d.College) Res";
				
				Query query = this.getSession().createSQLQuery(sql);
				
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
	public List<ResultDistribut> getSchoolResultDistribut(String college,String jqYear,String jqQici, PageBean pageBean)
	{
		log.debug("全校数据指标");
		try 
		{
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
				"  From (Select d.Jq_Id,\n" + 
				"               d.College,\n" + 
				"               (Select u.Unit_Name From t_Unit u Where u.Unit_Id = d.College) Collegename,\n" + 
				"               (Select j.Jq_Year || '年 第' || j.Qici || '期'\n" + 
				"                  From t_Jieqi j\n" + 
				"                 Where j.Jq_Id = d.Jq_Id) Jqname,\n" + 
				"               Count(d.Declar_Id) Decsum,\n" + 
				"               (Select Count(p.Project_Id)\n" + 
				"                  From t_Project p\n" + 
				"                 Where p.Jq_Id = d.Jq_Id\n" + 
				"                   And p.Unit_Id = d.College) Prosum,\n" + 
				"               (Select Count(p.Project_Id)\n" + 
				"                  From t_Project p\n" + 
				"                 Where p.Project_Score = '优秀'\n" + 
				"                   And p.Jq_Id = d.Jq_Id\n" + 
				"                   And p.Unit_Id = d.College) Bestsum,\n" + 
				"               (Select Count(p.Project_Id)\n" + 
				"                  From t_Project p\n" + 
				"                 Where p.Project_Score = '不及格'\n" + 
				"                   And p.Jq_Id = d.Jq_Id\n" + 
				"                   And p.Unit_Id = d.College) Badsum,\n" + 
				"               (Select Count(Ep.Endproject_Id)\n" + 
				"                  From t_End_Project Ep\n" + 
				"                 Where Ep.Jq_Id = d.Jq_Id\n" + 
				"                   And Ep.Unit_Id = d.College) Endsum\n" + 
				"          From t_Declaration d\n" + 
				"         Where d.Isdeleted = 'N'\n" ;

			if(null != college && !"".equals(college.trim()))
			{
				sql += " And d.college In (Select u.unit_id From t_unit u Where u.unit_name like :college) \n";
			}
			
			if(null != jqQici && !"".equals(jqQici.trim()))
			{
				sql += "  And d.jq_id = :jqQici  \n";
			}
			else if(null != jqYear && !"".equals(jqYear.trim()))
			{
				sql += "  And d.jq_id In (Select j.jq_id From t_jieqi j Where j.jq_year = :jqYear ) \n";
			}
			
			sql += "  Group By d.Jq_Id, d.College) Res";

			Query query = this.getSession().createSQLQuery(sql).addEntity(ResultDistribut.class);
			
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
			
			
			
			query.setFirstResult(pageBean.getBeginIndex());
			query.setMaxResults(pageBean.getPageCapibility());
			@SuppressWarnings("unchecked")
			List<ResultDistribut> result = (List<ResultDistribut>)query.list();
			
			if(null != result && result.size() > 0)
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
	public List<ResultDistribut> getSchoolStatisticsData(String jqQici)
	{
		log.debug("按期次查看各学院统计数据，参数-期次");
		try
		{
			if(null != jqQici && !"".equals(jqQici.trim()))
			{
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
					"  From (Select d.Jq_Id,\n" + 
					"               d.College,\n" + 
					"               (Select u.Unit_Name From t_Unit u Where u.Unit_Id = d.College) Collegename,\n" + 
					"               (Select j.Jq_Year || '年 第' || j.Qici || '期'\n" + 
					"                  From t_Jieqi j\n" + 
					"                 Where j.Jq_Id = d.Jq_Id) Jqname,\n" + 
					"               Count(d.Declar_Id) Decsum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Prosum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Project_Score = '优秀'\n" + 
					"                   And p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Bestsum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Project_Score = '不及格'\n" + 
					"                   And p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Badsum,\n" + 
					"               (Select Count(Ep.Endproject_Id)\n" + 
					"                  From t_End_Project Ep\n" + 
					"                 Where Ep.Jq_Id = d.Jq_Id\n" + 
					"                   And Ep.Unit_Id = d.College) Endsum\n" + 
					"          From t_Declaration d\n" + 
					"         Where d.Isdeleted = 'N'\n" + 
					"          And d.jq_id = :jqQici \n" + 
					"         Group By d.college, d.Jq_Id) Res";
				
				Query query = this.getSession().createSQLQuery(sql).addEntity(ResultDistribut.class);
				query.setString("jqQici", jqQici);
				
				@SuppressWarnings("unchecked")
				List<ResultDistribut> result = (List<ResultDistribut>)query.list();
				
				if(null != result && result.size() > 0)
				{
					return result;
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
			e.printStackTrace();
			throw e;
		}
	}
	
	// 按学院查看各期次统计数据
	public List<ResultDistribut> getSchoolStatisticDataByCollege(String college)
	{
		log.debug("按学院查看各期次统计数据,参数-学院");
		try
		{
			if(null != college && !"".equals(college.trim()))
			{
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
					"  From (Select d.Jq_Id,\n" + 
					"               d.College,\n" + 
					"               (Select u.Unit_Name From t_Unit u Where u.Unit_Id = d.College) Collegename,\n" + 
					"               (Select j.Jq_Year || '年 第' || j.Qici || '期'\n" + 
					"                  From t_Jieqi j\n" + 
					"                 Where j.Jq_Id = d.Jq_Id) Jqname,\n" + 
					"               Count(d.Declar_Id) Decsum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Prosum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Project_Score = '优秀'\n" + 
					"                   And p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Bestsum,\n" + 
					"               (Select Count(p.Project_Id)\n" + 
					"                  From t_Project p\n" + 
					"                 Where p.Project_Score = '不及格'\n" + 
					"                   And p.Jq_Id = d.Jq_Id\n" + 
					"                   And p.Unit_Id = d.College) Badsum,\n" + 
					"               (Select Count(Ep.Endproject_Id)\n" + 
					"                  From t_End_Project Ep\n" + 
					"                 Where Ep.Jq_Id = d.Jq_Id\n" + 
					"                   And Ep.Unit_Id = d.College) Endsum\n" + 
					"          From t_Declaration d\n" + 
					"         Where d.Isdeleted = 'N'\n" + 
					"          And d.college In (Select u.unit_id From t_unit u Where u.unit_name Like :college)\n" + 
					"         Group By d.college, d.Jq_Id) Res";
				
				Query query = this.getSession().createSQLQuery(sql).addEntity(ResultDistribut.class);
				query.setString("college", college);
				
				@SuppressWarnings("unchecked")
				List<ResultDistribut> resultList = (List<ResultDistribut> )query.list();
				
				if(null != resultList && resultList.size() > 0)
				{
					return resultList;
				}
				else
				{
					log.debug("no data");
					return null;
				}

			}
			else
			{
				log.debug("学院参数- null");
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
				
				Query query = this.getSession().createSQLQuery(sql);
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
	public TJieqi getJieqiById(String id)
	{
		log.debug("根据届期id获取当前届期信息");
		try
		{
			if(null != id && !"".equals(id.trim()))
			{
				String sql = "select * from t_jieqi j where j.jq_id = :id";
				Query query = this.getSession().createSQLQuery(sql).addEntity(TJieqi.class);
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
	public TJieqi getCurrentJieqi()
	{
		log.debug("获取当前结题届期");
		try
		{
			String hql = " from TJieqi j Where j.endprojectState = :endprojectState And j.isdeleted = :isdeleted";
			
			Query query = this.getSession().createQuery(hql)
					.setString("endprojectState", "01")
					.setString("isdeleted", "N");
			
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
