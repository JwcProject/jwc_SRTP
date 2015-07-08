<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<div id="container">

    <jsp:include page="../../../header.jsp"></jsp:include>
    <div id="maincontent" class="h645">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>

                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <s:form name="inforForm" id="userForm" method="post">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">分配权限</div>
                            </div>
                            <div class="ggzs_wz">

                                <table align="left" style="margin-left:30px">
                                    <tr>
                                        <td align="right" style="font-size: 18px">角色名：</td>
                                        <td align="left" style="font-size: 16px;color:rgb(89,89,89)">
                                            <s:hidden name="role.roleId" value="%{role.roleId}"></s:hidden>
                                            <s:property value="role.roleName"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px, width: 300px;">角色介绍：</td>
                                        <td align="left" style="font-size: 16px;color:rgb(89,89,89)">
                                            <s:property value="role.roleIntroduction"/>
                                        </td>
                                    </tr>
                                    <!-- <tr >
                                      <td align="right"><ul id="pertt"></ul></td>
                                    </tr> -->
                                </table>

                                <br><br><br>

                                <div>
                                    <ul id="pertt"></ul>
                                </div>

                            </div>
                            <div class="xia_anniu" style="margin-left:30px;margin-top:30px">
                                <ul>
                                    <li><a href="javascript:void(0);" onclick="setPerms()"><img
                                            src="<%=path%>/images/mima_anniu1.gif" alt="提交"/></a></li>
                                    <li><a href="#" target="_blank"><img src="<%=path%>/images/mima_anniu2.gif"
                                                                         alt="取消"/></a></li>

                                </ul>
                            </div>
                        </div>
                    </s:form>
                </td>

            </tr>
        </table>
    </div>
</div>

<script type="text/javascript">
    //var tree;
    $(function () {
        $('#pertt').tree({
            url: 'GetRolePermissons?id=${role.roleId}',
            checkbox: true
        });
    });

    function setPerms() {
        var listPermissionIds = "";
        var checkedNodes = $('#pertt').tree('getChecked', 'checked');
        for (var i in checkedNodes) {
            listPermissionIds += "&listPermissionIds=" + checkedNodes[i].id;
        }
        with (document.getElementById("userForm")) {
            method = "post";
            action = "AssignPermission?id=${role.roleId}" + listPermissionIds;
            submit();
        }
    }
</script>