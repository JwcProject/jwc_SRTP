<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<div id="container">
    <div id="maincontent" class="h645">
        <s:form action="" method="post" name="queyForm" id="queyForm"
                theme="simple">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                        style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">&nbsp;<s:property value="%{#session.unit.unitName}"/>SRTP项目列表</div>
                            </div>

                            <div id="declaraList" class="xia_list" style="margin-left: 15px;">
                                <table width="99%" border="0" cellspacing="0" cellpadding="0"
                                       style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                                       align="left">

                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td style="padding-left:10px" bgcolor="#FFFFFF" width="10%" class="NoNewline">
                                            |项目编号
                                        </td>
                                        <td bgcolor="#FFFFFF" width="20%"> |项目名称</td>
                                        <td bgcolor="#FFFFFF" width="8%"> |申报人</td>
                                        <td bgcolor="#FFFFFF" width="8%"> |学号</td>
                                        <td bgcolor="#FFFFFF" width="8%"> |专业</td>

                                        <td bgcolor="#FFFFFF" width="11%"> |操作</td>
                                    </tr>
                                    <s:iterator value="projectList" id="projectList" status="stuts">
                                        <s:if test="#stuts.odd == true">
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                        </s:if>
                                        <!--判断记号是否为偶数 -->
                                        <s:else>
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                        </s:else>
                                        <!-- <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                                        <td style="padding-left:10px" class="NoNewline"><s:property
                                                value="#projectList.projectNumber"/></td>
                                        <td>
                                            <s:if test="%{#projectList.projectName.length()>20}">
                                                <s:property value="%{#projectList.projectName.substring(0,20)+'...'}"
                                                            escape="#onlineList.frmTitle"/>
                                            </s:if>
                                            <s:else>
                                                <s:property value="#projectList.projectName"/>
                                            </s:else>
                                        </td>
                                        <td><s:property value="#projectList.TStudentByProjectLeader.studentName"/></td>
                                        <td><s:property
                                                value="#projectList.TStudentByProjectLeader.studentNumber"/></td>
                                        <td><s:property
                                                value="#projectList.TStudentByProjectLeader.TProfession.professionName"/></td>

                                        <td>
                                            <s:a href="ViewDeclaration?id=%{#projectList.TDeclaration.declarId}"
                                                    ><img src="<%=path%>/images/shenbiaoliebiao_icon1.gif"
                                                          alt="查看"/></s:a>
                                        </td>
                                        </tr>
                                    </s:iterator>


                                </table>
                            </div>
                            <div class="xia_x">

                                <div id="pager">
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </s:form>
    </div>
</div>
