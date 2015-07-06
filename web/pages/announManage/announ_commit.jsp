<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
    <script type="text/javascript">
        function save() {
            alert("save");
            document.announcement.action = "<%=basePath%>SaveAnnouncement";
            document.announcement.submit();
        }

        function commit() {
            alert("commit");
            document.announcement.action = "<%=basePath%>CommitAnnouncement";
            document.announcement.submit();
        }
    </script>

    <form id="announcement" name="announcement" action="" method="post" enctype="multipart/form-data">
        <div>
            <label>公告名称：</label>
            <input type="text" name="announcement.announTitle"/>
        </div>
        <div>
            <label>内容简介：</label>
            <textarea name="announcement.announContent" id="myEditor">输入您的公告内容......</textarea>
            <script type="text/javascript">
                var editor = new UE.ui.Editor();
                editor.render("myEditor");
            </script>
        </div>
        <div>
            <label>公告附件：</label>
            <input type="file" name="files"/>(支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5)
        </div>
        <div>
            <input id="mycommit" type="button" value="发布" onclick="commit();"/>
            <input id="mysave" type="button" value="保存" onclick="save();"/>
            <input id="reset" type="reset" value="重置"/>
            <input type="button" value="获取公告内容" onclick="getContent();"/>
            <script type="text/javascript">
                function getContent() {
                    alert(editor.getContent());
                }
            </script>
        </div>
    </form>
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
