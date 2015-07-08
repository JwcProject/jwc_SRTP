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
                <!--中间区域-->
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <s:form action="AddRole" name="inforForm" id="userForm" method="post" theme="simple">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">添加角色</div>
                            </div>
                            <div class="ggzs_wz">

                                <table align="left" style="margin-left:30px">
                                    <tr>
                                        <td align="right" style="font-size: 18px">角色名:</td>
                                        <td align="left">
                                            <input type="text" name="role.roleName" id="text_fabu"
                                                   style="width: 300px; font-size: 18px" datatype="*"
                                                   nullmsg="请输入角色名"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td align="right" style="font-size: 18px">角色简介:</td>
                                        <td align="left">
                                            <s:textarea name="role.roleIntroduction"
                                                        cssStyle="width: 300px;resize:none;margin-left:10px;overflow-y:scroll"
                                                        datatype="*"
                                                        nullmsg="请输入角色简介"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                </table>

                            </div>
                            <div class="xia_anniu" style="margin-left:130px">
                                <ul>
                                    <li><input type="image" name="submit" src="<%=path%>/images/mima_anniu1.gif"
                                               alt="提交"/></li>
                                    <!-- <li><a href="javascript:document.inforForm.reset();"><img src="images/mima_anniu2.gif" alt="取消" /></a></li>-->
                                    <li><input type="reset" value=""
                                               style="background:url(<%=path%>/images/mima_anniu2.gif); border:0px; width:103px; height:26px; "/>
                                    </li>
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

    $(function () {
        $('#userForm').Validform({
            tiptype: 2
        });
    });
</script>