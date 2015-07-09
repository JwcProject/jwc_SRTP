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
                    <s:form action="UpdateUser" name="inforForm" id="userForm" method="post">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">编辑用户基本信息</div>
                            </div>
                            <div class="ggzs_wz">


                                <table align="left" style="margin-left:30px">
                                    <tr>
                                        <td align="right" style="font-size: 18px">登录名:</td>
                                        <td align="left">
                                            <input type="text" name="user.userId" id="text_fabu"
                                                   value="<s:property value="user.userId" />"
                                                   style="width: 300px; font-size: 18px" datatype="*"
                                                   nullmsg="请输入登录名"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">昵称:</td>
                                        <td align="left">
                                            <input type="text" name="user.username" id="text_fabu"
                                                   value="<s:property value="user.username" />"
                                                   style="width: 300px;font-size: 18px" datatype="*"
                                                   nullmsg="请输入昵称"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">用户类型:</td>
                                        <td align="left">
                                            <s:select
                                                    list="#{'00':'教务处领导','01':'教务处主管教师','02':'学院领导','03':'学院主管教师','04':'评审教师','05':'普通教师','06':'普通学生','05':'项目成员','05':'项目组长'}"
                                                    name="user.userType" id="select"
                                                    cssStyle="width:300px;height:30px;font-size: 18px;color:rgb(89,89,89)"></s:select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td align="right" style="font-size: 18px">用户简介:</td>
                                        <td align="left">
                                            <s:textarea type="text" name="user.userIntroduction"
                                                        cssStyle="width: 300px;height:70px;font-size: 18px;resize:none;margin-left:10px;overflow-y:scroll;;color:rgb(89,89,89)"
                                                        datatype="*"
                                                        nullmsg="请输入用户简介"></s:textarea>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                </table>

                            </div>
                            <div class="xia_anniu" style="margin-left:130px;margin-top:230px">
                                <ul>
                                    <li><input type="image" name="submit" src="<%=path%>/images/mima_anniu1.gif"
                                               alt="提交"/></li>
                                    <!--  	<li><a href="javascript:document.inforForm.reset();"><img src="<%=path%>/images/mima_anniu2.gif" alt="取消" /></a></li>-->
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
