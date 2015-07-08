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
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox">
                        <div class="midbox_gg">
                            <div class="sblb">角色基本信息</div>
                        </div>
                        <div class="ggzs_wz">
                            <p>角色名：<s:property value="role.roleName"/></p>

                            <p>角色状态：
                                <s:if test="role.roleState=='01'">激活</s:if>
                                <s:elseif test="role.roleState=='02'">未激活</s:elseif>
                                <s:else>错误代码</s:else>
                            </p>

                            <p>用户简介：<s:property value="role.roleIntroduction"/></p>
                        </div>
                        <div class="xia_anniu" style="margin-left:30px">
                            <ul>
                                <li><a href="#" onclick="window.opener=null;window.close(this);"><img
                                        src="<%=path%>/images/fabugonggao_anniu2.gif" alt="返回"/></a></li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
