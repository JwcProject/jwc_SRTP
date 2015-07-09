<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript">
    function saveComment() {
      postFormAndSetAjax($('#opinionForm'));
    }
</script>
<div id="container">
    <div id="maincontent" class="h645">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="88%" valign="top">
                    <div class="cxCalendarHead" id="content">

                        <table class="cx_tablemain" border="1" bordercolor="#a9cfe2" cellpadding="3" cellspacing="0"
                               width="100%">
                            <tr>
                                <td class="cx_table">
                                    <div class="cx_title">项目申报表</div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" class="dbtitle">
                                    <div class="cx_title2">项目信息</div>
                                </td>
                            </tr>
                            <tr>
                                <td height="35">
                                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td width="33%" height="25">项目名称：<s:property
                                                    value="declaration.proName"/></td>
                                            <td width="34%" height="25">项目开展所在实验室：
                                                <s:if test="declaration.labLevel=='01'">校级实验室</s:if>
                                                <s:elseif test="declaration.labLevel=='02'">院级实验室</s:elseif>
                                                <s:elseif test="declaration.labLevel=='03'">其他实验室</s:elseif>
                                                <s:else> 错误代码</s:else></td>
                                        </tr>
                                        <tr>
                                            <td width="33%" height="25">实验室名称：<s:property
                                                    value="declaration.labName"/></td>
                                            <td width="33%" height="25">项目组人数：<s:property
                                                    value="declaration.memberAmount"/></td>
                                        </tr>
                                        <tr>
                                            <td height="25">项目实施时间：
                                                <s:date name="declaration.startOn" format="yyyy-MM-dd"/> 至 <s:date
                                                        name="declaration.endOn"
                                                        format="yyyy-MM-dd"/></td>
                                            <td height="25">项目所需经费：<s:property value="declaration.proFund"/>元</td>
                                            <td height="25">&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">项目级成员（含申请项目成员信息）：</td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">
                                                <table width="100%" border="1" align="center" cellpadding="3"
                                                       cellspacing="0"
                                                       bordercolor="#a9cfe2" class="dbtable">
                                                    <tr>
                                                        <th width="12%">姓名</th>
                                                        <th width="15%">学号</th>
                                                        <th width="22%">学院</th>
                                                        <th width="23%">联系电话</th>
                                                        <th width="28%">邮箱</th>
                                                    </tr>
                                                    <s:if test="%{declaration.TStudentByLeaderCode != null}">
                                                        <tr>
                                                            <td><s:property
                                                                    value="declaration.TStudentByLeaderCode.studentName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByLeaderCode.studentNumber"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByLeaderCode.TUnit.unitName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByLeaderCode.studentTelphone"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByLeaderCode.studentEmail"/></td>
                                                        </tr>
                                                    </s:if>
                                                    <s:if test="%{declaration.TStudentByMember1Code != null}">
                                                        <tr>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember1Code.studentName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember1Code.studentNumber"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember1Code.TUnit.unitName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember1Code.studentTelphone"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember1Code.studentEmail"/></td>
                                                        </tr>
                                                    </s:if>
                                                    <s:if test="%{declaration.TStudentByMember2Code != null}">
                                                        <tr>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember2Code.studentName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember2Code.studentNumber"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember2Code.TUnit.unitName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember2Code.studentTelphone"/></td>
                                                            <td><s:property
                                                                    value="declaration.TStudentByMember2Code.studentEmail"/></td>
                                                        </tr>
                                                    </s:if>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">指导教师：</td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">
                                                <table width="100%" border="1" align="center" cellpadding="3"
                                                       cellspacing="0"
                                                       bordercolor="#a9cfe2" class="dbtable">
                                                    <tr>
                                                        <th width="12%">姓名</th>
                                                        <th width="15%">职称</th>
                                                        <th width="22%">学院</th>
                                                        <th width="23%">联系电话</th>
                                                        <th width="28%">邮箱</th>
                                                    </tr>
                                                    <s:if test="%{declaration.TTeacherByTeacher1Code != null}">
                                                        <tr>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher1Code.teaName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher1Code.teaCode"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher1Code.TUnit.unitName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher1Code.teaTele"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher1Code.teaEmail"/></td>
                                                        </tr>
                                                    </s:if>
                                                    <s:if test="%{declaration.TTeacherByTeacher2Code != null}">
                                                        <tr>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher2Code.teaName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher2Code.teaCode"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher2Code.TUnit.unitName"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher2Code.teaTele"/></td>
                                                            <td><s:property
                                                                    value="declaration.TTeacherByTeacher2Code.teaEmail"/></td>
                                                        </tr>
                                                    </s:if>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">
                                                <dl class="artTabs">
                                                    <dt id="tabs"><a href="#tabContent1" class="select">项目简介</a> <a
                                                            href="#tabContent2">创新点</a> <a
                                                            href="#tabContent3">研究成果</a></dt>
                                                    <dd id="tabContent1" style="display:block"><s:property
                                                            value="declaration.proIntro"/></dd>
                                                    <dd id="tabContent2"><s:property
                                                            value="declaration.innoPoint"/></dd>
                                                    <dd id="tabContent3" style="display:none"><s:property
                                                            value="declaration.expResult"/></dd>
                                                    <!--<dd id="tabContent4" style="display:none">
                	<s:iterator value="attachments" id="attachment">
                	<a href="downLoadAttachment?attachementId=<s:property value="attaId" />">
                	<s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
                </dd>  -->
                                                </dl>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td height="25" colspan="3">相关附件：<a href="#" style="color:#06C">
                                                <s:iterator value="attachments" id="attachment">
                                                    <a href="downLoadAttachment?attachementId=<s:property value="attaId" />">
                                                        <s:property value="fileName"/></a>&nbsp;&nbsp;</s:iterator>
                                            </a></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" class="dbtitle">
                                    <div class="cx_title2">网评结果</div>
                                </td>
                            </tr>
                            <tr>
                                <td height="35">
                                    <div>
                                        <form id="opinionForm" action="AddComments" method="post">
                                            <input type="hidden" name="declarId"
                                                   value="<s:property value="declaration.declarId" />"/>
                                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tr>
                                                    <td height="30">网评意见：</td>
                                                </tr>
                                                <tr>
                                                    <td height="30"><textarea name="declComment.declArgument" cols="80"
                                                                              rows="6" id="textfield2"
                                                                              style="border:1px solid #CCC;"
                                                                              datatype="*" sucmsg="验证通过"
                                                                              nullmsg="请输入网评意见"
                                                                              errormsg="请正确输入"></textarea></td>
                                                </tr>
                                                <tr>
                                                    <td height="30">综合评定：
                                                        <select name="declComment.compEval" id="select"
                                                                class="cxselect">
                                                            <option value="02">-建议立项-</option>
                                                            <option value="01">-不建议立项-</option>
                                                        </select>
                                                        　评分
                                                        <input name="declComment.declScore" id="declComment.declScore"
                                                               size="10" class="cxinput"
                                                               type="text"
                                                               datatype="n1-3" sucmsg="验证通过" nullmsg="请输入分数"
                                                               errormsg="请正确输入">
                                                        %　　<span style="color:#F33">（优秀：90-100；良好：80-90；中等：70-80；及格：60-70；不及格：60以下）</span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td height="30"><a href="javascript:void(0);"
                                                                       onclick="saveComment();"><img
                                                            src="images/tijiaowanping.png" height="22" width="86"></a>
                                                        <a href="javascript:void(0);" onclick="history.go(-1);"><img
                                                                src="images//quxiao.png"
                                                                height="22" width="86"></a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </table>

                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>


<script>
    var artTabs = function (bar, config) {
        var gid = function (id) {
            return document.getElementById(id)
        };

        config = config || {};
        var bar = typeof bar === 'string' ? gid(bar) : bar,
                className = config.className || 'select',
                callback = config.callback || function () {
                        },
                isMouseover = config.isMouseover,

                buttons = bar.getElementsByTagName('a'),
                selectButton = buttons[
                config.index ||
                function () {
                    var ret = 0;
                    for (i = 0; i < buttons.length; i++) {
                        if (buttons[i].className === className) ret = i;
                    }
                    ;
                    return ret;
                }()
                        ],
                showContent = gid(selectButton.href.split('#')[1]),
                fn = function (event) {
                    event = event || window.event;
                    var target = event.target || event.srcElement;

                    if (target.nodeName.toLowerCase() === 'a') {
                        showContent.style.display = 'none';
                        showContent = gid(target.href.split('#')[1]);
                        showContent.style.display = 'block';
                        selectButton.className = '';
                        selectButton = target;
                        target.className = className;
                        target.focus();
                        callback(selectButton, showContent);
                        return false;
                    }
                    ;
                };

        if (isMouseover) bar.onmouseover = fn;
        bar.onclick = fn;// click事件至少能保证手持设备可以使用
    };

    // 给jQuery添加插件
    jQuery.fn.artTabs = function (config) {
        return this.each(function () {
            artTabs(this, config);
        });
    };

    jQuery('.artTabs > dt').artTabs();
</script>
<script type="text/javascript">
    $(function () {
        $("#opinionForm").Validform({
            tiptype: 3
        });
    });
</script>
