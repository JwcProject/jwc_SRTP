<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>公告管理-发布公告</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/ueditor/ueditor.config.js"></script>
        <script type="text/javascript" src="<%=path%>/ueditor/ueditor.all.js"></script>
        <script type="text/javascript" src="<%=path%>/js/jquery.MultiFile.js"></script>
		<script type="text/javascript">
        function save()
		{
		    alert("save");
			document.announcement.action = "<%=basePath%>SaveAnnouncement";
			document.announcement.submit();
		}

		function commit()
		{
		    alert("commit");
			document.announcement.action = "<%=basePath%>CommitAnnouncement";
			document.announcement.submit();
		}
		</script>
	</head>

	<body>
	<div id="main">
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
	       <input type="file" name="files" />(支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5)
	    </div>
	    <div>
	       <input id="mycommit" type="button" value="发布" onclick="commit();"/>
	       <input id="mysave" type="button" value="保存" onclick="save();"/>
	       <input id="reset" type="reset" value="重置"/> 
	       <input type="button" value="获取公告内容" onclick="getContent();"/>
           <script type="text/javascript">
             function getContent(){
               alert(editor.getContent());
             }
          </script>
	    </div>
	    </form>
	</div>
	<script type="text/javascript">
		$(function(){
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
	</body>
</html>
