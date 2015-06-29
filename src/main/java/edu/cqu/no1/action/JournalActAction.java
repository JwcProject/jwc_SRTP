package edu.cqu.no1.action;


import com.opensymphony.xwork2.ActionSupport;
import edu.cqu.no1.domain.TJournalAct;
import edu.cqu.no1.service.JournalActService;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class JournalActAction extends ActionSupport {

    @Resource
	private JournalActService journalActService;
	private TJournalAct journalAct;
	private List<TJournalAct> listJournalActs;
	private String id;
	
	/**
	 * 分页使用的参数
	 */
	private int page = 1; // 初始页面
	private PageBean pageBean; // 分页用的bean
	private int totalPage = 1; // 总页面数
	private int totalNumber = 0; // 总数据条数
	private int pageCapacity = 10; // 每页显示条数
	
	/*
	 * 查询所使用的参数
	 */
	private String userId;
	private String journalactType;
	private String journalactIntroduction;
	private Date time;


    @Action(value = "ListJournalAct", results = {
            @Result(name = "success", location = "/pages/systemManage/journalManage/journal_act_list.jsp")
    })
	public String listJournalAct() throws Exception
	{
		try
		{
			this.totalNumber = this.journalActService.getAllTJournalActCount();
			
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
			      
			listJournalActs = this.journalActService.getAllTJournalAct(pageBean);
			
			totalPage = this.pageBean.getTotalPage(); 
			
			return SUCCESS;
		}
		catch (Exception e)
		{
			System.out.println("list exception: " + e.toString());
			
			return ERROR;
		}
	}


    @Action(value = "ListSelectedJournalAct", results = {
            @Result(name = "success", location = "/pages/systemManage/journalManage/journal_act_list.jsp")
    })
	public String listSelectedJournalAct() throws Exception
	{
		try
		{
			
            this.totalNumber = this.journalActService.getSelectedTJournalActCount(userId, journalactType, journalactIntroduction, time);
            
			// 构造分页对象
			pageBean = new PageBean(page,totalNumber,pageCapacity);
				      
		    listJournalActs = this.journalActService.getSelectedTJournalAct(userId, journalactType, journalactIntroduction, time, pageBean);
		    
			totalPage = this.pageBean.getTotalPage(); 
			
			return SUCCESS;
		}
		catch (Exception e)
		{
            System.out.println("list exception: " + e.toString());
			
			return ERROR;
		}
	}
	

	
	/*****************************************************
	 *  get & set methods
	 * *************************************************/
	

	public JournalActService getJournalActService() {
		return journalActService;
	}

	public void setJournalActService(JournalActService journalActService) {
		this.journalActService = journalActService;
	}

	public TJournalAct getJournalAct() {
		return journalAct;
	}

	public void setJournalAct(TJournalAct journalAct) {
		this.journalAct = journalAct;
	}

	public List<TJournalAct> getListJournalActs() {
		return listJournalActs;
	}

	public void setListJournalActs(List<TJournalAct> listJournalActs) {
		this.listJournalActs = listJournalActs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJournalactType() {
		return journalactType;
	}

	public void setJournalactType(String journalactType) {
		this.journalactType = journalactType;
	}

	public String getJournalactIntroduction() {
		return journalactIntroduction;
	}

	public void setJournalactIntroduction(String journalactIntroduction) {
		this.journalactIntroduction = journalactIntroduction;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	

}
