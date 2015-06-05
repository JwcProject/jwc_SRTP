<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>编辑公告</title>
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/ueditor/ueditor.config.js"></script>
        <script type="text/javascript" src="<%=path%>/ueditor/ueditor.all.js"></script>
        <script type="text/javascript" src="<%=path%>/js/jquery.MultiFile.js"></script>
	</head>

	<body>
    <div id="main">
        <h1 align="center">编辑公告</h1>
	    <form id="announcement" name="announcement" action="UpdateAnnouncement" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="announId" value="<s:property value="%{announcement.announId}"/>"/> 
	    <div>
	       <label>公告名称：</label>
	       <input type="text" name="announTitle" value="<s:property value="%{announcement.announTitle}"/>" style="width: 300px;"/>
	    </div>
	    <div>
	       <label>内容简介：</label>
	       <textarea name="announContent" id="myEditor"><s:property value="%{announcement.announContent}"/></textarea>
           <script type="text/javascript">
               var editor = new UE.ui.Editor();
               editor.render("myEditor");
           </script>
	    </div>
	    <div>
	       <label>公告附件：</label>
	       <p>
	          <s:iterator value="attachments" id="attachment"><a href="downLoadAttachment?attachementId=<s:property value="attaId" />"><s:property value="fileName" /></a>&nbsp;&nbsp;</s:iterator>
	       </p>
	       <input type="file" name="files" /><label style="color: red;">* 如需修改附件请重新上传所有附件</label>(支持doc|pdf|docx|txt|html|htm|jpg|jpeg|gif|bmp|rar|xlsx|xls格式，最大附件数：5)
	    </div>
	    <div>
	       <input id="mysave" type="submit" value="保存" onclick="save();"/>
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
		<!--<div id="main" class="wrapper clearfix">
			<s:form action="UpdateAnnouncement" theme="simple">

				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<caption>
								<font color="blue">编辑公告</font>
							</caption>
							<tr>
								<td align="center" width="10%">
									公告名称：
									<font color="red">*</font>
									<s:hidden name="announId" value="%{announcement.announId}"></s:hidden>
								</td>
								<td align="left" width="15%">
									<s:textfield name="announTitle" value="%{announcement.announTitle}"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									公告内容：
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
									<s:textfield name="announContent" value="%{announcement.announContent}"></s:textfield>
								</td>
							</tr>
							<tr>
								<td align="center" width="10%">
									附件：
									<font color="red">*</font>
								</td>
								<td align="left" width="15%">
							
								</td>
							</tr>
							<tr align="center">
								<td colspan="2">
									<s:submit value="保存"></s:submit>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</s:form>
		</div>-->
	</body>
</html>
