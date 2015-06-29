<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>结题申请</title>
<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />

<link href="<%=path%>/style/declaration_style.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
<style type="text/css">
  .Left_z{
    height: 1076px;
  }
</style>
</head>
<body>
<div id="container">

  <jsp:include page="../../header.jsp" ></jsp:include>
  <!--  此处显示 id "maincontent" 的内容-->
  <div id="maincontent" class="h645" style="height: auto;">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
	  
        <!--  左边区域-->
        

		   <s:if test="null!=#session.user">
          	<s:if test="%{#session.user.userType == '08'}">
		  		<jsp:include page="../../student_leader_left.jsp"></jsp:include>
		  	</s:if>
		    
		   </s:if>
		   <s:else>
		   		<jsp:forward  page="../../login.jsp"></jsp:forward>
		   </s:else>

		  

		  
        <!--中间区域-->

        <td width="88%" valign="top"  style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc" bordercolor="#f4f3f1"  style="display:block;overFlow:auto" >
		<div class="midbox" style="height: auto;">
		<div class="midbox_gg">
		<div class="xmsb">结题申请表</div>
	    </div>
	    <form id="endprojectRequest" name="endprojectRequest" method="post" enctype="multipart/form-data">
		<div class="xmsb_shang">
		
		<div class="xia_gg">
		<table>
		<tr>
		<td align="left">SRTP期次：<s:property value="project.TJieqi.jqYear+'年，第'+project.TJieqi.qici+'期'" />
			<s:hidden name="jieQiId" value="%{project.TJieqi.jqId}"></s:hidden></td>
	    </tr>
		
		<tr>
		<td align="left">项目编号：<s:property value="project.projectNumber" />	
         <s:hidden name="endProject.endprojectNumber" value="%{project.projectNumber}"></s:hidden>
		<s:hidden name="proId" value="%{project.projectId}"></s:hidden></td>
       </tr>
       
       <tr>
         <td align="left">项目名称：<s:property value="project.projectName" />
			<s:hidden name="endProject.endprojectName" value="%{project.projectName}"></s:hidden></td>        	
         </td>
       </tr>
      <tr>
         <td align="left">项目组成员及分工：</td>
      </tr>
      <tr>
         <td>
         	<table id="user_list" style="width:800px;">
								<thead>
									<td align="left" style="width:150px; font-family:微软雅黑; font-size:14px; font-weight:normal;">
										姓名
									</td>
									<td align="left" style="width:100px; font-family:微软雅黑; font-size:14px; font-weight:normal">
										学号
									</td>
									<td align="left" style="width:350px; font-family:微软雅黑; font-size:14px; font-weight:normal">
										主要负责内容
									</td>
									<td align="left" style="width:300px; font-family:微软雅黑; font-size:14px; font-weight:normal">
										完成情况
									</td>
								</thead>
								<s:if test="%{project.TStudentByProjectLeader != null}">
									<tr>
										<td align="left">
											<s:property
												value="project.TStudentByProjectLeader.studentName" />
										</td>
										<td align="left">
											<s:property
												value="project.TStudentByProjectLeader.studentNumber" />
											<s:hidden name="studentNumber" value="%{project.TStudentByProjectLeader.studentNumber}"></s:hidden>												
										</td>
										<td align="left">
											<textarea rows="3" cols="40" style="overflow-y:scroll;resize:none"
												name="endprojectJob.jobContent" class="easyui-validatebox" data-options="required:true,validType:'length[1,250]'"></textarea>
										</td>
										<td align="left">
											<textarea rows="3" cols="25" style="overflow-y:scroll;resize:none" name="endprojectJob.finished"  class="easyui-validatebox" data-options="required:true,validType:'length[1,25]'"></textarea>
										</td>
									</tr>
								</s:if>
								<s:if test="%{project.TStudentByProjectUser1 != null}">
									<tr>
										<td align="left" style="width:100px">
											<s:property
												value="project.TStudentByProjectUser1.studentName" />
										</td>
										<td align="left" style="width:100px">
											<s:property
												value="project.TStudentByProjectUser1.studentNumber" />
											<s:hidden name="studentNumber1" value="%{project.TStudentByProjectUser1.studentNumber}"></s:hidden>
										</td>
										<td align="left">
											<textarea rows="3" cols="40" style="overflow-y:scroll;resize:none" 
												name="endprojectJob1.jobContent"  class="easyui-validatebox" data-options="required:true,validType:'length[1,250]'"></textarea> 
										</td>
										<td align="left">
											<textarea rows="3" cols="25" style="overflow-y:scroll;resize:none" name="endprojectJob1.finished"  class="easyui-validatebox" data-options="required:true,validType:'length[1,25]'"></textarea>
										</td>
									</tr>
								</s:if>
								<s:if test="%{project.TStudentByProjectUser2 != null}">
									<tr>
										<td align="left" style="width:100px">
											<s:property
												value="project.TStudentByProjectUser2.studentName" />
										</td>
										<td align="left" style="width:100px">
											<s:property
												value="project.TStudentByProjectUser2.studentNumber" />
											<s:hidden name="studentNumber2" value="%{project.TStudentByProjectUser2.studentNumber}"></s:hidden>
										</td>
										<td align="left">
											<textarea rows="3" cols="40" style="overflow-y:scroll;resize:none"
												name="endprojectJob2.jobContent"  class="easyui-validatebox" data-options="required:true,validType:'length[1,250]'"></textarea>
										</td>
										<td align="left">
											<textarea rows="3" cols="25" style="overflow-y:scroll;resize:none" name="endprojectJob2.finished"  class="easyui-validatebox" data-options="required:true,validType:'length[1,25]'"></textarea>
										</td>
									</tr>
								</s:if>
							</table>
	     </td>
	     
	  </tr>
</table>
</div>
<!--

<div class="lb_biaoge">
<div class="sblb_biaoge">
<p id="xmcy">项目组成员（含申请项目成员信息）：
</p>
 <table id="datagrid"></table>
</div>
				
<div class="sblb_biaoge2">
<p id="xmcy2">指导教师：
</p>


 <table id="teacherDatagrid"></table>
				</div>
</div>
				
				-->
<div class="xmjj_wbk">

<h4>项目成果简介：</h4>
<textarea name="endProject.endprojectIntroduction" id="xm_wbj" class="easyui-validatebox" data-options="required:true,validType:'length[1,2000]'" style="width:759px;height:150px;overflow-y:scroll;resize:none"></textarea>

</div>
		<div class="xia_gg">
			
		
        <div class="gg_fujian_sb">
		<div class="xia_gg_left_sb">
		
		<p>上传附件:
		<input type="file" name="files" id="text_fj"  /> 
		</p>
		</div>
		<div class="xia_gg_right"><a href="#" ><img src="<%=path%>/images/fabugonggao_wjj.gif" alt="上传文件" /></a>(只支持doc|docx格式)</div>
		
		</div>
		</div>
		<div class="fjnr_zd">
		<p>(以下内容从附件中自动读取)
		</p>
		</div>

	
		<dl class="artTabs" style="width:760px;margin-left: 30px"> 
              <dt id="tabs"><a href="#tabContent1" class="select">研究的目的及意义</a> <a href="#tabContent2">主要内容</a> <a href="#tabContent3">过程与方法</a> <a href="#tabContent4">创新点</a> <a href="#tabContent5">存在的问题、建议</a> <a href="#tabContent6">自我评价分析与总结</a></dt> 
              <dd id="tabContent1" style="display:block"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectSense" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
               </span></dd> 
              <dd id="tabContent2" style="display:none"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectContent" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
                </span></dd> 
              <dd id="tabContent3" style="display:none"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectMethod" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
                </span></dd> 
              <dd id="tabContent4" style="display:none"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectInnovate" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
                </span>
                </dd> 
              <dd id="tabContent5" style="display:none"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectProblem" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
                </span>
                </dd>
              <dd id="tabContent6" style="display:none"><span style=" padding-top:5px; padding-bottom:5px;">
                <textarea name="endProject.endprojectComment" id="textfield12"  style="border:1px solid #CCC;overflow-y:scroll;width:759px;height:150px;resize:none"></textarea>
                </span>
                </dd>
          </dl> 
          
</div>
</form>

		<div id="tdlg-buttons" style="margin-left: 50px;margin-top: 20px; margin-bottom: 20px">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="save()">提交申请</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="">重置</a>	
		<a href="javascript:void(0);" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#teacherDlg').dialog('close')">退出</a>
    </div>
		</div>
		</td>

	</tr>
	</table>
  </div>
  <jsp:include page="../../footer.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.MultiFile.js"></script>
<script type="text/javascript" src="<%=path%>/js/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="<%=path%>/js/endproject.js"></script>
<script type="text/javascript">   

var artTabs = function (bar, config) {
	var gid = function (id) {return document.getElementById(id)};
	
	config = config || {};
	var bar = typeof bar === 'string' ? gid(bar) : bar,
		className = config.className || 'select',
		callback = config.callback || function () {},
		isMouseover = config.isMouseover,
		
		buttons = bar.getElementsByTagName('a'),
		selectButton = buttons[
			config.index ||
			function () {
				var ret = 0;
				for (i = 0; i < buttons.length; i++) {
					if (buttons[i].className === className) ret = i;
				};
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
			};
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
 
 
// 演示代码
jQuery('.artTabs > dt').artTabs();
    /**$(function(){ 
        $("input[name='a']").change(function() {
		   if($('#otherLib').attr('checked')==false){
		       $('#otherLibRef').hide();
		   }else{
		      $('#otherLibRef').show(); 
		   }
        }); 
    });**/ 
$.extend($.fn.validatebox.defaults.rules, {
    number : {// 验证数字
		validator : function(value) {
			return /^\d+$/g.test(value);
		},
		message : '请输入数字'
	}
});	
function save(){
				document.endprojectRequest.action = "<%=basePath%>AddEndprojectRequest";
			  	document.endprojectRequest.submit();
			}

$(function(){
					$("input:file").MultiFile({
				      accept: 'doc|docx',
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
</html>
