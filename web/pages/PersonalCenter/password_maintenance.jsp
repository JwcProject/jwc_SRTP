<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div id="container">
    <div id="maincontent" class="h645">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="88%" valign="top">
                    <!-- 公告区域-->
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" align="right">
                        <tr>
                            <td>
                                <div style="text-align: center;margin-left: auto;margin-right: auto;width: 75%;">
                                    <div>
                                        <h1 style="margin-top: 20px;">个人信息维护</h1>
                                    </div>
                                    <div class="info_box">
                                        <fieldset class="title">
                                            <legend class="f_head">基本信息</legend>
                                        </fieldset>
                                        <div style="display: block;margin-top: 10px;">
                                            <div class="line_box">
                                                <div class="line_box_left" align="right">姓名</div>
                                                <div class="line_box_right"><s:property
                                                        value="#session.user.username"/></div>
                                            </div>
                                            <div class="line_box">
                                                <div class="line_box_left" align="right">学号</div>
                                                <div class="line_box_right"><s:property
                                                        value="#session.user.userId"/></div>
                                            </div>
                                            <s:if test="%{#session.user.userType == '06' || #session.user.userType == '07' || #session.user.userType == '08'}">
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">学院</div>
                                                    <div class="line_box_right"><s:property
                                                            value="%{student.TUnit.unitName}"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">性别</div>
                                                    <div class="line_box_right"><s:if
                                                            test="%{student.studentSex == 01}">男</s:if><s:else>女</s:else></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">生日</div>
                                                    <div class="line_box_right"><s:date name="student.studentBirthday"
                                                                                        format="yyyy-MM-dd"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">邮箱</div>
                                                    <div class="line_box_right"><s:property
                                                            value="%{student.studentEmail}"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">电话</div>
                                                    <div class="line_box_right"><s:date name="student.studentTelphone"
                                                                                        format="yyyy-MM-dd"/></div>
                                                </div>
                                            </s:if>
                                            <s:else>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">学院</div>
                                                    <div class="line_box_right"><s:property
                                                            value="%{teacher.TUnit.unitName}"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">性别</div>
                                                    <div class="line_box_right"><s:if
                                                            test="%{teacher.teaSex == 01}">男</s:if><s:else>女</s:else></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">职称</div>
                                                    <div class="line_box_right"><s:property
                                                            value="%{teacher.teaTitle}"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">邮箱</div>
                                                    <div class="line_box_right"><s:property
                                                            value="%{teacher.teaEmail}"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">电话</div>
                                                    <div class="line_box_right"><s:property
                                                            value="teacher.teaTele"/></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">简介</div>
                                                    <div class="line_box_right"><s:property
                                                            value="teacher.teaIntro"/></div>
                                                </div>
                                            </s:else>
                                            <div style="clear: both;"></div>
                                        </div>
                                    </div>
                                    <div class="info_box">
                                        <fieldset class="title">
                                            <legend class="f_head">账号安全</legend>
                                        </fieldset>
                                        <form action="changePassword" id="changeForm">
                                            <input type="hidden" name="userId"
                                                   value="<s:property value="#session.user.userId"/>"/>

                                            <div style="display: block;margin-top: 10px;">
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">原密码</div>
                                                    <div class="line_box_right"><input type="password" name="password"/>
                                                    </div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">新密码</div>
                                                    <div class="line_box_right">
                                                        <input type="password" name="newPassword" class="inputxt"
                                                               plugin="passwordStrength" datatype="*6-18"
                                                               errormsg="密码至少6个字符,最多18个字符！"/>

                                                        <div class="passwordStrength">密码强度： <span>弱</span><span>中</span><span
                                                                class="last">强</span></div>
                                                    </div>
                                                    <div></div>
                                                </div>
                                                <div class="line_box">
                                                    <div class="line_box_left" align="right">重复密码</div>
                                                    <div class="line_box_right"><input type="password" name="rpassword"
                                                                                       class="inputxt"
                                                                                       recheck="newPassword"
                                                                                       datatype="*6-18"
                                                                                       errormsg="两次输入的密码不一致！"/></div>
                                                    <div></div>
                                                </div>
                                                <input type="submit" value="确认修改" style="margin-left: 100px;"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#Left_menu .menu_body:last").show();
        $("#changeForm").Validform({
            tiptype: 2,
            usePlugin: {
                passwordstrength: {
                    minLen: 6,
                    maxLen: 18
                }
            },
            ajaxPost: true,
            callback: function (data) {
                if (data == true) {
                    setTimeout(function () {
                        $.Hidemsg(); //公用方法关闭信息提示框;显示方法是$.Showmsg("message goes here.");
                        alert('修改成功');
                    }, 2000);
                }
                if (data == false) {
                    $.Hidemsg();
                    alert('输入的原密码错误');
                }
            }
        });
    });
</script>
