﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
    <div id="maincontent" class="h645">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <!--中间区域-->
                <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
                    style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
                    <div class="midbox">
                        <div class="ggzs_wz">
                            <p style="text-align:center"><b>${announcementModel.announTitle}</b></p>
                            <!--  <p style="text-align:center"><b>“重庆大学大学生科研训练计划（SRTP）”项目的通知</b></p>-->
                            <p>发布时间：<s:date name="announcementModel.publishTime" format="yyyy年MM月dd日"/></p>

                            <p>发布人：<s:property value="announcementModel.publisherName"/></p>

                            <p>内容简介：</p>
                            <!--  <p>各学院：</p>-->
                            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="announcementModel.announContent"
                                                                               escape="false"/></p>

                            <p>附件：
                                <s:iterator value="attachments" id="attachment"><a
                                        href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property
                                        value="fileName"/></a>&nbsp;&nbsp;</s:iterator>
                            </p>

                        </div>
                        <div class="xia_anniu" style="margin-left: 30px;width:500px">
                            <ul>
                                <li><s:a href="UnpassedAnnouncement?announId=%{announcementModel.announId}"><img
                                        src="images/unpass.png" alt="审核不通过"/></s:a></li>
                                <li><s:a href="PassedAnnouncement?announId=%{announcementModel.announId}"><img
                                        src="images/pass.png" alt="审核通过"/></s:a></li>
                                <li><s:a href="EditAnnouncement?announId=%{announcementModel.announId}"><img
                                        src="images/edit1.png" alt="编辑"/></s:a></li>
                                <li><s:a href="#"><img src="images/return.png" alt="返回"/></s:a></li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
