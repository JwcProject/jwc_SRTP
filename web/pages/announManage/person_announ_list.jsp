<%@ taglib uri="/struts-tags" prefix="s" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>个人公告</title>
    <link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css"/>


    <link href="<%=path%>/style/jquery.datepick.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div id="container">
    <!--  此处显示 id "maincontent" 的内容-->
    <div id="maincontent" class="h645">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>

                <!--中间区域-->
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div>
                        <div class="midbox_gg">
                            <div class="ggwh">公告维护</div>
                        </div>
                        <form action="" name="queryForm" id="queryForm" method="post">
                            <div class="xia_left">
                                <ul>
                                    <li>
                                        <p>公告名称：
                                            <s:textfield type="text" name="announTitle" id="announTitle"/>
                                        </p>
                                    </li>

                                    <li>
                                        <p>发布日期：

                                            <input type="text" name="publishTime" id="publishTime"
                                                   value="<s:date name="publishTime" format="yyyy-MM-dd"/>"
                                                   style="width:150px" class="easyui-datebox" editable="false"/>

                                        </p>
                                    </li>


                                    <li>
                                        <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                                    </li>
                                    <li>
                                        <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
                                    </li>

                                </ul>
                                <div class="xia_right" style="left:550px">
                                    <img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="queryPersonalAnnoun();"/>
                                    <!--  	<s:reset value="" style="background:url(images/mima_anniu2.gif); border:0px; width:103px; height:26px;"></s:reset>-->
                                    <!--<input type="button" value="" onclick="resetValue();" style="background:url(images/reset.png); border:0px; width:69px; height:29px;" />-->
                                    <a onclick="resetValue();"><img src="images/reset.png" alt="重置" "/></a>
                                </div>
                            </div>
                        </form>


                        <div class="xia_list">
                            <table width="88%" border="0" cellspacing="0" cellpadding="0"
                                   style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                                   align="left">

                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                    <td style="padding-left:10px" bgcolor="#FFFFFF" width="30%" class="NoNewline">
                                        |公告名称
                                    </td>
                                    <td bgcolor="#FFFFFF" width="10%"> |发布人</td>
                                    <td bgcolor="#FFFFFF" width="10%">|发布日期</td>
                                    <td bgcolor="#FFFFFF" width="10%"> |发布状态</td>
                                    <td bgcolor="#FFFFFF" width="40%"> |操作</td>

                                </tr>
                                <s:iterator value="listAnnouncement" id="listAnnouncementModels" status="stuts">
                                    <s:if test="#stuts.odd == true">
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                    </s:if>
                                    <!--判断记号是否为偶数 -->
                                    <s:else>
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                    </s:else>
                                    <td style="padding-left:10px"
                                        title="<s:property value='#listAnnouncementModels.announTitle' />">&nbsp;
                                        <s:if test="%{#listAnnouncementModels.announTitle.length()>20}">
                                            <s:property
                                                    value="%{#listAnnouncementModels.announTitle.substring(0,20)+'...'}"
                                                    escape="#onlineList.frmTitle"/>
                                        </s:if>
                                        <s:else>
                                            <s:property value="#listAnnouncementModels.announTitle"/>
                                        </s:else>
                                    </td>
                                    <td>&nbsp;<s:property value="#listAnnouncementModels.publisherName"/></td>

                                    <td>&nbsp;
                                        <s:if test="null==#listAnnouncementModels.publishTime||#listAnnouncementModels.publishTime.isEmpty()">

                                        </s:if>
                                        <s:else>
                                            <%--<s:text name="global.format.date">--%>
                                                <s:property value="#listAnnouncementModels.publishTime"/>
                                            <%--</s:text>--%>
                                        </s:else>
                                    </td>
                                    <td>&nbsp;
                                        <s:if test="#listAnnouncementModels.publishState=='Y '">
                                            已发布
                                        </s:if>
                                        <s:elseif test="#listAnnouncementModels.publishState=='N '">
                                            未发布
                                        </s:elseif>
                                    </td>
                                    <td>

                                        <s:a href="ViewAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                src="images/mid5.jpg" width="77" height="19"/></s:a>

                                        <s:a href="DeleteAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                src="images/gonggaoweihu_icon4.gif" width="77" height="19"
                                                style="padding-left:7px;"/></s:a>
                                        <s:if test="#listAnnouncementModels.publishState=='N '">
                                            <s:a href="EditAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                    src="images/gonggaoweihu_icon3.gif" width="77" height="19"
                                                    style="padding-left:7px;"/></s:a>
                                        </s:if>
                                        <s:if test="#listAnnouncementModels.publishState=='N '">
                                            <s:a href="CommitSavedAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                    src="images/commit.png" width="77" height="19"
                                                    style="padding-left:7px;"/></s:a>
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
    </div>
</div>

<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<script src="<%=path%>/js/jquery.pager.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/annoument.js"></script>
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

        var announTitle = $("#announTitle")[0].value;
        var publishTime = $("#publishTime").datebox("getValue");
        location = "findStuTeaAnnoun?page=" + pageclickednumber + "&publishTime=" + publishTime + "&announTitle=" + announTitle;

    }

    function queryPersonalAnnoun() {
        document.queryForm.action = "<%=basePath%>findStuTeaAnnoun";
        document.queryForm.submit();
    }

    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }

    function resetValue() {
        //alert(0);
        var inputs = document.queryForm.getElementsByTagName('input');
        for (var i in inputs) {
            inputs[i].value = "";
        }
    }
</script>
</body>
