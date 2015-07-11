<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
        <s:form action="" theme="simple" id="listJieqi">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>


                    <!--中间区域-->
                    <td width="88%" valign="top"
                        style="padding-top:10px; padding-left:5px;"
                        style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">届期列表</div>
                            </div>


                            <div class="xia_list" style="margin-top: 35px">
                                <div class="xia_left">
                                    <table>
                                        <tr style="margin-left: -19px">
                                            <td><p>
                                                名称：
                                                <s:textfield name="jqName" id="proSerial"
                                                             style="width:70px;height:14px"/>
                                            </p></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            <td>
                                                <div class="douselect">
                                                    <p>
                                                        期次:
                                                        <s:doubleselect name="jqYear" list="years" id="jqYear"
                                                                        listKey="yearKey" listValue="yearValue"
                                                                        doubleList="qicis.get(top.yearKey)"
                                                                        doubleName="jqQici"
                                                                        doubleListKey="jqId" doubleListValue="qici"
                                                                        cssClass="select_sq" theme="simple"/>
                                                    </p>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="xia_right_sq" style="left: 45%;top: 90px">
                                                    <img src="<%=path%>/images/gonggaoweihu_icon1.gif" alt="查询"
                                                         onclick="query();"/>
                                                    <s:a href="PreAddJieqi">
                                                        <img src="<%=path%>/images/zhuanjia_anniu5.png" alt="创建新届期"/>
                                                    </s:a>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <table width="96%" border="0" cellspacing="0" cellpadding="0"
                                       style=" border-bottom:1px solid #dcdcdc; border-left:1px solid #dcdcdc;border-right:1px solid #dcdcdc;"
                                       align="left">

                                    <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;">
                                        <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                                        <s:hidden id="totalPages" name="totalPage"
                                                  value="%{totalPage}"></s:hidden>
                                        <td bgcolor="#FFFFFF" width="16%">|届期名称</td>
                                        <td bgcolor="#FFFFFF" width="3%">|年度</td>
                                        <td bgcolor="#FFFFFF" width="3%">|期次</td>
                                        <td bgcolor="#FFFFFF" width="7%">|申报开始时间</td>
                                        <td bgcolor="#FFFFFF" width="7%">|申报结束时间</td>
                                        <td bgcolor="#FFFFFF" width="7%">|中检开始时间</td>
                                        <td bgcolor="#FFFFFF" width="7%">|中检结束时间</td>
                                        <td bgcolor="#FFFFFF" width="7%">|结题开始时间</td>
                                        <td bgcolor="#FFFFFF" width="7%">|结题结束时间</td>
                                        <td bgcolor="#FFFFFF" width="5%">|申报状态</td>
                                        <td bgcolor="#FFFFFF" width="5%">|结题状态</td>
                                        <td bgcolor="#FFFFFF" width="13%">|操作</td>
                                    </tr>
                                    <s:iterator value="jieqis" id="jieqis" status="stuts">
                                        <s:if test="#stuts.odd == true">
                                            <tr
                                            style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                                        </s:if>
                                        <!--判断记号是否为偶数 -->
                                        <s:else>
                                            <tr
                                            style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                                        </s:else>
                                        <td><s:property value="#jieqis.jqName"/></td>
                                        <td align="center"><s:property value="#jieqis.jqYear"/></td>
                                        <td align="center"><s:property value="#jieqis.qici"/></td>
                                        <td><s:if
                                                test="null==#jieqis.startOn||#jieqis.startOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.startOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td><s:if
                                                test="null==#jieqis.endOn||#jieqis.endOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.endOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td><s:if
                                                test="null==#jieqis.zjStartOn||#jieqis.zjStartOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.zjStartOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td><s:if
                                                test="null==#jieqis.zjEndOn||#jieqis.zjEndOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.zjEndOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td><s:if
                                                test="null==#jieqis.jtStartOn||#jieqis.jtStartOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.jtStartOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td><s:if
                                                test="null==#jieqis.jtEndOn||#jieqis.jtEndOn.isEmpty()">
                                        </s:if> <s:else>
                                            <s:text name="global.format.date">
                                                <s:param value="#jieqis.jtEndOn"/>
                                            </s:text>
                                        </s:else></td>
                                        <td align="center"><s:if
                                                test="'01'==#jieqis.declarationState">
                                            开启
                                        </s:if> <s:else>
                                            关闭
                                        </s:else></td>
                                        <td align="center"><s:if
                                                test="'01'==#jieqis.endProjectState">
                                            开启
                                        </s:if> <s:else>
                                            关闭
                                        </s:else></td>
                                        <td bgcolor="#eef7ff">
                                                <%-- <s:a href="ViewDeclaration?id=%{#jieqis.declarId}">
                            <img src="images/shenbiaoliebiao_icon1.gif" alt="查看" />
                            </s:a> --%> <%-- <s:if test="%{#jieqis.checkState==01}"> --%> <%-- <s:if test="null==#jieqis.jtStartOn||#jieqis.jtStartOn.isEmpty()">
							<s:a href="PreUpdateJieqi?jieqiId=%{#jieqis.jqId}">
								<img src="images/tianjia.gif" alt="添加结题时间" />
							</s:a>
						</s:if> --%> <s:a href="PreUpdateJieqi?jieqiId=%{#jieqis.jqId}">
                                            <img src="<%=path%>/images/gonggaoweihu_icon3.gif" alt="编辑"/>
                                        </s:a> <s:a href="#" onclick="deleteJieqi('%{#jieqis.jqId}')">
                                            <img src="<%=path%>/images/gonggaoweihu_icon4.gif" alt="删除"/>
                                        </s:a> <%-- </s:if> --%>
                                        </td>
                                        </tr>
                                    </s:iterator>


                                </table>


                            </div>
                            <div class="xia_x">
                                <div id="pager"></div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>

        </s:form>

    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var page = $("#pages")[0].value;
        var totalPage = $("#totalPages")[0].value;
        //alert(page);
        //alert(totalPage);
        $("#pager").pager({
            pagenumber: page,
            pagecount: totalPage,
            buttonClickCallback: PageClick
        });
    });

    PageClick = function (pageclickednumber) {
        var totalPage = $("#totalPages")[0].value;
        $("#pager").pager({
            pagenumber: pageclickednumber,
            pagecount: totalPage,
            buttonClickCallback: PageClick
        });
        changePage(pageclickednumber);
    };

    function changePage(pageclickednumber) {
        var jqName = document.getElementsByName("jqName")[0].value;
        var t = document.getElementsByName("jqYear")[0];
        var s = document.getElementsByName("jqQici")[0];
        var jqYear = t.options[t.selectedIndex].value;
        var jqQici = s.options[t.selectedIndex].value;

        location = "ListAllJieqi?page=" + pageclickednumber + "&jqName=" + jqName + "&jqYear=" + jqYear + "&jqQici=" + jqQici;
    }
    function deleteJieqi(id) {
        $.messager.confirm('确认提示框', "确定删除？", function (r) {
            if (r) {
                location = "DeleteJieqi?jieqiId=" + id;
            }
        });
    }


    function query() {
        $("#pages")[0].value = 1;
        document.listJieqi.action = "<%=basePath%>ListAllJieqi";
        document.listJieqi.submit();
    }
</script>