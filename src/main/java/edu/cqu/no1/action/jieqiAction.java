package edu.cqu.no1.action;


import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.service.JieQiService;
import edu.cqu.no1.util.PageBean;
import org.apache.struts2.convention.annotation.*;
import org.jboss.logging.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Controller

@Namespace("/")
@Scope("prototype")
@ParentPackage("base")
public class jieqiAction extends BaseAction {

    @Resource
    private JieQiService jieQiService;

    private List<TJieqi> jieqis;
    private TJieqi jieqi;
    private String jieqiId;
    private List<JieQiYear> years;
    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();
    private String jqName;
    private String jqYear;
    private String jqQici;
    private String result;

    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数s
    private int pageCapacity = 14; // 每页显示条数

    @Action(value = "ListAllJieqi", results = {
            @Result(name = "success", location = "/pages/systemManage/jieqiManage/jieqi_list.jsp")
    })
    public String findAllJieQis() throws Exception {
        try {
            totalNumber = this.jieQiService.findAllJieqicount(jqName, jqYear, jqQici);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            jieqis = this.jieQiService.findAllJieqis(jqName, jqYear, jqQici, pageBean);
            totalPage = pageBean.getTotalPage();
            findYearsAndQici();
            return SUCCESS;
        } catch (Exception e) {
            System.out.println("find all jieqis faliled" + e);
            return ERROR;
        }
    }

    @Action(value = "PreAddJieqi", results = {
            @Result(name = "success", location = "/pages/systemManage/jieqiManage/jieqi_add.jsp")
    })
    public String preAddJieqi() throws Exception {
        try {
            years = new ArrayList<JieQiYear>();
            int year = Calendar.getInstance().get(Calendar.YEAR);
            years.add(0, new JieQiYear(year + "", year + ""));
            years.add(1, new JieQiYear((year + 1) + "", (year + 1) + ""));
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "AddJieqi", results = {
            @Result(name = "success", type = "json")
    })
    public String addJieqi() throws Exception {
        try {
//			System.out.println(jieqi.getJqName());
            jieqi.setIsdeleted("N");
            this.jieQiService.addJieqi(jieqi);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "PreUpdateJieqi", results = {
            @Result(name = "success", location = "/pages/systemManage/jieqiManage/jieqi_edit.jsp")
    })
    public String preUpdateJieqi() throws Exception {
        try {
            years = new ArrayList<JieQiYear>();
            int year = Calendar.getInstance().get(Calendar.YEAR);
            years.add(0, new JieQiYear(year + "", year + ""));
            years.add(1, new JieQiYear((year + 1) + "", (year + 1) + ""));
            jieqi = this.jieQiService.findTjieqiById(jieqiId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    @Action(value = "UpdateJieqi", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"}),
            @Result(name = "error", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})
    })
    public String updateJieqi() throws Exception {
        try {
            this.jieQiService.updateJieqi(jieqi);
            result = "yes";
            return SUCCESS;
        } catch (Exception e) {
            result = "no";
            return ERROR;
        }
    }

    @Action(value = "DeleteJieqi", results = {
            @Result(name = "success", type = "redirect", location = "ListAllJieqi")
    })
    public String deleteJieqi() throws Exception {
        try {
            this.jieQiService.deleteJieqi(jieqiId);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * TODO 学校申报列表的年份和期次
     * authoy lzh
     */
    private void findYearsAndQici() {
        List<BigDecimal> jqyears = this.jieQiService.findAllYears();
        years = new ArrayList<JieQiYear>();
        //年份list 添加一个"所有",对应的key为"ALL"
        years.add(new JieQiYear("", "所有"));
        TJieqi tJieqi = new TJieqi();
        tJieqi.setJqId("");
        tJieqi.setQici("所有");
        List<TJieqi> list = new ArrayList<TJieqi>();
        list.add(tJieqi);
        qicis.put("", list);
        for (BigDecimal year : jqyears) {
            years.add(new JieQiYear(year.toString(), year.toString()));
            list = this.jieQiService.findJieqiByYear(year.toString());
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            //期次list 添加一个"所有",对应的key为"ALL"
            tmpJieqis.add(tJieqi);
            for (TJieqi t : list) {
                tmpJieqis.add(t);
            }
            qicis.put(year.toString(), tmpJieqis);
        }
    }

    /**
     * ********************************
     * set and get methods
     * *********************************
     */
    public JieQiService getJieQiService() {
        return jieQiService;
    }

    public void setJieQiService(JieQiService jieQiService) {
        this.jieQiService = jieQiService;
    }

    public List<TJieqi> getJieqis() {
        return jieqis;
    }

    public void setJieqis(List<TJieqi> jieqis) {
        this.jieqis = jieqis;
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

    public TJieqi getJieqi() {
        return jieqi;
    }

    public void setJieqi(TJieqi jieqi) {
        this.jieqi = jieqi;
    }

    public String getJieqiId() {
        return jieqiId;
    }

    public void setJieqiId(String jieqiId) {
        this.jieqiId = jieqiId;
    }

    public List<JieQiYear> getYears() {
        return years;
    }

    public void setYears(List<JieQiYear> years) {
        this.years = years;
    }

    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    public String getJqName() {
        return jqName;
    }

    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    public String getJqYear() {
        return jqYear;
    }

    public void setJqYear(String jqYear) {
        this.jqYear = jqYear;
    }

    public String getJqQici() {
        return jqQici;
    }

    public void setJqQici(String jqQici) {
        this.jqQici = jqQici;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
