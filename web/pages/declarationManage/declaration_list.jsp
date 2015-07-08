<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script src="<%=path%>/js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path%>/js/iepngfix_tilebg.js" type="text/javascript"></script>
<script src="<%=path%>/js/declaration.js" type="text/javascript"></script>

<div id="maincontent" class="h645">

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc"
                bordercolor="#f4f3f1">
                <div class="midbox">
                    <div class="midbox_gg">
                        <div class="sblb">个人项目申报列表</div>
                    </div>


                    <s:form action="" theme="simple" id="proForm">
                        <div class="xia_list" style="margin-top: 35px">

                            <table width="96%" border="0" cellspacing="0" cellpadding="0"
                                   style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                                   align="left">

                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">

                                    <td bgcolor="#FFFFFF" width="20%"> |项目名称</td>
                                    <td bgcolor="#FFFFFF" width="6%"> |所在学院</td>
                                    <td bgcolor="#FFFFFF" width="6%"> |申报人</td>
                                    <td bgcolor="#FFFFFF" width="6%"> |指导老师</td>
                                    <td bgcolor="#FFFFFF" width="6%"> |申报日期</td>
                                    <td bgcolor="#FFFFFF" width="6%"> |评审结果</td>
                                    <td bgcolor="#FFFFFF" width="26%"> |操作</td>
                                </tr>
                                <s:iterator value="listDeclaration" id="listDeclaration" status="stuts">
                                    <s:if test="#stuts.odd == true">
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                    </s:if>
                                    <!--判断记号是否为偶数 -->
                                    <s:else>
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                    </s:else>
                                    <td style="padding-left:10px"
                                        title="<s:property value='#listDeclaration.proName' />">
                                        <s:if test="%{#listDeclaration.proName.length()>20}">
                                            <s:property value="%{#listDeclaration.proName.substring(0,20)+'...'}"
                                                        escape="#onlineList.frmTitle"/>
                                        </s:if>
                                        <s:else>
                                            <s:property value="#listDeclaration.proName"/>
                                        </s:else>
                                    </td>
                                    <td><s:property value="#listDeclaration.TUnit.unitName"/>&nbsp; </td>
                                    <td><s:property value="#listDeclaration.TStudentByLeaderCode.studentName"/></td>
                                    <td><s:property value="#listDeclaration.TTeacherByTeacher1Code.teaName"/></td>
                                    <td>
                                        <s:if test="null==#listDeclaration.declTime||#listDeclaration.declTime.isEmpty()">

                                        </s:if>
                                        <s:else>
                                            <%--<s:text  format="global.format.date">--%>
                                            <s:date name="#listDeclaration.declTime" format="yyyy-MM-dd"/>
                                            <%--</s:text>--%>
                                        </s:else>
                                    </td>
                                    <td>
                                        <s:if test="#listDeclaration.reviewResult=='03'">
                                            已通过
                                        </s:if>
                                        <s:elseif test="#listDeclaration.reviewResult=='02'">
                                            未通过
                                        </s:elseif>
                                        <s:elseif test="#listDeclaration.reviewResult=='01'">
                                            待审核
                                        </s:elseif>
                                    </td>
                                    <td bgcolor="#eef7ff">

                                        <s:a href="ViewDeclaration?Id=%{#listDeclaration.declarId}">
                                            <img src="images/shenbiaoliebiao_icon1.gif" alt="查看"/>
                                        </s:a>
                                        <s:if test="%{#listDeclaration.checkState==01}">
                                            <s:a href="PreUpdateDeclaration?Id=%{#listDeclaration.declarId}">
                                                <img src="images/gonggaoweihu_icon3.gif" alt="编辑"/>
                                            </s:a>
                                            <s:a href="DeleteDeclaration?Id=%{#listDeclaration.declarId}">
                                                <img src="images/gonggaoweihu_icon4.gif" alt="删除"/>
                                            </s:a>
                                            <s:a href="CommitSavedDeclaration?Id=%{#listDeclaration.declarId}">
                                                <img src="images/tj.gif" alt="提交"/>
                                            </s:a>
                                        </s:if>
                                    </td>
                                    </tr>
                                </s:iterator>


                            </table>

                        </div>
                    </s:form>


                </div>
            </td>


        </tr>
    </table>

</div>

