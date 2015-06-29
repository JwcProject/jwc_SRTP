<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="header">
    <div class="shang">
      <div class="w100">
        <div class="fl logo">
          <p><img src="<%=path%>/images/logo.png" width="545" height="89" /></p>
        </div>
        <div class="fr">
          <div class="shang_R">
            <ul>
              <li><a href="<%=path%>/ReturnIndex" title="返回主页"><img src="<%=path%>/images/1.png" width="17" height="19" alt="返回主页"/></a></li>
              <li><a href="<%=path%>/userLogoutAction" title="退出系统"><img src="<%=path%>/images/2.png" width="17" height="19" alt="退出系统"/></a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="xia">
        <div class="fl xia_l">欢迎您！${user.userName}</div>
        <div class="fr xia_r" id="time"></div>
      </div>
    </div>
  </div>
<script>
document.getElementById('time').innerHTML='系统时间：'+new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
setInterval("document.getElementById('time').innerHTML='系统时间：'+new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
</script>