package edu.cqu.no1.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.cqu.no1.datamodel.JieQiYear;
import edu.cqu.no1.domain.TJieqi;
import edu.cqu.no1.domain.TResultDistribut;
import edu.cqu.no1.service.DeclarationService;
import edu.cqu.no1.service.StatisticService;
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
import java.math.BigDecimal;
import java.util.*;

@Controller

@Namespace("/Statistic")
@Scope("prototype")
@ParentPackage("base")
public class StatisticAction extends ActionSupport {

    @Resource
    public StatisticService statisticService;
    @Resource
    private DeclarationService declarationService;

    public List schoolScoreList = new ArrayList();
    public List<TResultDistribut> resultDistribut = new ArrayList();
    public double[] data;
    public String[] labels;

    // 申报数
    public double[] decSum;
    // 立项数
    public double[] proSum;
    // 优秀数
    public double[] bestSum;
    // 不及格数
    public double[] badSum;
    // 结题数
    public double[] endSum;
    // 延期数
    public double[] delaySum;
    // 立项率
    public double[] proRate;
    // 优秀率
    public double[] bestRate;
    // 结题率
    public double[] endRate;
    // 延期率
    public double[] delayRate;

    private Map<String, List<TJieqi>> qicis = new HashMap<String, List<TJieqi>>();
    private List<Integer> years;
    private List<JieQiYear> jieQiYears;
    private String college;
    private String jqYear;
    private String jqQici;

    private String collegeName;
    private String jqName;
    private String result;
    private TJieqi jieqi;
    /**
     * 分页使用的参数
     */
    private int page = 1; // 初始页面
    private PageBean pageBean; // 分页用的bean
    private int totalPage = 1; // 总页面数
    private int totalNumber = 0; // 总数据条数
    private int pageCapacity = 14; // 每页显示条数


    @Action(value = "ListSchoolProjectScore", results = {
            @Result(name = "success", location = "/pages/StatisticsManage/iconpie2.jsp"),
            @Result(name = "noData", location = "/noData_err.jsp")
    })
    public String schoolScoreStatistic() throws Exception {
        try {
            getJieQiAndPro();
            // 判断参数是否为空，否则的话使用当前结题届期的期次
            if (null != jqQici && !"".equals(jqQici.trim())) {
                schoolScoreList = this.statisticService.SchooleProjectScore(jqQici);
                jieqi = this.statisticService.getJieqiById(jqQici);
            } else {
                jieqi = this.statisticService.getCurrentJieqi();
                if (null != jieqi && !"".equals(jieqi.getJqId())) {
                    schoolScoreList = this.statisticService.SchooleProjectScore(jieqi.getJqId());
                } else {
                    result = "noData";
                    return "noData";
                }
            }
            if (null != schoolScoreList && schoolScoreList.size() > 0) {
                data = new double[schoolScoreList.size()];
                labels = new String[schoolScoreList.size()];
                int i = 0;
                for (Iterator iterator = schoolScoreList.iterator(); iterator.hasNext(); ) {
                    if (i > schoolScoreList.size()) {
                        System.out.println("i: " + i);
                        break;
                    }
                    Object[] objects = (Object[]) iterator.next();
                    labels[i] = objects[0].toString();
                    data[i] = Double.parseDouble(objects[1].toString());
                    ++i;

                }
                Object[] tmpArray = schoolScoreList.toArray();

                HttpServletRequest request = ServletActionContext.getRequest();
                if (null != request.getSession().getAttribute("data")) {
                    request.getSession().removeAttribute("data");
                }
                if (null != request.getSession().getAttribute("labels")) {
                    request.getSession().removeAttribute("labels");
                }
                request.getSession().setAttribute("data", data);
                request.getSession().setAttribute("labels", labels);
                result = SUCCESS;
                return SUCCESS;
            } else {
                result = "noData";
                return "noData";
            }
        } catch (Exception e) {
            return ERROR;
        }
    }


    /**
     * TODO 学校申报列表的年份和期次
     */
    private void getJieQiAndPro() {
        years = this.declarationService.findAllYears();
        jieQiYears = new ArrayList<JieQiYear>();
        //年份list 添加一个"所有",对应的key为"ALL"
        //jieQiYears.add(new JieQiYear("", "所有"));
        TJieqi tJieqi = new TJieqi();
        //tJieqi.setJqId("");
        //tJieqi.setQici("所有");
        List<TJieqi> list = new ArrayList<TJieqi>();
        list.add(tJieqi);
        //qicis.put("",list);
        for (Integer year : years) {
            jieQiYears.add(new JieQiYear(year.toString(), year.toString()));
            list = this.declarationService.findJieqiByYear(year.toString());
            List<TJieqi> tmpJieqis = new ArrayList<TJieqi>();
            //期次list 添加一个"所有",对应的key为"ALL"
            //tmpJieqis.add(tJieqi);
            for (TJieqi t : list) {
                tmpJieqis.add(t);
            }
            qicis.put(year.toString(), tmpJieqis);
        }
    }


    // 全校数据指标分布列表
    @Action(value = "SchoolResultDistribut", results = {
            @Result(name = "success", location = "/pages/StatisticsManage/school_result_statistic_list.jsp")
    })
    public String schoolResultDistribut() throws Exception {
        try {
            getJieQiAndPro();
            totalNumber = this.statisticService.getSchoolResultDistributCount(college, jqYear, jqQici);
            pageBean = new PageBean(page, totalNumber, pageCapacity);
            resultDistribut = this.statisticService.getSchoolResultDistribut(college, jqYear, jqQici, pageBean);
            totalPage = pageBean.getTotalPage();
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }


    // 按期次查看各学院数据指标
    @Action(value = "CollegeResultDistribut", results = {
            @Result(name = "success", location = "/pages/StatisticsManage/barPages/cylinderlightbar.jsp"),
            @Result(name = "noData", location = "../noData_err.jsp")
    })
    public String collegeResultDistribut() throws Exception {
        try {
            resultDistribut = this.statisticService.getSchoolStatisticsData(jqQici);
            if (null != resultDistribut && resultDistribut.size() > 0) {
                // 标注 - 学院
                labels = new String[resultDistribut.size()];
                // 申报数
                decSum = new double[resultDistribut.size()];
                // 立项数
                proSum = new double[resultDistribut.size()];
                // 优秀数
                bestSum = new double[resultDistribut.size()];
                // 不及格数
                badSum = new double[resultDistribut.size()];
                // 结题数
                endSum = new double[resultDistribut.size()];
                // 延期数
                delaySum = new double[resultDistribut.size()];
                // 立项率
                proRate = new double[resultDistribut.size()];
                // 优秀率
                bestRate = new double[resultDistribut.size()];
                // 结题率
                endRate = new double[resultDistribut.size()];
                // 延期率
                delayRate = new double[resultDistribut.size()];
                for (int i = 0; i < resultDistribut.size(); ++i) {
                    labels[i] = resultDistribut.get(i).getCollegename();
                    decSum[i] = resultDistribut.get(i).getDecsum();
                    proSum[i] = resultDistribut.get(i).getProsum();
                    bestSum[i] = resultDistribut.get(i).getBestsum();
                    badSum[i] = resultDistribut.get(i).getBadsum();
                    endSum[i] = resultDistribut.get(i).getEndsum();
                    delaySum[i] = resultDistribut.get(i).getDelaysum();
                    proRate[i] = resultDistribut.get(i).getProrate() * 100;
                    bestRate[i] = resultDistribut.get(i).getBestrate() * 100;
                    endRate[i] = resultDistribut.get(i).getEndrate() * 100;
                    delayRate[i] = resultDistribut.get(i).getDelayrate() * 100;
                }

                HttpServletRequest request = ServletActionContext.getRequest();
                if (null != request.getSession().getAttribute("labels")) {
                    request.getSession().removeAttribute("labels");
                }
                if (null != request.getSession().getAttribute("decSum")) {
                    request.getSession().removeAttribute("decSum");
                }
                if (null != request.getSession().getAttribute("proSum")) {
                    request.getSession().removeAttribute("proSum");
                }
                if (null != request.getSession().getAttribute("bestSum")) {
                    request.getSession().removeAttribute("bestSum");
                }
                if (null != request.getSession().getAttribute("badSum")) {
                    request.getSession().removeAttribute("badSum");
                }
                if (null != request.getSession().getAttribute("endSum")) {
                    request.getSession().removeAttribute("endSum");
                }
                if (null != request.getSession().getAttribute("delaySum")) {
                    request.getSession().removeAttribute("delaySum");
                }
                if (null != request.getSession().getAttribute("proRate")) {
                    request.getSession().removeAttribute("proRate");
                }
                if (null != request.getSession().getAttribute("bestRate")) {
                    request.getSession().removeAttribute("bestRate");
                }
                if (null != request.getSession().getAttribute("endRate")) {
                    request.getSession().removeAttribute("endRate");
                }
                if (null != request.getSession().getAttribute("delayRate")) {
                    request.getSession().removeAttribute("delayRate");
                }

                request.getSession().setAttribute("labels", labels);
                request.getSession().setAttribute("decSum", decSum);
                request.getSession().setAttribute("proSum", proSum);
                request.getSession().setAttribute("bestSum", bestSum);
                request.getSession().setAttribute("badSum", badSum);
                request.getSession().setAttribute("endSum", endSum);
                request.getSession().setAttribute("delaySum", delaySum);
                request.getSession().setAttribute("proRate", proRate);
                request.getSession().setAttribute("bestRate", bestRate);
                request.getSession().setAttribute("endRate", endRate);
                request.getSession().setAttribute("delayRate", delayRate);

                // 获取当前届期信息
                //jieqi = this.statisticService.getJieqiById(jqQici);
                jqName = resultDistribut.get(0).getJqname();

                return SUCCESS;
            } else {
                return "noData";
            }
        } catch (Exception e) {
            return ERROR;
        }
    }


    // 按期次查看各学院数据指标
    @Action(value = "JiciResultDistribut", results = {
            @Result(name = "success", location = "/pages/StatisticsManage/linePages/symbolline.jsp"),
            @Result(name = "noData", location = "../noData_err.jsp")
    })
    public String collegeResultDistributByCollege() throws Exception {
        try {
            resultDistribut = this.statisticService.getSchoolStatisticDataByCollege(college);
            if (null != resultDistribut && resultDistribut.size() > 0) {
                // 标注 - 学院
                labels = new String[resultDistribut.size()];
                // 申报数
                decSum = new double[resultDistribut.size()];
                // 立项数
                proSum = new double[resultDistribut.size()];
                // 优秀数
                bestSum = new double[resultDistribut.size()];
                // 不及格数
                badSum = new double[resultDistribut.size()];
                // 结题数
                endSum = new double[resultDistribut.size()];
                // 延期数
                delaySum = new double[resultDistribut.size()];
                // 立项率
                proRate = new double[resultDistribut.size()];
                // 优秀率
                bestRate = new double[resultDistribut.size()];
                // 结题率
                endRate = new double[resultDistribut.size()];
                // 延期率
                delayRate = new double[resultDistribut.size()];
                for (int i = 0; i < resultDistribut.size(); ++i) {
                    labels[i] = resultDistribut.get(i).getJqname();
                    decSum[i] = resultDistribut.get(i).getDecsum();
                    proSum[i] = resultDistribut.get(i).getProsum();
                    bestSum[i] = resultDistribut.get(i).getBestsum();
                    badSum[i] = resultDistribut.get(i).getBadsum();
                    endSum[i] = resultDistribut.get(i).getEndsum();
                    delaySum[i] = resultDistribut.get(i).getDelaysum();
                    proRate[i] = resultDistribut.get(i).getProrate() * 100;
                    bestRate[i] = resultDistribut.get(i).getBestrate() * 100;
                    endRate[i] = resultDistribut.get(i).getEndrate() * 100;
                    delayRate[i] = resultDistribut.get(i).getDelayrate() * 100;
                }

                HttpServletRequest request = ServletActionContext.getRequest();
                if (null != request.getSession().getAttribute("labels")) {
                    request.getSession().removeAttribute("labels");
                }
                if (null != request.getSession().getAttribute("decSum")) {
                    request.getSession().removeAttribute("decSum");
                }
                if (null != request.getSession().getAttribute("proSum")) {
                    request.getSession().removeAttribute("proSum");
                }
                if (null != request.getSession().getAttribute("bestSum")) {
                    request.getSession().removeAttribute("bestSum");
                }
                if (null != request.getSession().getAttribute("badSum")) {
                    request.getSession().removeAttribute("badSum");
                }
                if (null != request.getSession().getAttribute("endSum")) {
                    request.getSession().removeAttribute("endSum");
                }
                if (null != request.getSession().getAttribute("delaySum")) {
                    request.getSession().removeAttribute("delaySum");
                }
                if (null != request.getSession().getAttribute("proRate")) {
                    request.getSession().removeAttribute("proRate");
                }
                if (null != request.getSession().getAttribute("bestRate")) {
                    request.getSession().removeAttribute("bestRate");
                }
                if (null != request.getSession().getAttribute("endRate")) {
                    request.getSession().removeAttribute("endRate");
                }
                if (null != request.getSession().getAttribute("delayRate")) {
                    request.getSession().removeAttribute("delayRate");
                }

                request.getSession().setAttribute("labels", labels);
                request.getSession().setAttribute("decSum", decSum);
                request.getSession().setAttribute("proSum", proSum);
                request.getSession().setAttribute("bestSum", bestSum);
                request.getSession().setAttribute("badSum", badSum);
                request.getSession().setAttribute("endSum", endSum);
                request.getSession().setAttribute("delaySum", delaySum);
                request.getSession().setAttribute("proRate", proRate);
                request.getSession().setAttribute("bestRate", bestRate);
                request.getSession().setAttribute("endRate", endRate);
                request.getSession().setAttribute("delayRate", delayRate);

                // 获取当前届期信息
                //jieqi = this.statisticService.getJieqiById(jqQici);
                collegeName = resultDistribut.get(0).getCollegename();

                return SUCCESS;
            } else {
                return "noData";
            }
        } catch (Exception e) {
            return ERROR;
        }
    }


    // 判断传入的学院参数是否合法
    @Action(value = "IsCollegeNameHadValue", results = {
            @Result(name = "success", type = "json", params = {"contentType", "text/html", "includeProperties", "result"}),
            @Result(name = "error", type = "json", params = {"contentType", "text/html", "includeProperties", "result"}),
            @Result(name = "noValue", type = "json", params = {"contentType", "text/html", "includeProperties", "result"})
    })
    public String isCollegeNameHadValue() throws Exception {
        try {
            if (null != college && !"".equals(college.trim())) {
                int count = this.statisticService.getCollegeCountByName(college);

                if (1 == count) {
                    result = "true";
                } else if (0 == count) {
                    result = "noValue";
                } else {
                    result = "false";
                }
                return SUCCESS;
            } else {
                result = "noValue";
                return "noValue";
            }
        } catch (Exception e) {
            result = "error";
            return ERROR;
        }
    }


    public StatisticService getStatisticService() {
        return statisticService;
    }

    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    public List getSchoolScoreList() {
        return schoolScoreList;
    }

    public void setSchoolScoreList(List schoolScoreList) {
        this.schoolScoreList = schoolScoreList;
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

    public DeclarationService getDeclarationService() {
        return declarationService;
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public Map<String, List<TJieqi>> getQicis() {
        return qicis;
    }

    public void setQicis(Map<String, List<TJieqi>> qicis) {
        this.qicis = qicis;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<JieQiYear> getJieQiYears() {
        return jieQiYears;
    }

    public void setJieQiYears(List<JieQiYear> jieQiYears) {
        this.jieQiYears = jieQiYears;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public double[] getDecSum() {
        return decSum;
    }

    public void setDecSum(double[] decSum) {
        this.decSum = decSum;
    }

    public double[] getProSum() {
        return proSum;
    }

    public void setProSum(double[] proSum) {
        this.proSum = proSum;
    }

    public double[] getBestSum() {
        return bestSum;
    }

    public void setBestSum(double[] bestSum) {
        this.bestSum = bestSum;
    }

    public double[] getBadSum() {
        return badSum;
    }

    public void setBadSum(double[] badSum) {
        this.badSum = badSum;
    }

    public double[] getEndSum() {
        return endSum;
    }

    public void setEndSum(double[] endSum) {
        this.endSum = endSum;
    }

    public double[] getDelaySum() {
        return delaySum;
    }

    public void setDelaySum(double[] delaySum) {
        this.delaySum = delaySum;
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

    public double[] getEndRate() {
        return endRate;
    }

    public void setEndRate(double[] endRate) {
        this.endRate = endRate;
    }

    public double[] getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(double[] delayRate) {
        this.delayRate = delayRate;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getJqName() {
        return jqName;
    }

    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TJieqi getJieqi() {
        return jieqi;
    }

    public void setJieqi(TJieqi jieqi) {
        this.jieqi = jieqi;
    }

}
