<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<script type="text/javascript">
    $(function () {
        $("input:file").MultiFile({
            accept: 'doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls',
            max: 5,
            STRING: {
                remove: '删除',
                selected: 'Selecionado: $file',
                denied: '不支持该类型文件上传, $ext!',
                duplicate: '该文件已经选择:\n$file!'
            }
        });
    });

</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <!--中间区域-->
        <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;"
            style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
            <form id="announcement" name="announcement" action="UpdateAnnouncement" method="post"
                  enctype="multipart/form-data">
                <div class="midbox">
                    <div class="ggzs_wz">
                        <input type="hidden" name="announId"
                               value="<s:property value="%{announcement.announId}"/>"/>

                        <div>
                            <p style="float:left">公告名称 ：
                                <input type="text" name="announTitle" id="text_fabu"
                                       value="<s:property value="%{announcement.announTitle}"/>"
                                       style="width: 300px;" datatype="*"
                                       nullmsg="请输入公告名称"/>

                            </p>

                            <p style="float:left;">
		                        <span class="Validform_checktip" id="checkSpan"></span>
                            </p>
                        </div>


                        <!--  <p style="text-align:center"><b>“重庆大学大学生科研训练计划（SRTP）”项目的通知</b></p>-->
                        <div>
                            <p style="float:left">内容简介：
                                <!--  <p>各学院：</p>-->
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="announContent" id="myEditor"
                                                                              datatype="*"
                                                                              nullmsg="请输入内容简介"><s:property
                                        value="%{announcement.announContent}"/></textarea>
                            </p>

                            <p style="float:left;  padding-top: 170px">
                                <span class="Validform_checktip" id="checkSpan">

                                </span>
                            </p>
                        </div>
                        <script type="text/javascript">
                            var editor = new UE.ui.Editor();
                            editor.render("myEditor");
                        </script>
                        <p style="clear:left">附件：
                            <s:iterator value="attachments" id="attachment"><a
                                    href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property
                                    value="fileName"/></a>&nbsp;&nbsp;</s:iterator>
                        </p>
                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name="files"/><label style="color: red;">*
                        如需修改附件请重新上传所有附件</label>(支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5)
                    </div>

                    <div class="xia_anniu" style="margin-left:30px">
                        <ul>
                            <li>
                                <input name="submit" type="image" value=" " src="images/mima_anniu1.gif"
                                       alt="保存"/>
                            </li>
                            <li><a href="javascript:document.announcement.reset();"><img
                                    src="images/mima_anniu2.gif" alt="取消"/></a></li>
                        </ul>
                    </div>
                </div>
            </form>
        </td>
    </tr>
</table>
<script type="text/javascript">
    $(function () {
        $('#announcement').Validform({
            tiptype: 2
        });
    });

</script>

