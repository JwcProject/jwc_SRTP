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
                    <s:form action="UpdatePermission" name="inforForm" id="userForm" method="post">
                        <div class="midbox">
                            <div class="midbox_gg">
                                <div class="sblb">编辑角色信息</div>
                            </div>
                            <div class="ggzs_wz">
                                <table align="left" style="margin-left:30px">
                                    <tr>
                                        <td align="right" style="font-size: 18px">权限名:</td>
                                        <td align="left" style="font-size: 16px;color:rgb(89,89,89)">
                                            <s:hidden name="permission.permissionId"
                                                      value="%{permission.permissionId}"></s:hidden>
                                            <s:hidden name="permission.isdeleted"
                                                      value="%{permission.isdeleted}"></s:hidden>
                                            <input type="text" name="permission.permissionName" id="text_fabu"
                                                   value="<s:property value="permission.permissionName" />"
                                                   style="width: 300px;font-size: 18px" datatype="*"
                                                   nullmsg="请输入角色名"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">权限 状态:</td>
                                        <td align="left">

                                            <s:radio list='#{"01":"已分配 ","02":"未分配"}'
                                                     name="permission.permissionState"
                                                     value="%{permission.permissionState}" id="select"
                                                     cssStyle="font-size: 18px;color:rgb(89,89,89)"></s:radio>
                                        </td>

                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">权限URL:</td>
                                        <td align="left">
                                            <input type="text" name="permission.permissionUrl" id="text_fabu"
                                                   value="<s:property value="permission.permissionUrl" />"
                                                   style="width: 300px;font-size: 18px" datatype="*"
                                                   nullmsg="请输入角色名"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">权限层级:</td>
                                        <td align="left">
                                            <s:select list='#{"0 ":"0","1 ":"1","2 ":"2"}'
                                                      name="permission.permissionLevel" id="select"
                                                      cssStyle="width:300px;height:30px;font-size: 18px;color:rgb(89,89,89)"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right" style="font-size: 18px">父权限：</td>
                                        <td align="left">
                                            <s:textfield name="permission.permissionFatherid" id="permissionFatherid"
                                                         value="%{permission.permissionFatherid}"
                                                         style="width: 300px;font-size: 18px" datatype="*"
                                                         nullmsg="请输入角色名"/>
                                        </td>
                                        <td>
                                            <span class="Validform_checktip" id="checkSpan"></span>
                                        </td>
                                    </tr>


                                    <tr>
                                        <td align="right" style="font-size: 18px">权限描述:</td>
                                        <td align="left">
                                            <s:textarea type="text" name="permission.permissionIntroduction"
                                                        cssStyle="width: 300px;height:70px;font-size: 18px;resize:none;margin-left:10px;overflow-y:scroll;color:rgb(89,89,89)"
                                                        datatype="*"
                                                        nullmsg="请输入角色 简介"></s:textarea>
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
                                    <!--  <li><a href="javascript:document.inforForm.reset();" ><img src="images/mima_anniu2.gif" alt="取消" /></a></li>-->
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

        $('#permissionFatherid').combotree({
            url: 'findFatherPermsTree?curFatherPermsId=${permission.permissionFatherid}',
            loadFilter: function (data) {
                if (data.fathPermsTree) {
                    return data.fathPermsTree;
                } else {
                    return data;
                }
            },
            checkbox: true,
            lines: true
        });
    });


</script>