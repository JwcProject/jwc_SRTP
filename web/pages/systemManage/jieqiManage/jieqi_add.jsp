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

        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <!--中间区域-->
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox">
                        <div class="midbox_gg">
                            <div class="sblb">新增届期</div>
                        </div>


                        <s:form theme="simple" id="addjieqi" name="addjieqi">
                            <div class="zj_tjjs_cj">
                                <table width="70%" height="200px" align="left" border="0" cellspacing="0"
                                       cellpadding="0" style=" padding-left:35px; padding-top:10px">
                                    <tr>
                                        <td width="50%" align="left">
                                            <p>名称：
                                                <input type="text" name="jieqi.jqName" id="jsxm"
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
                                                          name="jieqi.qici" id="qiciCombobox" width="165px"></s:select>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>申报状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <s:radio name="jieqi.declarationState" cssStyle="font-size:18px"
                                                         list="#{'00':'关闭','01':'开启'}" value="'00'"></s:radio>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>结题状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <s:radio name="jieqi.endProjectState" cssStyle="font-size:18px"
                                                         list="#{'00':'关闭','01':'开启'}" value="'00'"></s:radio>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>申报开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="startOn" name="jieqi.startOn"
                                                       class="easyui-datebox" editable="false" required="required"/>
                                            </p>
                                        </td>
                                        <td width="45%">
                                            <p>申报结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="endOn" name="jieqi.endOn" class="easyui-datebox"
                                                       required="required" editable="false"/>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>中检开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="zjStartOn" name="jieqi.zjStartOn"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>中检结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="zjEndOn" name="jieqi.zjEndOn"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50%">
                                            <p>结题开始时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="jtStartOn" name="jieqi.jtStartOn"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                        <td width="50%">
                                            <p>结题结束时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" id="jtEndOn" name="jieqi.jtEndOn"
                                                       class="easyui-datebox" required="required" editable="false"/>
                                            </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p>
                                                <a href="javascript:void(0);" onclick="addJieqi()"><img
                                                        src="<%=path%>/images/zhuanjia_anniu4.gif" alt="添加"/></a><span
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
    function save() {
        $('#addjieqi').form('submit', {
            url: '<%=basePath%>AddJieqi',
            onSubmit: function () {
                var isValid = $(this).form('validate');
                return isValid;	// return false will stop the form submission
            },
            success: function () {
                location.href = "<%=path%>/ListAllJieqi";
            }
        });

    }
    function addJieqi() {
        if (checkJieqi()) {
            var delState = $("input[name='jieqi.declarationState']:checked").val();//document.getElementById("delState").value;
            var endState = $("input[name='jieqi.endProjectState']:checked").val();//document.getElementById("endState").value;
            if (delState == "01" || endState == "01") {
                $.messager.confirm('确定提交', "开启新增届期的申报状态或者结题状态，上一个届期对应的状态将会被关闭", function (r) {
                    if (r) {
                        save();
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