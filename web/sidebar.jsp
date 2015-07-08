<%@ page import="edu.cqu.no1.domain.Authority" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/7/2
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
  <script type="text/javascript">
    try {
      ace.settings.check('sidebar', 'fixed')
    } catch (e) {
    }
  </script>

  <div class="sidebar-shortcuts" id="sidebar-shortcuts">
    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
      <button class="btn btn-success">
        <i class="ace-icon fa fa-signal"></i>
      </button>

      <button class="btn btn-info">
        <i class="ace-icon fa fa-pencil"></i>
      </button>

      <!-- #section:basics/sidebar.layout.shortcuts -->
      <button class="btn btn-warning">
        <i class="ace-icon fa fa-users"></i>
      </button>

      <button class="btn btn-danger">
        <i class="ace-icon fa fa-cogs"></i>
      </button>

      <!-- /section:basics/sidebar.layout.shortcuts -->
    </div>

    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
      <span class="btn btn-success"></span>

      <span class="btn btn-info"></span>

      <span class="btn btn-warning"></span>

      <span class="btn btn-danger"></span>
    </div>
  </div>
  <!-- /.sidebar-shortcuts -->

  <ul class="nav nav-list">
    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^announcement[A-Za-z0-9_/]*")) {
    %>

    <li class="active open">
      <a href="#announcement" class="dropdown-toggle">
        <i class="menu-icon fa fa-desktop"></i>
        <span class="menu-text"> 公告管理 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>

      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("announcement/mine")) {
        %>
        <li class="active">
          <a href="#announcement/mine"><i class="menu-icon fa fa-caret-right"></i>我的公告<span class="badge badge-primary">5</span></a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("announcement/student")) {
        %>
        <li class="">
          <a href="#announcement/student"><i class="menu-icon fa fa-caret-right"></i>发布学生公告</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("announcement/teacher")) {
        %>
        <li class="">
          <a href="#announcement/teacher"><i class="menu-icon fa fa-caret-right"></i>发布教师公告</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("announcement/leader")) {
        %>
        <li class="">
          <a href="#announcement/leader"><i class="menu-icon fa fa-caret-right"></i>发布领导公告</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("announcement/maintain")) {
        %>
        <li class="">
          <a href="#announcement/maintain"><i class="menu-icon fa fa-caret-right"></i>公告维护</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^declare[A-Za-z0-9_/]*")) {
    %>
    <li class="">
      <a href="#declare" class="dropdown-toggle">
        <i class="menu-icon fa fa-pencil-square-o"></i>
        <span class="menu-text"> 申报管理 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>
      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/mine")) {
        %>
        <li class="">
          <a href="#declare/mine"><i class="menu-icon fa fa-caret-right"></i>我的申报</a>

          <b class="arrow"></b>
        </li>
        <%
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/apply")) {
        %>
        <li class="">
          <a href="#declare/apply"><i class="menu-icon fa fa-caret-right"></i>申报项目</a>

          <b class="arrow"></b>
        </li>
        <%
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/list")) {
        %>
        <li class="">
          <a href="#declare/list"><i class="menu-icon fa fa-caret-right"></i>申报列表</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/review/mine")) {
        %>
        <li class="">
          <a href="#declare/review/mine"><i class="menu-icon fa fa-caret-right"></i>我的评审</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/expert/create")) {
        %>
        <li class="">
          <a href="#declare/expert/create"><i class="menu-icon fa fa-caret-right"></i>创建申报专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/expert/list")) {
        %>
        <li class="">
          <a href="#declare/expert/list"><i class="menu-icon fa fa-caret-right"></i>查看申报专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/expert/history")) {
        %>
        <li class="">
          <a href="#declare/expert/history"><i class="menu-icon fa fa-caret-right"></i>历史申报专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/expert/distribute")) {
        %>
        <li class="">
          <a href="#declare/expert/distribute"><i class="menu-icon fa fa-caret-right"></i>分配申报专家</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/review/organize")) {
        %>
        <li class="">
          <a href="#declare/review/organize"><i class="menu-icon fa fa-caret-right"></i>组织申报评审</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/result/input")) {
        %>
        <li class="">
          <a href="#declare/result/input"><i class="menu-icon fa fa-caret-right"></i>申报结果录入</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("declare/result/review")) {
        %>
        <li class="">
          <a href="#declare/result/review"><i class="menu-icon fa fa-caret-right"></i>申报结果审核</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>

      </ul>
    </li>
    <%
          break;
        }
      }
    %>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^project[A-Za-z0-9_/]*")) {
    %>
    <li class="">
      <a href="#project" class="dropdown-toggle">
        <i class="menu-icon fa fa-folder-open"></i>
        <span class="menu-text"> 项目管理 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>

      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("project/mine")) {
        %>
        <li class="">
          <a href="#project/mine"><i class="menu-icon fa fa-caret-right"></i>我的项目</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("project/list")) {
        %>
        <li class="">
          <a href="#project/list"><i class="menu-icon fa fa-caret-right"></i>项目列表</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^final[A-Za-z0-9_/]*")) {
    %>

    <li class="">
      <a href="#final" class="dropdown-toggle">
        <i class="menu-icon fa fa-check-square-o"></i>
        <span class="menu-text"> 结题管理 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>
      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/mine")) {
        %>
        <li class="">
          <a href="#final/mine"><i class="menu-icon fa fa-caret-right"></i>我的结题</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/apply")) {
        %>
        <li class="">
          <a href="#final/apply"><i class="menu-icon fa fa-caret-right"></i>申请结题</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/list")) {
        %>
        <li class="">
          <a href="#final/list"><i class="menu-icon fa fa-caret-right"></i>结题列表</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/review/mine")) {
        %>
        <li class="">
          <a href="#final/review/mine"><i class="menu-icon fa fa-caret-right"></i>我的评审</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/review/organize")) {
        %>
        <li class="">
          <a href="#final/review/organize"><i class="menu-icon fa fa-caret-right"></i>组织结题评审</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/expert/list")) {
        %>
        <li class="">
          <a href="#final/expert/list"><i class="menu-icon fa fa-caret-right"></i>查看结题专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/expert/create")) {
        %>
        <li class="">
          <a href="#final/expert/create"><i class="menu-icon fa fa-caret-right"></i>创建结题专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/expert/history")) {
        %>
        <li class="">
          <a href="#final/expert/history"><i class="menu-icon fa fa-caret-right"></i>历史结题专家团队</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/expert/distribute")) {
        %>
        <li class="">
          <a href="#final/expert/distribute"><i class="menu-icon fa fa-caret-right"></i>分派结题专家</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/result/input")) {
        %>
        <li class="">
          <a href="#final/result/input"><i class="menu-icon fa fa-caret-right"></i>结题结果录入</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("final/result/review")) {
        %>
        <li class="">
          <a href="#final/result/review"><i class="menu-icon fa fa-caret-right"></i>结题结果审核</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^statistic[A-Za-z0-9_/]*")) {
    %>
    <li class="">
      <a href="#statistic" class="dropdown-toggle">
        <i class="menu-icon fa fa-table"></i>
        <span class="menu-text"> 统计分析 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>

      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("statistic/grade")) {
        %>
        <li class="">
          <a href="#statistic/grade"><i class="menu-icon fa fa-caret-right"></i>成绩分布</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("statistic/index")) {
        %>
        <li class="">
          <a href="#statistic/index"><i class="menu-icon fa fa-caret-right"></i>指标统计</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>
    <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
      if (authority.getPath().equals("knowledge")) {
    %>
    <li class="">
      <a href="#knowledge">
        <i class="menu-icon fa fa-book"></i>
        <span class="menu-text"> 知识库管理 </span>
      </a>

      <b class="arrow"></b>
    </li>
    <%
          break;
        }
      }%>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^system[A-Za-z0-9_/]*")) {
    %>
    <li class="">
      <a href="#system" class="dropdown-toggle">
        <i class="menu-icon fa  fa-cog"></i>
        <span class="menu-text"> 系统维护 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>
      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("system/role")) {
        %>
        <li class="">
          <a href="#system/role"><i class="menu-icon fa fa-caret-right"></i>角色权限管理</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("system/authority")) {
        %>
        <li class="">
          <a href="#system/authority"><i class="menu-icon fa fa-caret-right"></i>用户角色管理</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("system/user")) {
        %>
        <li class="">
          <a href="#system/user"><i class="menu-icon fa fa-caret-right"></i>用户信息维护</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("system/period")) {
        %>
        <li class="">
          <a href="#system/period"><i class="menu-icon fa fa-caret-right"></i>届期管理</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {
          if (authority.getPath().equals("system/journal")) {
        %>
        <li class="">
          <a href="#system/journal"><i class="menu-icon fa fa-caret-right"></i>日志管理</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>

    <% for (Authority a : (List<Authority>) session.getAttribute("authorities")) {
      if (a.getPath().matches("^user[A-Za-z0-9_/]*")) {
    %>

    <li class="">
      <a href="#person" class="dropdown-toggle">
        <i class="menu-icon fa fa-user"></i>
        <span class="menu-text"> 个人中心 </span>

        <b class="arrow fa fa-angle-down"></b>
      </a>

      <b class="arrow"></b>
      <ul class="submenu">
        <% for (Authority authority : (List<Authority>) session.getAttribute("authorities")) {

          if (authority.getPath().equals("user/modify")) {
        %>
        <li class="">
          <a href="#user/modify"><i class="menu-icon fa fa-caret-right"></i>个人信息修改</a>

          <b class="arrow"></b>
        </li>
        <%
              break;
            }
          }%>
      </ul>
    </li>
    <%
          break;
        }
      }
    %>
  </ul>
  <!-- /.nav-list -->

  <!-- #section:basics/sidebar.layout.minimize -->
  <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
    <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
       data-icon2="ace-icon fa fa-angle-double-right"></i>
  </div>

  <!-- /section:basics/sidebar.layout.minimize -->
  <script type="text/javascript">
    try {
      ace.settings.check('sidebar', 'collapsed')
    } catch (e) {
    }
  </script>
</div>
<!-- /section:basics/sidebar -->