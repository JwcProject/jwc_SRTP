<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <!--中间区域-->
        <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc"
            bordercolor="#f4f3f1">
            <div class="midbox">
                <div class="midbox_gg">
                    <div class="ggwh">组队信息</div>
                </div>
                <form action="" name="queryForm" method="post">
                    <div class="xia_left">
                        <ul>
                            <li>
                                <p>公告名称：
                                    <s:textfield name="announTitle" id="announTitle"/>
                                </p>
                            </li>

                            <li>
                                <p>公告内容：
                                    <s:textfield name="announContent" id="announContent"/>
                                </p>
                            </li>

                            <li>
                                <p>发布日期：
                                    <input type="text" name="publishTime" id="publishTime"
                                           value="<s:date name="publishTime" format="yyyy-MM-dd"/>" style="width:150px"
                                           class="easyui-datebox" editable="false"/>

                                    <!--<s:textfield cssClass="easyui-datebox"  name="publishTime" id="publishTime" style="width:150px"/>-->
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
                </form>
                <div class="xia_right" style="left:780px">
                    <img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="queryUnitAnnoun();"/>
                    <a onclick="resetValue();"><img src="images/reset.png" alt="重置" "/></a>
                </div>

                <div class="xia_list">
                    <table width="88%" border="0" cellspacing="0" cellpadding="0"
                           style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                           align="left">

                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                            <td style="padding-left:10px" bgcolor="#FFFFFF" width="36%" class="NoNewline">|公告名称</td>
                            <td bgcolor="#FFFFFF" width="15%">|发布日期</td>

                            <td bgcolor="#FFFFFF" width="25%"> |操作</td>

                        </tr>
                        <s:iterator value="listAnnouncements" id="listAnnouncements" status="stuts">
                            <s:if test="#stuts.odd == true">
                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                            </s:if>
                            <!--判断记号是否为偶数 -->
                            <s:else>
                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                            </s:else>
                            <td style="padding-left: 10px"
                                title="<s:property value='#listAnnouncements.announTitle' />">
                                &nbsp;
                                <s:if
                                        test="%{#listAnnouncements.announTitle.length()>25}">
                                    <s:property
                                            value="%{#listAnnouncements.announTitle.substring(0,25)+'...'}"
                                            escape="#onlineList.frmTitle"/>
                                </s:if>
                                <s:else>
                                    <s:property value="#listAnnouncements.announTitle"/>
                                </s:else>
                            </td>
                            <td>&nbsp;
                                <s:if test="null==#listAnnouncements.publishTime||#listAnnouncements.publishTime.isEmpty()">

                                </s:if>
                                <s:else>
                                    <s:text name="global.format.date">
                                        <s:param value="#listAnnouncements.publishTime"/>
                                    </s:text>
                                </s:else>
                            </td>

                            <td>

                                <s:a href="ViewAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                        src="images/mid5.jpg" width="77" height="19"/></s:a>

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
<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        var page = $("#pages")[0].value;
        //alert(page);
        var totalPage = $("#totalPages")[0].value;
        //alert(totalPage);
        $("#pager").pager({pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick});
    });

    PageClick = function (pageclickednumber) {
        var totalPage = $("#totalPages")[0].value;
        $("#pager").pager({pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick});
        changePage(pageclickednumber);
    };

    function changePage(pageclickednumber) {

        var announContent = $("#announContent")[0].value;
        var announTitle = $("#announTitle")[0].value;
        var publishTime = $("#publishTime")[0].value;
        location = "findCommonAnnoun?page=" + pageclickednumber + "&announTitle=" + announTitle + "&announContent=" + announContent + "&publishTime=" + publishTime;

    }

    function queryUnitAnnoun() {
        //$("#pages")[0].value = 1;
        //alert("aaa");
        document.queryForm.action = "<%=basePath%>findCommonAnnoun";
        document.queryForm.submit();
    }


    function resetValue() {
        //alert(0);
        var inputs = document.queryForm.getElementsByTagName('input');
        for (var i in inputs) {
            inputs[i].value = "";
        }
    }
</script>
