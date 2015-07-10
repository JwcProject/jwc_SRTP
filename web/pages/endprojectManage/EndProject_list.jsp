<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table class="table table-striped table-bordered table-hover">
        <h3 class="header smaller lighter blue">结题列表查询</h3>
    <tr>

        <!--中间区域-->
        <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc"
            bordercolor="#f4f3f1">
            <div class="midbox">

                <s:form action="" name="searchEndProjectForm" id="searchEndProjectForm" method="post">
                    <div class="xia_left">
                        <ul>
                            <li>
                                <p class="qicis">年度、期次
                                    <s:doubleselect name="properties.year" list="allYears"
                                                    listKey="yearKey" listValue="yearValue"
                                                    doubleList="qicis.get(top.yearKey)" doubleName="properties.jieqiId"
                                                    doubleListKey="jqId" doubleListValue="qici"
                                                    cssClass="select_sq" theme="simple"/>
                                </p>
                            </li>

                            <s:if test="%{colleges.size()>0}">
                                <li>
                                    <p>学院<s:select cssClass="select_sq" list="colleges" listKey="unitId"
                                                   listValue="unitName" name="properties.unitId" theme="simple"
                                                   >
                                    </s:select>
                                    </p>
                                </li>
                            </s:if>
                            <s:if test="%{professions.size()>0}">
                                <li>
                                    <p>专业<s:select cssClass="select_sq" list="professions" listKey="professionId"
                                                   listValue="professionName" name="properties.professionId"
                                                   theme="simple"></s:select>

                                    </p>
                                </li>
                            </s:if>
                            <li>
                                <p>申报人学号
                                    <s:textfield name="properties.studentNumber"
                                                 theme="simple"/>
                                </p>
                            </li>
                            <li>
                                <p>项目名称
                                    <s:textfield name="properties.projectName" theme="simple"/>
                                </p>
                            </li>
                            <s:if test="%{user.userType =='01'}">
                                <li>

                                    <p>状态
                                        <s:select
                                                list='#{"0":"请选择--","01":"未处理","02":"未通过","03":"结题中","04":"教务处审核","05":"二次答辩","06":"已结题"}'
                                                name="properties.endprojectState" id="properties.endprojectState"
                                                theme="simple"></s:select>
                                    </p></li>
                            </s:if>
                            <li>

                                <p>成绩
                                    <s:select list='#{"0":"请选择--","01":"优秀","02":"良好","03":"中等","04":"及格","05":"不及格"}'
                                              name="properties.endprojectScore" id="properties.endprojectScore"
                                              theme="simple"></s:select>
                                </p></li>
                        </ul>
                    </div>

                    <div class="xia_right_sq">
                        <a href="javascript:void(0);" onclick="searchEndprojects();"><img
                                src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询"/></a></div>
                </s:form>
                <div class="xia_list">
                    <table class="table table-striped table-bordered table-hover">
                        <s:if test="%{user.userType =='00' || user.userType =='01'}">
                            <tr>
                                <td>项目编号</td>
                                <td>项目名称</td>
                                <td>申报人</td>
                                <td>学号</td>
                                <td>所属学院</td>
                                <td>专业</td>
                                <td>结题时间</td>
                                <td>期次</td>
                                <td>结题状态</td>
                                <td>成绩</td>
                                <td>二次评审成绩</td>
                                <td>操作</td>
                            </tr>
                            <s:iterator value="endProjects" id="endProject" status="st">
                                <%
                                    ValueStack vs= (ValueStack) request.getAttribute("struts.valueStack");
                                    out.println(vs);
                                %>
                                <s:if test="#st.odd">
                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td style="padding-left:10px" bgcolor="#eef7ff" class="NoNewline"><s:property
                                                value="#endProject.TProject.projectNumber"/></td>
                                        <td bgcolor="#eef7ff"
                                            title="<s:property value='#endProject.TProject.projectName'/>">
                                            <s:if test="%{#endProject.TProject.projectName.length()>15}">
                                                <s:property
                                                        value="#endProject.TProject.projectName.substring(0,15)+'...'"/>
                                            </s:if>
                                            <s:else>
                                                <s:property value="#endProject.TProject.projectName"/>
                                            </s:else>
                                        </td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentName"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentNumber"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TUnit.unitName"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.TProfession.professionName"/></td>
                                        <td bgcolor="#eef7ff"><s:date name="#endProject.unitTypeinTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TJieqi.jqYear"/>第<s:property
                                                value="#endProject.TJieqi.qici"/>期
                                        </td>
                                        <td bgcolor="#eef7ff">
                                            <s:if test="%{#endProject.endProjectState=='01'}">未处理</s:if>
                                            <s:elseif test="%{#endProject.endProjectState=='02'}">未通过</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='03'}">结题中</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='04'}">教务处审核</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='05'}">二次答辩</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='06'}">已结题</s:elseif>
                                        </td>
                                        <td bgcolor="#eef7ff">
                                            <s:if test="%{#endProject.endProjectScore=='01'}">优秀</s:if>
                                            <s:elseif test="%{#endProject.endProjectScore=='02'}">良好</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='03'}">中等</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='04'}">及格</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='05'}">不及格</s:elseif>
                                        </td>
                                        <td bgcolor="#eef7ff">
                                            <s:if test="%{#endProject.lastScore=='01'}">优秀</s:if>
                                            <s:elseif test="%{#endProject.lastScore=='02'}">良好</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='03'}">中等</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='04'}">及格</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='05'}">不及格</s:elseif>
                                        </td>
                                        <td bgcolor="#eef7ff"><img src="images/shenbiaoliebiao_icon1.gif" alt="查看"/>
                                        </td>
                                    </tr>
                                </s:if>
                                <s:else>
                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td style="padding-left:10px" bgcolor="#ffffff" class="NoNewline"><s:property
                                                value="#endProject.TProject.projectNumber"/></td>
                                        <td bgcolor="#FFFFFF"
                                            title="<s:property value='#endProject.TProject.projectName'/>">
                                            <s:if test="%{#endProject.TProject.projectName.length()>15}">
                                                <s:property
                                                        value="#endProject.TProject.projectName.substring(0,15)+'...'"/>
                                            </s:if>
                                            <s:else>
                                                <s:property value="#endProject.TProject.projectName"/>
                                            </s:else>
                                        </td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentName"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentNumber"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TUnit.unitName"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.TProfession.professionName"/></td>
                                        <td bgcolor="#FFFFFF"><s:date name="#endProject.unitTypeinTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TJieqi.jqYear"/>第<s:property
                                                value="#endProject.TJieqi.qici"/>期
                                        </td>
                                        <td bgcolor="#FFFFFF">
                                            <s:if test="%{#endProject.endProjectState=='01'}">未处理</s:if>
                                            <s:elseif test="%{#endProject.endProjectState=='02'}">未通过</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='03'}">结题中</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='04'}">教务处审核</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='05'}">二次答辩</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='06'}">已结题</s:elseif>
                                        </td>
                                        <td bgcolor="#FFFFFF">
                                            <s:if test="%{#endProject.endProjectScore=='01'}">优秀</s:if>
                                            <s:elseif test="%{#endProject.endProjectScore=='02'}">良好</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='03'}">中等</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='04'}">及格</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectScore=='05'}">不及格</s:elseif>
                                        </td>
                                        <td bgcolor="#FFFFFF">
                                            <s:if test="%{#endProject.lastScore=='01'}">优秀</s:if>
                                            <s:elseif test="%{#endProject.lastScore=='02'}">良好</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='03'}">中等</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='04'}">及格</s:elseif>
                                            <s:elseif test="%{#endProject.lastScore=='05'}">不及格</s:elseif>
                                        </td>
                                        <td bgcolor="#ffffff"><img src="images/shenbiaoliebiao_icon1.gif" alt="查看"/>
                                        </td>
                                    </tr>
                                </s:else>
                            </s:iterator>
                        </s:if>
                        <s:if test="%{user.userType =='02' || user.userType =='03'}">
                            <tr>
                                <td>项目编号</td>
                                <td> 项目名称</td>
                                <td> 申报人</td>
                                <td> 学号</td>
                                <td> 专业</td>
                                <td> 申请日期</td>
                                <td> 结题时间</td>
                                <td> 期次</td>
                                <td> 结题状态</td>
                                <td> 操作</td>
                            </tr>
                            <s:iterator value="endProjects" id="endProject" status="st">
                                <s:if test="#st.odd">
                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td style="padding-left:10px" bgcolor="#eef7ff" class="NoNewline"><s:property
                                                value="#endProject.TProject.projectNumber"/></td>
                                        <td bgcolor="#eef7ff"
                                            title="<s:property value='#endProject.TProject.projectName'/>">
                                            <s:if test="%{#endProject.TProject.projectName.length()>15}">
                                                <s:property
                                                        value="#endProject.TProject.projectName.substring(0,15)+'...'"/>
                                            </s:if>
                                            <s:else>
                                                <s:property value="#endProject.TProject.projectName"/>
                                            </s:else>
                                        </td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentName"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentNumber"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.TProfession.professionName"/></td>
                                        <td bgcolor="#eef7ff"><s:date name="#endProject.submitTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#eef7ff"><s:date name="#endProject.unitTypeinTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#eef7ff"><s:property
                                                value="#endProject.TJieqi.jqYear"/>第<s:property
                                                value="#endProject.TJieqi.qici"/>期
                                        </td>
                                        <td bgcolor="#eef7ff">
                                            <s:if test="%{#endProject.endProjectState=='01'}">未处理</s:if>
                                            <s:elseif test="%{#endProject.endProjectState=='02'}">未通过</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='03'}">结题中</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='04'}">教务处审核</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='05'}">二次答辩</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='06'}">已结题</s:elseif>
                                        </td>
                                        <td bgcolor="#eef7ff"><s:a
                                                href="EndProjectDetail?endprojectId=%{#endProject.endProjectId}"><img
                                                src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看"/></s:a></td>
                                    </tr>
                                </s:if>
                                <s:else>
                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td style="padding-left:10px" bgcolor="#FFFFFF" class="NoNewline"><s:property
                                                value="#endProject.TProject.projectNumber"/></td>
                                        <td bgcolor="#FFFFFF"
                                            title="<s:property value='#endProject.TProject.projectName'/>">
                                            <s:if test="%{#endProject.TProject.projectName.length()>15}">
                                                <s:property
                                                        value="#endProject.TProject.projectName.substring(0,15)+'...'"/>
                                            </s:if>
                                            <s:else>
                                                <s:property value="#endProject.TProject.projectName"/>
                                            </s:else>
                                        </td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentName"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.studentNumber"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TProject.TStudentByProjectLeader.TProfession.professionName"/></td>
                                        <td bgcolor="#FFFFFF"><s:date name="#endProject.submitTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#FFFFFF"><s:date name="#endProject.unitTypeinTime"
                                                                      format="yyyy-MM-dd"/></td>
                                        <td bgcolor="#FFFFFF"><s:property
                                                value="#endProject.TJieqi.jqYear"/>第<s:property
                                                value="#endProject.TJieqi.qici"/>期
                                        </td>
                                        <td bgcolor="#FFFFFF">
                                            <s:if test="%{#endProject.endProjectState=='01'}">未处理</s:if>
                                            <s:elseif test="%{#endProject.endProjectState=='02'}">未通过</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='03'}">结题中</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='04'}">教务处审核</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='05'}">二次答辩</s:elseif>
                                            <s:elseif test="%{#endProject.endProjectState=='06'}">已结题</s:elseif>
                                            <s:else>未知状态</s:else>
                                        </td>
                                        <td bgcolor="#eef7ff"><s:a
                                                href="EndProjectDetail?endprojectId=%{#endProject.endprojectId}"><img
                                                src="<%=path%>/images/shenbiaoliebiao_icon1.gif" alt="查看"/></s:a></td>
                                    </tr>
                                </s:else>
                            </s:iterator>
                        </s:if>
                    </table>
                </div>
                <div class="xia_x" id="pager">

                </div>
            </div>
        </td>


    </tr>
</table>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        $("#pager").pager({pagenumber: ${page}, pagecount: ${totalPage}, buttonClickCallback: PageClick});
    });

    PageClick = function (pageclickednumber) {
        $("#pager").pager({pagenumber: pageclickednumber, pagecount: ${totalPage}, buttonClickCallback: PageClick});
        changePage(pageclickednumber);
    };
    function searchEndprojects() {
        self.location = "listEndProjects?" + $('#searchEndProjectForm').serialize();
    }
    function changePage(pageclickednumber) {
        self.location = "listEndProjects?page=" + pageclickednumber + "&" + $('#searchEndProjectForm').serialize();
    }


</script>
