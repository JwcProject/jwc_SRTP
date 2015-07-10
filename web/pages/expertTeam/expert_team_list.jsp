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
        <s:form action="" method="post" name="queyForm"
                theme="simple">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <h3 class="header smaller lighter blue">&nbsp;<s:property value="%{#session.unit.unitName}"/>专家团队列表</h3>
                <tr>
                    <!--中间区域-->
                    <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                        style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                        <div class="midbox">

                            <div class="xia_left">
                                <table>
                                    <ul>
                                        <li>
                                            <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                                        </li>
                                        <li>
                                            <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
                                        </li>
                                    </ul>
                                </table>
                            </div>

                            <div id="declaraList" class="xia_list" style="margin-top: 25px;">
                                <div style="margin-left: 840px;margin-bottom: 20px">
                                    <s:a href="PreCreateExpert"><img src="<%=path%>/images/zhuanjia_anniu5.png"
                                                                     alt="创建"/></s:a>
                                </div>
                                <table class="table table-striped table-bordered table-hover">

                                    <tr>
                                        <td>期次</td>
                                        <td>创建人</td>
                                        <td>创建日期</td>
                                        <td>是否分派</td>
                                        <td>操作</td>
                                    </tr>
                                    <s:iterator value="expertLibs" id="expertLib" status="stuts">
                                        <s:if test="#stuts.odd == true">
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                        </s:if>
                                        <!--判断记号是否为偶数 -->
                                        <s:else>
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                        </s:else>
                                        <!-- <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                                        <td><s:property
                                                value="#expertLib.TJieqi.jqYear+'年,第'"/>
                                            <s:property
                                                    value="#expertLib.TJieqi.qici+'期'"/>
                                        </td>
                                        <td><s:property value="#expertLib.TTeacher.teaName"/>&nbsp;&nbsp; </td>
                                        <td>
                                            <s:if test="null==#expertLib.creatOn||#expertLib.creatOn.isEmpty()">

                                            </s:if>
                                            <s:else>
                                                &nbsp;
                                                <s:property value="#expertLib.creatOn"/>

                                            </s:else>
                                        </td>
                                        <td><s:if test="#expertLib.isAssigned=='01'">
                                            &nbsp;已分派
                                        </s:if>
                                            <s:else>
                                                &nbsp;未分派
                                            </s:else>
                                        </td>

                                        <td>
                                            <s:a href="ViewExpTea?expLibId=%{#expertLib.libId}"><img
                                                    src="images/shenbiaoliebiao_icon1.gif" alt="查看"/></s:a>

                                            <s:a href="PreUpdateExpTea?expLibId=%{#expertLib.libId}">
                                                <img src="images/gonggaoweihu_icon3.gif" alt="编辑"/>
                                            </s:a>
                                            <s:a href="DeleteExpertLib?expLibId=%{#expertLib.libId}">
                                                <img src="images/gonggaoweihu_icon4.gif" alt="删除"/>
                                            </s:a>
                                            <s:if test="#expertLib.isAssigned=='N '">
                                                <s:a href="PreAssignExpert">
                                                    <img src="images/assign.png" alt="分派"/></s:a>
                                            </s:if>
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
<script type="text/javascript" language="javascript">
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

        sendGetAndSetAjax( "ListUnitExperTeam?page=" + pageclickednumber);
    }
</script>