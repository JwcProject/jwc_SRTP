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
            <table class="table table-striped table-bordered table-hover">
                <h3 class="header smaller lighter blue">系统日志列表</h3>
                <tr>
                    <td width="90%" valign="top" style="padding-top:10px; padding-left:5px;"
                        style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                        <div class="midbox">
                            <div class="xia_left">
                                <ul>
                                    <li>
                                        <p>登录名:
                                            <s:textfield name="userId" id="userId"/>
                                        </p>
                                    </li>

                                    <li>
                                        <p>昵称:
                                            <s:textfield name="username" id="username"/>
                                        </p>
                                    </li>

                                    <li>
                                        <p>登录IP:
                                            <s:textfield name="journalLoginip" id="journalLoginip"/>
                                        </p>
                                    </li>

                                    <li>
                                        <p>登录时间:
                                            <s:textfield cssClass="easyui-datebox" name="journalLogintime"
                                                         id="journalLogintime"/>
                                        </p>
                                    </li>

                                    <li>
                                        <p>退出时间:
                                            <s:textfield cssClass="easyui-datebox" name="journalQuitime"
                                                         id="journalQuitime"/>
                                        </p>
                                    </li>


                                    <li>
                                        <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                                    </li>
                                    <li>
                                        <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
                                    </li>
                                </ul>

                            </div>

                            <div class="xia_right_sq">
                                <img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"
                                     />
                                <a href="javascript:document.queyForm.reset();"><img src="<%=path%>/images/reset.png"
                                                                                     alt="重置"/></a>
                                <a href="ListJournalAct" target="_blank" style="margin-left:5px"><img
                                        src="<%=path%>/images/journalDetail.png" alt="日志明细 "/></a>

                            </div>

                            <div id="declaraList" class="xia_list">
                                <table class="table table-striped table-bordered table-hover">

                                    <tr>
                                        <td >用户登录名</td>
                                        <td>用户昵称</td>
                                        <td>登录IP</td>
                                        <td>登录时间</td>
                                        <td>退出时间</td>
                                    </tr>
                                    <s:iterator value="listJournals" id="listJournals" status="stuts">
                                        <s:if test="#stuts.odd == true">
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                        </s:if>
                                        <!--判断记号是否为偶数 -->
                                        <s:else>
                                            <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                        </s:else>
                                        <!-- <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">-->
                                        <td style="padding-left:10px" class="NoNewline"><s:property
                                                value="#listJournals.TUser.userId"/></td>
                                        <td><s:property value="#listJournals.username"/>&nbsp; </td>
                                        <td><s:property value="#listJournals.journalLoginip"/>&nbsp;</td>
                                        <td>
                                            <s:if test="null==#listJournals.journalLogintime||#listJournals.journalLogintime.isEmpty()">

                                            </s:if>
                                            <s:else>
                                                <s:text name="global.format.datetim">
                                                    <s:param value="#listJournals.journalLogintime"/>
                                                </s:text>
                                            </s:else>
                                        </td>
                                        <td>
                                            <s:if test="null==#listJournals.journalQuitime||#listJournals.journalQuitime.isEmpty()">

                                            </s:if>
                                            <s:else>
                                                <s:text name="global.format.datetim">
                                                    <s:param value="#listJournals.journalQuitime"/>
                                                </s:text>
                                            </s:else>
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
        var userId = $("#userId")[0].value;
        var username = $("#username")[0].value;
        var journalLoginip = $("#journalLoginip")[0].value;
        var journalLogintime = $("#journalLogintime")[0].value;
        var journalQuitime = $("#journalQuitime")[0].value;
        location = "ListSelectedJournal?page=" + pageclickednumber + "&userId=" + userId + "&username=" + username + "&journalLoginip=" + journalLoginip + "&journalLogintime=" + journalLogintime + "&journalQuitime=" + journalQuitime;
    }

    function query() {
        $("#pages")[0].value = 1;
        document.queyForm.action = "<%=basePath%>ListSelectedJournal";
        document.queyForm.submit();
    }


</script>
