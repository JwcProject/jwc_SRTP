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
            <table class="table-striped table-bordered table-hover">
                    <div class="header smaller lighter blue">&nbsp;<s:property value="%{#session.unit.unitName}"/>SRTP项目列表</div>
                <tr>
                    <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                        style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                        <div class="midbox">

                            <div class="xia_left">
                                <table>
                                    <tr style="margin-left: -19px">
                                        <td>
                                            <div class="douselect">
                                                <p>
                                                    期次:
                                                    <s:doubleselect name="jqYear" list="jieQiYears"
                                                                    id="jqYear" listKey="yearKey" listValue="yearValue"
                                                                    doubleList="qicis.get(top.yearKey)"
                                                                    doubleName="jqQici"
                                                                    doubleListKey="jqId" doubleListValue="qici"
                                                                    cssClass="select_sq" theme="simple"/>
                                                </p>
                                            </div>
                                        </td>

                                        <td>
                                            <p>
                                                项目名称:
                                                <s:textfield name="projectName" id="projectName"
                                                             style="width:98px;height:14px"/>
                                            </p>
                                        </td>

                                        <td>
                                            <p>
                                                学院名称:
                                                <s:textfield name="unitName" id="unitName"
                                                             style="width:98px;height:14px"/>
                                            </p>
                                        </td>

                                        <td>
                                            <p>
                                                学号:
                                                <s:textfield name="studentNums" id="studentNums"
                                                             style="width:98px;height:14px"/>
                                            </p>
                                        </td>


                                        <td>
                                            <s:hidden id="pages" name="page" value="%{page}"></s:hidden>

                                            <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
                                        </td>


                                        <td>
                                            <div class="xia_right_sq" style="left: 900px">
                                                <img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询"
                                                     onclick="query();"/>
                                                <a onclick="resetValue();"><img src="<%=path%>/images/reset.png"
                                                                                alt="重置"/></a>
                                            </div>
                                        </td>


                                    </tr>
                                </table>
                            </div>
                            <div id="declaraList" class="xia_list" style="margin-left: 15px;">
                                <table class="table-striped table-bordered table-hover">

                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <td>
                                            项目编号
                                        </td>
                                        <td>项目名称</td>
                                        <td>申报人</td>
                                        <td>学号</td>
                                        <td>学院</td>

                                        <td>操作</td>
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
                                        <td><s:property value="#projectList.TUnit.unitName"/></td>

                                        <td>
                                            <s:a href="ViewDeclaration?id=%{#projectList.TDeclaration.declarId}"
                                                    ><img src="images/shenbiaoliebiao_icon1.gif" alt="查看"/></s:a>
                                        </td>
                                        </tr>
                                    </s:iterator>


                                </table>
                            </div>
                        </div>
                    </td>


                </tr>
            </table>
        </s:form>
    </div>
</div>
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

        location = "FindSchoolProject?" + $('#queyForm').serialize();
    }

    function query() {
        $("#pages")[0].value = 1;
        document.queyForm.action = "<%=basePath%>FindSchoolProject";
        document.queyForm.submit();
    }
    function resetValue() {
        // alert(0);
        var inputs = document.queyForm.getElementsByTagName('input');
        for (var i in inputs) {
            inputs[i].value = "";
        }


    }

</script>
