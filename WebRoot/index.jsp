<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>SRTP控制页面</title>
		<link href="<%=path%>/css/home.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/jquery.jgrowl.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/css/global.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/site.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		首页！
		<br>
		欢迎你！
		<br>
		<br>
		<br>
		<br>
		<ul>
			<li>
				1 系统管理
			</li>
			<li>
				<a href="ListUser">1.1 用户信息管理 </a>
			</li>
			<li>
				<a href="ListPermission">1.2 权限管理 </a>
			</li>
			<li>
				<a href="ListRole">1.3 角色信息管理 </a>
			</li>
            <li>
			    <a href="ListJournal">1.4 日志管理 </a>
			</li>
			<li>
				2 公告管理
			</li>
			<li>
			    <a href="pages/announManage/announ_commit.jsp">2.1发布公告 </a>
			</li>
			<li>
				<a href="ListStuTeaAnnoun">2.2学生公告 </a>
			</li>
			<li>
				<a href="ListStuTeaAnnoun">2.3指导教师公告 </a>
			</li>
			<li>
				<a href="ListUnitAnnouncement">2.4学院公告 </a>
			</li>
			<li>
				<a href="ListSchoolAnnouncement">2.5教务处老师公告 </a>
			</li>
			<li>
				<a href="ListSchoolLeaderAnnouncement">2.5教务处领导公告 </a>
			</li>
			<li>

			    3.申报管理
			</li>
			<li>
			   <a href="pages/declarationManage/declaration_add.jsp">3.1 项目申报</a>
			</li>
			<li>
			   <a href="ListUnitDeclaration">3.2 学院申报列表</a>
			</li>
			<li>
			   <a href="PreCreateExpert">3.3 创建专家团队</a>
			</li>
			<li>
			   <a href="ListDeclaration">3.4 我的申报</a>
			</li>
			<li>
			   <a href="ListHistoryExpert">3.5 历史专家库</a>
			</li>
			<li>
			   <a href="ListUnitExperTeam">3.6 学院专家团队</a>
			</li>
			<li>
			   <a href="PreOrganizeReview">3.7组织评审</a>
			</li>
			<li>
			   <a href="PreResultTypeIn">3.8结果录入</a>
			</li>
			<li>
			   <a href="UnitResultAudit">3.9结果审核</a>
			</li>
			<li>
			   <a href="OnlineComments?id=B159350A53BE44CF8A7B78223A42D867">3.10网评</a>
			</li>
			<li>
			   <a href="ListSchoolDeclaration">3.10教务处申报结果录入列表</a>
			</li>
			<li>
			   <a href="SchoolDeclaration">3.11教务处申报列表</a>
			</li>
			<li>
			   <a href="PreMyReview">3.12我的评审</a>
			</li>

			<li>
			   <a href="PreAssignExpert">3.13分派专家</a>
			</li>

			<li>
			   <a href="PreEndProjectRequest">3.14申请结题</a>
			</li>
			<li>
			   <a href="PreMyEndProjects">3.15我的结题</a>
			</li>
			<li>
			   <a href="PreOrganizeEndprojectReview">3.15组织结题评审</a>
			</li>
			
			<li>
			   <a href="FindEndproExpTeam">3.16列出结题专家团队 </a>
			</li>
			<li>
			   <a href=PreCreateEndProExpertTeam>3.17生成创建结题专家团队页面</a>
			</li>
			<li>
			   <a href="PreAssignEndProExpert">3.18生成分派结题专家团队页面</a>
			</li>
			<li>
			   <a href="ListEndProHistoryExpert">3.19列出结题的历史专家教师</a>
			</li>
			<li>
			   <a href="PreEndProResultTypeIn">3.20结题成绩录入</a>
			</li>
			<li>
			   <a href="PreEndProScoreAudit">3.20结题成绩审核</a>
			</li>
			<li>
			   <a href="PreMyEndProReview">3.21我的结题评审</a>
			</li>
		</ul>
	</body>
</html>
