<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>    
    <title>学生左侧菜单</title>
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
            <div class="identity">学生</div>
            <div class="Left_menu" id="Left_menu">
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                       <img src="<%=path%>/images/anniu1.jpg" width="215" height="43" /></dt>
                  <div class="menu_body">
                     <dd><a href="<%=path%>/pages/announManage/announ_commit.jsp">发布公告</a></dd>
                     <dd><a href="<%=path%>/ListStuTeaAnnoun">我的公告</a></dd>
                  </div>  
              </dl>
              <dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt3.png" width="13" height="8" /></div>
                       <img src="<%=path%>/images/anniu2.jpg" width="215" height="47" /></dt>
                  <div class="menu_body">
                     <dd><a href="<%=path%>/preAddDeclaration">申报项目</a></dd>
                     <dd><a href="<%=path%>/ListDeclaration">我的申报</a></dd>
                  </div>
              </dl>
              
              <%--<dl>
                <dt class="menu_head">
                  <div class="jt"><img src="<%=path%>/images/jt2.png" width="8" height="13" /></div>
                  <img src="<%=path%>/images/anniu5.jpg" width="214" height="43" /></dt>
                  <div class="menu_body">
                      
                  </div>
              </dl>
              --%><dl>
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
