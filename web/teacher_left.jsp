<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title>教师左侧菜单</title>
  <script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
    <style type="text/css">
       .menu_body{display:none;}
    </style>
    <script type="text/javascript">
       $(document).ready(function(){
	       //$("#Left_menu .menu_body:eq(0)").show();
	       $("#Left_menu dt.menu_head").click(function(){
		       $(this).next("div.menu_body").slideToggle(300);
		       $(this).children("div.jt").children("img").width("13").height("8");
		       $(this).children("div.jt").children("img").attr("src","<%=path%>/images/jt3.png");
		       $(this).parent().siblings().children("div.menu_body").slideUp("slow");
		       $(this).parent().siblings().children("dt").children("div.jt").children("img").width("8").height("13");
		       $(this).parent().siblings().children("dt").children("div.jt").children("img").attr("src","<%=path%>/images/jt2.png");
	       }); 
       });
    </script>
  </head>
  
  <body>
    <td width="12%" valign="top"><div class="Left_z">
            <div class="xy_jiaoshi">学院主管教师</div>
            <div class="Left_menu" id="Left_menu">
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/anniu1.jpg" width="215" height="43" /></dt>
                  <div class="menu_body">
                     <dd><a href="<%=path%>/pages/announManage/announ_commit.jsp">公告发布</a></dd>
                     <dd><a href="<%=path%>/ListUnitAnnouncement">公告维护</a></dd>
                  </div>  
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt3.png" width="13" height="8" /></div>
                  <img src="<%=path%>/images/anniu2.jpg" width="215" height="47" /></dt>
                  <div class="menu_body">
                     <dd><a href="<%=path%>/ListUnitDeclaration">申报列表</a></dd>
                     <dd><a href="<%=path%>/PreCreateExpert">创建申报专家团队</a></dd>
                     <dd><a href="<%=path%>/ListUnitExperTeam">申报专家团队</a></dd>
                     <dd><a href="<%=path%>/ListHistoryExpert">申报历史专家库</a></dd>
                     <dd><a href="<%=path%>/PreAssignExpert">分派申报专家</a></dd>
                     <dd><a href="<%=path%>/PreOrganizeReview">组织申报评审</a></dd>
                     <dd><a href="<%=path%>/PreResultTypeIn">申报结果录入</a></dd>
                     
				  </div>
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/anniu3.jpg" width="215" height="43" /></dt>
                  <div class="menu_body">
                      <dd><a href="<%=path%>/ListProjectByUnitTeaCode">项目列表</a></dd>
                  </div>
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/anniu4.jpg" width="214" height="43" /></dt>
                  <div class="menu_body">
                      <dd><a href="<%=path%>/listEndProjects">结题列表</a></dd>
                      <dd><a href="<%=path%>/PreOrganizeEndprojectReview">组织结题评审</a></dd>
					  <dd><a href="<%=path%>/FindEndproExpTeam">结题专家团队 </a></dd>
					  <dd><a href="<%=path%>/PreCreateEndProExpertTeam">创建结题专家团队</a></dd>
					  <dd><a href="<%=path%>/PreAssignEndProExpert">分派结题专家团队</a></dd>
					  <dd><a href="<%=path%>/ListEndProHistoryExpert">结题历史专家库</a></dd> 
					  <dd><a href="<%=path%>/PreEndProResultTypeIn">结题结果录入</a></dd>                     
                  </div>
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/3_anniu2.png" width="214" height="43" /></dt>
                  <div class="menu_body">
                      <dd><a href="<%=path%>/UnitStatistic/UnitResultDistribut">成绩分布</a></dd>
                  </div>
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/anniu6.jpg" width="214" height="48" /></dt>
                  <div class="menu_body">
                      <dd><a href="<%=path%>/findUserInfo">个人信息维护</a></dd>
                  </div>
              </dl>
            </div>
          </div></td>
  </body>
</html>
