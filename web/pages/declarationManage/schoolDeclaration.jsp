﻿<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

<div id="maincontent" class="h645">
    <s:form action="" method="post" name="queyForm"
            theme="simple">
        <table class="table table-striped table-bordered table-hover">
            <h3 class="header smaller lighter blue">全校SRTP项目申报列表</h3>
            <tr>
                <td>
                    <div>
                        <div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="douselect">
                                            <p>
                                                期次:
                                                <s:doubleselect name="jqYear" list="jieQiYears"
                                                                listKey="yearKey" listValue="yearValue"
                                                                doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
                                                                doubleListKey="jqId" doubleListValue="qici"
                                                                cssClass="select_sq" theme="simple"/>
                                            </p>
                                        </div>
                                    </td>

                                    <td>
                                        <p>
                                            项目名称:
                                            <s:textfield name="proName" id="proName"/>
                                        </p>
                                    </td>

                                    <td>
                                        <p>
                                            学院:
                                            <s:textfield name="college" id="college"></s:textfield>

                                        </p>
                                    </td>


                                    <td>
                                        <p>
                                            审核状态:
                                            <s:select
                                                    list='#{"ALL":"所有","05":"学院通过","04":"学院未通过","03":"已分派评审","02":"未分派评审","06":"提交教务处","07":"教务处未通过","09":"已立项"}'
                                                    name="checkState" id="checkState"></s:select>

                                        </p>
                                    </td>
                                    <td>
                                        <s:hidden id="pages" name="page" value="%{page}"></s:hidden>

                                        <s:hidden id="totalPages" name="totalPage"
                                                  value="%{totalPage}"></s:hidden>

                                    </td>
                                    <td>
                                        <div style="margin-left:10px;vertical-align: middle;">
                                            <img src="images/gonggaoweihu_icon1.gif" alt="查询"
                                                 onclick="query();"/>
                                            <a href="javascript:document.queyForm.reset();"><img
                                                    src="images/reset.png" alt="重置" "/>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="declaraList" class="xia_list">
                            <table class="table table-striped table-bordered table-hover">
                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                    <td >项目编号</td>
                                    <td>项目名称</td>
                                    <td>申报人</td>
                                    <td>学号</td>
                                    <td></td>
                                    <td>评审结果</td>
                                    <td>操作</td>
                                </tr>
                                <s:iterator value="declarations" id="declarations" status="stuts">
                                    <s:if test="#stuts.odd == true">
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                    </s:if>
                                    <!--判断记号是否为偶数 -->
                                    <s:else>
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                    </s:else>
                                    <!-- <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                                    <td style="padding-left:10px" class="NoNewline"><s:property
                                            value="#declarations.proSerial"/></td>
                                    <td title="<s:property value='#declarations.proName' />">
                                        <s:if test="%{#declarations.proName.length()>20}">
                                            <s:property value="%{#declarations.proName.substring(0,20)+'...'}"
                                                        escape="#onlineList.frmTitle"/>
                                        </s:if>
                                        <s:else>
                                            <s:property value="#declarations.proName"/>
                                        </s:else>
                                    </td>
                                    <td><s:property value="#declarations.TStudentByLeaderCode.studentName"/></td>
                                    <td><s:property value="#declarations.TStudentByLeaderCode.studentNumber"/></td>
                                    <td><s:property value="#declarations.TUnit.unitName"/></td>

                                    <td>
                                        <s:if test="#declarations.checkState=='05'">
                                            学院审核通过
                                        </s:if>
                                        <s:elseif test="#declarations.checkState=='04'">
                                            学院审核未通过
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='03'">
                                            已分派评审
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='02'">
                                            未分派评审
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='06'">
                                            提交教务处
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='07'">
                                            教务处未通过
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='08'">
                                            教务处通过
                                        </s:elseif>
                                        <s:elseif test="#declarations.checkState=='09'">
                                            已立项
                                        </s:elseif>
                                    </td>
                                    <td>
                                        <s:a href="ViewDeclaration?id=%{#declarations.declarId}"
                                                ><img src="images/shenbiaoliebiao_icon1.gif" alt="查看"/></s:a>
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
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
<script type="text/javascript" language="javascript">

    // var n = document.getElementById('pages').value;
    // var n = document.getElementsByTagName('s:hidden').value;
    //   alert(n);
    $(document).ready(function () {
        var page = $("#pages")[0].value;
        var totalPage = $("#totalPages")[0].value;
        //alert(page);
        //alert(totalPage);
        $("#pager").pager({pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick});
    });

    PageClick = function (pageclickednumber) {
        var totalPage = $("#totalPages")[0].value;
        $("#pager").pager({pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick});
        changePage(pageclickednumber);
    };


    function changePage(pageclickednumber) {
        var checkState = $("#checkState")[0].value;
        var proName = $("#proName")[0].value;
        var college = $("#college")[0].value;


        var t = document.getElementsByName("jqYear")[0];
        var s = document.getElementsByName("jqQici")[0];
        var jqYear = t.options[t.selectedIndex].value;
        var jqQici = s.options[t.selectedIndex].value;
        location = "FindSchoolDeclaration?page=" + pageclickednumber + "&checkState=" + checkState + "&proName=" + proName + "&college=" + college + "&jqYear=" + jqYear + "&jqQici=" + jqQici;
    }

    function query() {
        $("#pages")[0].value = 1;
        document.queyForm.action = "<%=path%>/FindSchoolDeclaration";
        postFormAndSetAjax($(document.queyForm));
    }


</script>
