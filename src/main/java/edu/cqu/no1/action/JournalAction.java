package edu.cqu.no1.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.cqu.no1.domain.TJournal;
import edu.cqu.no1.service.JournalService;
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
public class JournalAction extends ActionSupport {

    @Resource
    private JournalService journalService;
    private TJournal journal;
    private List<TJournal> listJournals;
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
    private String userName;
    private String journalLoginip;
    private Date journalLogintime;
    private Date journalQuitime;


    @Action(value = "ListJournal", results = {
            @Result(name = "success", location = "/pages/systemManage/journalManage/journal_list.jsp")
    })
    public String listJournal() throws Exception {
        try {
            this.totalNumber = this.journalService.getAllTJournalCount();

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            listJournals = this.journalService.getAllTJournal(pageBean);

            totalPage = this.pageBean.getTotalPage();

            return "success";
        } catch (Exception e) {
            System.out.println("list exception: " + e.toString());

            return ERROR;
        }
    }


    @Action(value = "ListSelectedJournal", results = {
            @Result(name = "success", location = "/pages/systemManage/journalManage/journal_list.jsp")
    })
    public String listSelectedJournal() throws Exception {
        try {
            System.out.println(journalLogintime);
            this.totalNumber = this.journalService.getSelectedTJournalCount(userId, userName, journalLoginip, journalLogintime, journalQuitime);

            // 构造分页对象
            pageBean = new PageBean(page, totalNumber, pageCapacity);

            listJournals = this.journalService.getSelectedTJournal(userId, userName, journalLoginip, journalLogintime, journalQuitime, pageBean);

            totalPage = this.pageBean.getTotalPage();

            return "success";
        } catch (Exception e) {
            System.out.println("list exception: " + e.toString());

            return ERROR;
        }
    }


    /**
     * **************************************************
     * get & set methods
     * ************************************************
     */
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

    public JournalService getJournalService() {
        return journalService;
    }

    public void setJournalService(JournalService journalService) {
        this.journalService = journalService;
    }

    public TJournal getJournal() {
        return journal;
    }

    public void setJournal(TJournal journal) {
        this.journal = journal;
    }

    public List<TJournal> getListJournals() {
        return listJournals;
    }

    public void setListJournals(List<TJournal> listJournals) {
        this.listJournals = listJournals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJournalLoginip() {
        return journalLoginip;
    }

    public void setJournalLoginip(String journalLoginip) {
        this.journalLoginip = journalLoginip;
    }

    public Date getJournalLogintime() {
        return journalLogintime;
    }

    public void setJournalLogintime(Date journalLogintime) {
        this.journalLogintime = journalLogintime;
    }

    public Date getJournalQuitime() {
        return journalQuitime;
    }

    public void setJournalQuitime(Date journalQuitime) {
        this.journalQuitime = journalQuitime;
    }

}
