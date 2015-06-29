package edu.cqu.no1.action;

import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.domain.TUnit;
import edu.cqu.no1.service.StatisticService;
import edu.cqu.no1.service.UnitStatisticService;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller

@Namespace("/UnitStatistic")
@Scope("prototype")
@ParentPackage("base")
public class UnitStatisticAction extends BaseAction {

    @Resource
	public UnitStatisticService unitStatisticService;
    @Resource
	public StatisticService statisticService;
	public List unitScoreList = new ArrayList();
	public List<TResultDistribut> resultDistribut = new ArrayList();
	public double[] data  ;
	public String[] labels ;
	public double[] proRate;
	public double[] bestRate;
	public double[] proSum;
	public String jqId;
	public String jqName;
	private TJieqi jieqi;
	
	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 14; // 每页显示条数


    @Action(value = "UnitScoreStatistic", results = {
            @Result(name = "success", location = "/pages/unitStatisticsManage/circlelabelpie.jsp"),
            @Result(name = "noData", location = "/noData_err.jsp")
    })
	public String unitScoreStatistic() throws Exception
	{
		try
		{
			TUnit unit = getSessionUnit();
			if(unit == null || unit.getUnitId() == null
					|| unit.getUnitId().equals("")){
				toLogin();
			}
			String unitId = getSessionUnit().getUnitId();
			unitScoreList = this.unitStatisticService.unitProjectScore(unitId,jqId);
			if(null != unitScoreList && unitScoreList.size() > 0)
			{
				data = new double[unitScoreList.size()];
				labels = new String[unitScoreList.size()];
				int i=0;
				 for(Iterator iterator = unitScoreList.iterator();iterator.hasNext();){
					 	if(i > unitScoreList.size())
			            {
					 		System.out.println("i: "+i);
			            	break;
			            }
			            Object[] objects = (Object[]) iterator.next(); 
			            labels[i] = objects[0].toString();
			            data[i] = Double.parseDouble(objects[1].toString());
			            ++i;
			            
			        } 
				 
				 HttpServletRequest request = ServletActionContext.getRequest();
				 if(null != request.getSession().getAttribute("data"))
				 {
					 request.getSession().removeAttribute("data");
				 }
				 if(null != request.getSession().getAttribute("labels"))
				 {
					 request.getSession().removeAttribute("labels");
				 }
				 
				 request.getSession().setAttribute("data", data);
				 request.getSession().setAttribute("labels", labels);
				 jieqi = this.statisticService.getJieqiById(jqId);
				 jqName =jieqi.getJqYear()+"年 第" + jieqi.getQici()+"期" ;
				
				return SUCCESS;
			}
			else
			{
				return "noData";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}


    @Action(value = "UnitResultDistribut", results = {
            @Result(name = "success", location = "/pages/unitStatisticsManage/unit_result_statistic_list.jsp")
    })
	public String  unitResultDistribut() throws Exception
	{
		try
		{
			TUnit unit = getSessionUnit();
			if(unit == null || unit.getUnitId() == null
					|| unit.getUnitId().equals("")){
				toLogin();
			}
			String unitId = getSessionUnit().getUnitId();
			totalNumber = this.unitStatisticService.getUnitResultDistributCount(unitId);
			pageBean = new PageBean(page, totalNumber, pageCapacity);
			resultDistribut = this.unitStatisticService.getUnitResultDistribut(unitId,pageBean);
			totalPage = pageBean.getTotalPage();
			return SUCCESS;
		}
		catch(Exception e)
		{
			return ERROR;
		}
	}



	//查看学院统计图-折线图
    @Action(value = "UnitLineChart", results = {
            @Result(name = "success", location = "/pages/unitStatisticsManage/linePages/symbolline.jsp"),
            @Result(name = "error", location = "../db_err.jsp"),


    })
	public String unitLineChart() throws Exception
	{
		try {
			TUnit unit = getSessionUnit();
			if(unit == null || unit.getUnitId() == null
					|| unit.getUnitId().equals("")){
				toLogin();
			}
			String unitId = getSessionUnit().getUnitId();
			resultDistribut = this.unitStatisticService.getUnitResultDistribut(unitId,pageBean);
			if(null!=resultDistribut && resultDistribut.size()>0)
			{
				labels = new String[resultDistribut.size()];
				proRate = new double[resultDistribut.size()];
				bestRate = new double[resultDistribut.size()];
				proSum = new double[resultDistribut.size()];
				for(int i = 0;i<resultDistribut.size();++i)
				{
					labels[i] = resultDistribut.get(i).getJqname();
					proRate[i] = resultDistribut.get(i).getProrate()*100;
					bestRate[i] = resultDistribut.get(i).getBestrate()*100;
					proSum[i] = resultDistribut.get(i).getProsum();
				}
				HttpServletRequest request = ServletActionContext.getRequest();
				if (null != request.getSession().getAttribute("labels")) {
					request.getSession().removeAttribute("labels");
				}
				if (null != request.getSession().getAttribute("proRate")) {
					request.getSession().removeAttribute("proRate");
				}
				if (null != request.getSession().getAttribute("bestRate")) {
					request.getSession().removeAttribute("bestRate");
				}
				
				request.getSession().setAttribute("labels", labels);
				request.getSession().setAttribute("proRate", proRate);
				request.getSession().setAttribute("bestRate", bestRate);
				
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}
	

	public UnitStatisticService getUnitStatisticService() {
		return unitStatisticService;
	}


	public void setUnitStatisticService(UnitStatisticService unitStatisticService) {
		this.unitStatisticService = unitStatisticService;
	}

	public List getUnitScoreList() {
		return unitScoreList;
	}


	public void setUnitScoreList(List unitScoreList) {
		this.unitScoreList = unitScoreList;
	}


	public double[] getData() {
		return data;
	}


	public void setData(double[] data) {
		this.data = data;
	}


	public String[] getLabels() {
		return labels;
	}


	public void setLabels(String[] labels) {
		this.labels = labels;
	}


	public List<TResultDistribut> getResultDistribut() {
		return resultDistribut;
	}


	public void setResultDistribut(List<TResultDistribut> resultDistribut) {
		this.resultDistribut = resultDistribut;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public PageBean getPageBean() {
		return pageBean;
	}


	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getTotalNumber() {
		return totalNumber;
	}


	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}


	public int getPageCapacity() {
		return pageCapacity;
	}


	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}


	public double[] getProRate() {
		return proRate;
	}


	public void setProRate(double[] proRate) {
		this.proRate = proRate;
	}


	public double[] getBestRate() {
		return bestRate;
	}


	public void setBestRate(double[] bestRate) {
		this.bestRate = bestRate;
	}


	public double[] getProSum() {
		return proSum;
	}


	public void setProSum(double[] proSum) {
		this.proSum = proSum;
	}


	public String getJqId() {
		return jqId;
	}


	public void setJqId(String jqId) {
		this.jqId = jqId;
	}


	public String getJqName() {
		return jqName;
	}


	public void setJqName(String jqName) {
		this.jqName = jqName;
	}


	public StatisticService getStatisticService() {
		return statisticService;
	}


	public void setStatisticService(StatisticService statisticService) {
		this.statisticService = statisticService;
	}


	public TJieqi getJieqi() {
		return jieqi;
	}


	public void setJieqi(TJieqi jieqi) {
		this.jieqi = jieqi;
	}

	
}
