<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
%>

<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>

<div id="maincontent" class="h645">
    <s:form action="/sendEmail" method="post" name="queyForm" id="emailForm">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="88%" valign="top"
                    style="padding-top: 10px; padding-left: 5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox" id="midbox">

                        <div class="midbox_gg">
                            <div class="zzps">
                                组织评审
                            </div>
                        </div>

                        <table style="font-size: 16px">
                            <tr style="height:30px"></tr>
                            <tr>
                                <td style="width:100px" align="right">
                                    邮件主题:
                                </td>
                                <td>
                                    <input type="text" name="mailInfo.subject" id="text_fabu" datatype="*"
                                           nullmsg="请输入邮件主题"/>
                                </td>
                                <td>
											<span class="Validform_checktip" id="checkSpan">
											</span>
                                </td>
                            </tr>

                            <tr style="height:15px">
                                <td align="right">
                                    年份和期次:
                                </td>
                                <td>
                                    <p>

                                    <div class="douselect" style="margin-left:10px">
                                        <s:doubleselect label="请选择年份和期次" name="mailInfo.jieqiYear"
                                                        list="jieQiYears" listKey="yearKey" listValue="yearValue"
                                                        doubleList="qicis.get(top.yearKey)"
                                                        doubleName="mailInfo.jieqiId"
                                                        doubleListKey="jqId" doubleListValue="qici"
                                                        cssClass="select_sq" theme="simple"/>
                                    </div>
                                    </p>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    收件人:
                                </td>
                                <td>
                                    <input type="text" name="mailInfo.toAddress" id="text_fabu" datatype="*"
                                           nullmsg="请输入收件人邮箱"/>
                                </td>
                                <td>
											<span class="Validform_checktip" id="checkSpan">
											</span>
                                </td>
                            </tr>


                            <tr style="height:15px"></tr>
                            <tr>
                                <td align="right">
                                    邮件内容:
                                </td>
                                <td>
								   	 	<textarea name="mailInfo.content" id="textfield12"
                                                  style="overflow-y:scroll;width:513px;height:250px;resize:none;margin-left:10px;background-color:#ffffff"
                                                  datatype="*" nullmsg="请输入邮件内容"></textarea>
                                </td>
                                <td>
								   	 	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>

                                </td>

                            </tr>
                            <tr style="height:15px"></tr>
                            <tr>
                                <td align="right">
                                    发送邮箱:
                                </td>
                                <td>
                                    <input type="text" name="mailInfo.fromAddress" id="text_fabu" datatype="e"
                                           nullmsg="请输入邮箱" errormsg="请输入 正确的邮箱地址" value="1191482087@qq.com"/>
                                </td>
                                <td>
								   	 	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>

                                </td>
                            </tr>


                            <tr style="height:15px"></tr>

                            <tr>
                                <td align="right">
                                    邮箱密码:
                                </td>
                                <td>
                                    <input type="password" name="mailInfo.password" id="text_fabu" datatype="*"
                                           nullmsg="请输入邮箱密码" value="zkq.2015"/>
                                </td>
                                <td>
                                      	
											<span class="Validform_checktip" id="checkSpan">
												
											</span>

                                </td>
                            </tr>

                        </table>
                        <br/>
                        <br/>

                        <div class="xia_anniu">
                            <ul>
                                <li>
                                    <input name="submit" type="image" value=" " src="images/pinshen_biao2.gif"/>
                                </li>
                                <li>
                                    <a href="javascript:document.queyForm.reset();"><img
                                            src="images/pinshen_biao3.gif" alt="取消"/>
                                    </a>
                                </li>
                            </ul>
                        </div>


                    </div>
                </td>

            </tr>
        </table>
    </s:form>
</div>
<script src="<%=path%>/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path%>/js/declaration.js"></script>
<script type="text/javascript">
    $(function () {
        $('#emailForm').Validform({
            tiptype: 2
        });
    });
</script>
