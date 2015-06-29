<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>教务处公告</title>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<link href="<%=path%>/style/site.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/sexybutton.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/style/jquery.datepick.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/icon.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
	</head>

	<body>

		<div id="main" class="wrapper clearfix">
		    <form action="QuerySchoolLeaderAnnoun" method="post">
		        <table width="100%">
		           <tr>
		              <td>公告名称:<input type="text" name="announTitle" id="announTitle"/></td>
		              <td>审核状态:<select name="checkState" id="checkState" >
								                    <option value="">所有</option>
													<option value="CN">审核未通过</option>
													<option value="CY">审核已通过</option>
													<option value="NC">待审核</option>
					  </select></td>
		          	  <td width="65" align="center">发布时间</td>
		          	  <td><input class="easyui-datebox"  name="publishTime" style="width:150px"/></td>
		         </tr>
		         <tr>
		         
		          	  <td>发布者:<input type="text" name="publisherName" id="publisherName"/></td>
					  
			
					  <td><input type="submit" value="查询"/>
					  </td>
					  <td>
					  <input type="reset" value="重置"/></td>
		           </tr>		           
		        </table>
		    </form>
			<s:form action="" theme="simple">
				<div class="con-box">
					<div class="con">
						<table cellpadding="0" cellspacing="0" class="info-table"
							width="100%">
							<thead>
							  <tr>
								<td width="50" align="center">公告名称</td>
								<td width="100"  align="center">发布人</td>
								<td width="65" align="center">发布日期</td>
								<td width="65" align="center">公告类型</td>
								<td width="65" align="center">审核状态</td>
								<td width="65" align="center">操作</td>
							  </tr>
							</thead>
							<s:iterator value="listAnnouncementModels" id="listAnnouncementModels">
							  <tr onMouseOver="this.style.backgroundColor='#D0E9ED'" onMouseOut="this.style.backgroundColor=''">
								<td align="center">
									<s:property value="#listAnnouncementModels.announTitle" />
								</td>
								<td align="center">
								    <s:property value="#listAnnouncementModels.publisherName"/>&nbsp;
								</td>
								<td align="center">
									<s:property value="#listAnnouncementModels.publishTime" />
								</td>
								<td align="center">
									<s:property value="#listAnnouncementModels.TAnnounType.announTypeName" />
								</td>
								<td>
								<s:if test="#listAnnouncementModels.checkState=='NC'">
											待审核
								  </s:if> 
						          <s:elseif test="#listAnnouncementModels.checkState=='CY'">
						         			审核已通过
						          </s:elseif>
						          <s:elseif test="#listAnnouncementModels.checkState=='CN'">
						         			审核未通过
						          </s:elseif>	
						          <s:else>
						         			 错误代码
						          </s:else>
								</td>
								<td align="center">
									<s:a href="ViewAnnouncement?announId=%{#listAnnouncementModels.announId}" >查看</s:a>
									<s:if test="#listAnnouncementModels.publishState=='N '">
											<s:a href="EditAnnouncement?announId=%{#listAnnouncementModels.announId}" >编辑</s:a>
									</s:if> 
									<s:a href="DeleteAnnouncement?announId=%{#listAnnouncementModels.announId}" >删除</s:a>
									<s:if test="#listAnnouncementModels.checkState=='NC'">
									<s:a href="CheckAnnouncement?announId=%{#listAnnouncementModels.announId}" >审核</s:a>
								    </s:if> 
								</td>
							  </tr>
							</s:iterator>
							<tr>
								<s:url id="firstPage" action="ListSchoolAnnouncement">
									<s:param name="page" value="1"></s:param>
								</s:url>
								<s:url id="url_pre" action="ListSchoolAnnouncement">
									<s:param name="page" value="page-1"></s:param>
								</s:url>
								<s:url id="url_next" action="ListSchoolAnnouncement">
									<s:param name="page" value="page+1"></s:param>
								</s:url>
								<s:url id="lastPage" action="ListSchoolAnnouncement">
									<s:param name="page" value="totalPage"></s:param>
								</s:url>
								<table>
									<tr>
										<td>
											共有
											<s:property value="totalNumber" />
											个记录
											<s:if test="page != 1">
												<s:a href="%{firstPage}" label="首页">
													首页
												</s:a>
											</s:if>
											<s:else>
												<s:label>
													
												</s:label>
											</s:else>
			
											&nbsp;
											<s:if test="page != 1">
												<s:a href="%{url_pre}" label="上一页">
													上一页
												</s:a>
											</s:if>
											<s:else>
												<s:label>
													
												</s:label>
											</s:else>
											&nbsp;
											<s:if test="page != totalPage">
												<s:a href="%{url_next}" label="下一页">
													下一页
												</s:a>
											</s:if>
											<s:else>
												<s:label>
													
												</s:label>
											</s:else>
											&nbsp;
											<s:if test="page != totalPage">
												<s:a href="%{lastPage}" label="尾页">
													尾页
												</s:a>
											</s:if>
											<s:else>
												<s:label>
													
												</s:label>
											</s:else>
			
											&nbsp; 共
											<s:property value="totalPage" />
											页 这是第
											<s:property value="page" />
											页
										</td>
									</tr>
								</table>
							</tr>
							
						</table>
					</div>
				</div>
			</s:form>
		</div>
	</body>
</html>
