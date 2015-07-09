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
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox">

                        <div class="xia_list">
                            <table width="88%" border="0" cellspacing="0" cellpadding="0"
                                   style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                                   align="left">

                                <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                    <td style="padding-left:10px" bgcolor="#FFFFFF" width="36%" class="NoNewline">
                                        |公告名称
                                    </td>
                                    <td bgcolor="#FFFFFF" width="15%">|发布日期</td>
                                    <td bgcolor="#FFFFFF" width="10%"> |发布人</td>
                                    <td bgcolor="#FFFFFF" width="25%"> |操作</td>

                                </tr>
                                <s:iterator value="listAnnouncement" id="listAnnouncementModels" status="stuts">
                                    <s:if test="#stuts.odd == true">
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                    </s:if>
                                    <!--判断记号是否为偶数 -->
                                    <s:else>
                                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                    </s:else>
                                    <td style="padding-left: 10px"
                                        title="<s:property value='#listAnnouncementModels.announTitle' />">
                                        &nbsp;
                                        <s:if
                                                test="%{#listAnnouncementModels.announTitle.length()>25}">
                                            <s:property
                                                    value="%{#listAnnouncementModels.announTitle.substring(0,25)+'...'}"
                                                    escape="#onlineList.frmTitle"/>
                                        </s:if>
                                        <s:else>
                                            <s:property value="#listAnnouncementModels.announTitle"/>
                                        </s:else>
                                    </td>
                                    <td>&nbsp;
                                        <s:if test="null==#listAnnouncementModels.publishTime||#listAnnouncementModels.publishTime.isEmpty()">

                                        </s:if>
                                        <s:else>
                                            <%--<s:text name="global.format.date">--%>
                                            <s:property value="#listAnnouncementModels.publishTime"/>
                                            <%--</s:text>--%>
                                        </s:else>
                                    </td>
                                    <td>&nbsp;<s:property value="#listAnnouncementModels.publisherName"/></td>
                                    <td>

                                        <s:a href="ViewAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                src="images/mid5.jpg" width="77" height="19"/></s:a>
                                        <s:a href="EditAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                src="images/gonggaoweihu_icon3.gif" width="77" height="19"/></s:a>
                                        <s:a href="DeleteAnnouncement?announId=%{#listAnnouncementModels.announId}"><img
                                                src="images/gonggaoweihu_icon4.gif" width="77" height="19"
                                                style="padding-left:7px;"/></s:a>

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

        var announTitle = $("#announTitle")[0].value;
        var publishTime = $("#publishTime")[0].value;
        sendGetAndSetAjax("findUnitAnnoun?page=" + pageclickednumber + "&announTitle=" + announTitle + "&publishTime=" + publishTime);

    }

    function queryUnitAnnoun() {
        //$("#pages")[0].value = 1;
        //alert("aaa");
        document.queryForm.action = "<%=basePath%>findUnitAnnoun";
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
