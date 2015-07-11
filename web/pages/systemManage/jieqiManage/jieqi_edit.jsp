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
    <!--  此处显示 id "maincontent" 的内容-->
    <div id="maincontent" class="h645">

        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>


                <!--中间区域-->
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox">
                        <div class="midbox_gg">
                            <div class="sblb">编辑届期</div>
                        </div>


                        <s:form theme="simple" id="editjieqi" name="editjieqi">
                            <div class="zj_tjjs_cj">
                                <table width="60%" height="200px" align="left" border="0" cellspacing="0"
                                       cellpadding="0" style=" padding-left:35px; padding-top:10px">
                                    <tr>
                                        <td width="50%" align="left">
                                            <p>名称：

                                                <input type="text" name="jieqi.jqName"
                                                       value="<s:property value="jieqi.jqName"/>" id="jsxm"
                                                       class="easyui-validatebox"
                                                       data-options="required:true,validType:'length[1,25]'"/>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p style="float: left;">年度：
                                                <s:select list="years" listKey="yearKey" listValue="yearValue"
                                                          value="%{jieqi.jqYear}" name="jieqi.jqYear"
                                                          id="jqYearCombobox" width="165px"></s:select>
                                            </p>

                                            <p style="float: left;">期次：
                                                <s:select list="#{1:'1',2:'2',3:'3'}" listKey="key" listValue="value"
                                                          value="%{jieqi.qici}" name="jieqi.qici" id="qiciCombobox"
                                                          width="165px"></s:select>
                                            </p>
                                        </td>
                                        <!-- <td width="20%" align="left">

                                        </td>  -->
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>申报状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <s:radio id="declarationState" name="jieqi.declarationState"
                                                         cssStyle="font-size:18px" list="#{'00':'关闭','01':'开启'}"
                                                         value="%{jieqi.declarationState}"
                                                         onchange="recordDelState()"></s:radio>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>结题状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <s:radio id="endProjectState" name="jieqi.endProjectState"
                                                         cssStyle="font-size:18px" list="#{'00':'关闭','01':'开启'}"
                                                         value="%{jieqi.endProjectState}"
                                                         onchange="recordEndState()"></s:radio>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <s:hidden name="jieqi.jqId" value="%{jieqi.jqId}"></s:hidden>
                                            <s:hidden name="jieqi.secondaryAssessment"
                                                      value="%{jieqi.secondaryAssessment}"></s:hidden>
                                            <s:hidden name="jieqi.secondaryRespondent"
                                                      value="%{jieqi.secondaryRespondent}"></s:hidden>
                                            <s:hidden name="jieqi.isdeleted" value="%{jieqi.isdeleted}"></s:hidden>
                                            <p>申报开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="startOn" name="jieqi.startOn"
                                                       value="<s:date name="%{jieqi.startOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" editable="false" required="required"/>
                                            </p>
                                        </td>
                                        <td width="45%">
                                            <p>申报结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="endOn" name="jieqi.endOn"
                                                       value="<s:date name="%{jieqi.endOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" required="required" editable="false"/>

                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>中检开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="zjStartOn" name="jieqi.zjStartOn"
                                                       value="<s:date name="%{jieqi.zjStartOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>中检结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="zjEndOn" name="jieqi.zjEndOn"
                                                       value="<s:date name="%{jieqi.zjEndOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>结题开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="jtStartOn" name="jieqi.jtStartOn"
                                                       value="<s:date name="%{jieqi.jtStartOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>结题结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="jtEndOn" name="jieqi.jtEndOn"
                                                       value="<s:date name="%{jieqi.jtEndOn}" format="yyyy-MM-dd" />"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p>
                                                <a href="javascript:void(0);" onclick="saveJieqi()"><img
                                                        src="<%=path%>/images/save.png" alt="保存"/></a><span
                                                    id="msgdemo"></span>
                                            </p>
                                        </td>
                                    </tr>

                                </table>
                            </div>

                        </s:form>


                    </div>
                </td>
            </tr>
        </table>

    </div>
</div>
<script type="text/javascript">
    var isDelState = false;
    var isEndState = false;
    function recordDelState() {
        var delState = $("input[name='jieqi.declarationState']:checked").val();
        if (delState == '01') {
            isDelState = true;
        }
    }
    function recordEndState() {
        var endState = $("input[name='jieqi.endProjectState']:checked").val();
        if (endState == '01') {
            isEndState = true;
        }
    }
    $(function () {
        $("#editjieqi").Validform({
            tiptype: 4
        });
    });


    function redirectList() {
        location.href = "<%=path%>/ListAllJieqi";
    }
    function save() {
        $('#editjieqi').form('submit',
                {
                    url: 'UpdateJieqi',
                    dataType: 'html',
                    type: 'post',
                    success: function (result) {
                        var obj = JSON.parse(result);
                        if (obj.result == 'yes') {
                            $.messager.show({
                                title: '提示消息',
                                msg: '修改成功!',
                                timeout: 2500,
                                showType: 'slide'
                            });
                            setTimeout(redirectList, 3000);
                        }
                        else {
                            $.messager.show({
                                title: '提示消息',
                                msg: '修改失败，请重试或联系管理员!',
                                timeout: 2500,
                                showType: 'slide'
                            });
                        }
                    }
                });
    }
    function saveJieqi() {
        if (checkJieqi()) {
            if (isDelState && !isEndState) {
                $.messager.confirm('确定提交', "开启本届期的申报状态，上一届期申报状态将会被关闭", function (r) {
                    if (r) {
                        save();
                    }
                    else {
                        return;
                    }
                });
            }
            else if (isEndState && !isDelState) {
                $.messager.confirm('确定提交', "开启本届期的结题状态，上一届期结题状态将会被关闭", function (r) {
                    if (r) {
                        save();
                    }
                    else {
                        return;
                    }
                });
            }
            else if (isEndState && isDelState) {
                $.messager.confirm('确定提交', "开启本届期的申报和结题状态，上一届期申报和结题状态将会被关闭", function (r) {
                    if (r) {
                        save();
                    }
                    else {
                        return;
                    }
                });
            }
            else {
                save();
            }
        }
    }
    function checkJieqi() {
        var startOn = $('#startOn').datebox('getValue');
        var endOn = $('#endOn').datebox('getValue');
        var zjStartOn = $('#zjStartOn').datebox('getValue');
        var zjEndOn = $('#zjEndOn').datebox('getValue');
        var jtStartOn = $('#jtStartOn').datebox('getValue');
        var jtEndOn = $('#jtEndOn').datebox('getValue');
        if (endOn <= startOn) {
            alert("申报结束时间不能小于申报开始的时间");
            return false;
        }
        if (zjStartOn <= endOn) {
            alert("中检开始时间不能小于申报结束的时间");
            return false;
        }
        if (zjEndOn <= zjStartOn) {
            alert("中检结束时间不能小于中检开始的时间");
            return false;
        }
        if (jtStartOn <= zjEndOn) {
            alert("结题开始时间不能小于中检结束的时间");
            return false;
        }
        if (jtEndOn <= jtStartOn) {
            alert("结题结束时间不能小于结题开始的时间");
            return false;
        }
        return true;
    }

</script>