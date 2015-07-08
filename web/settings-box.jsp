<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 2015/7/2
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- #section:settings.box -->
<div class="ace-settings-container" id="ace-settings-container">
  <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
    <i class="ace-icon fa fa-cog bigger-150"></i>
  </div>

  <div class="ace-settings-box clearfix" id="ace-settings-box">
    <div class="pull-left width-50">
      <!-- #section:settings.skins -->
      <div class="ace-settings-item">
        <div class="pull-left">
          <select id="skin-colorpicker" class="hide">
            <option data-skin="no-skin" value="#438EB9">#438EB9</option>
            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
          </select>
        </div>
        <span>&nbsp; Choose Skin</span>
      </div>

      <!-- /section:settings.skins -->

      <!-- #section:settings.navbar -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
        <label class="lbl" for="ace-settings-navbar"> 固定导航栏 </label>
      </div>

      <!-- /section:settings.navbar -->

      <!-- #section:settings.sidebar -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
        <label class="lbl" for="ace-settings-sidebar"> 固定侧边栏 </label>
      </div>

      <!-- /section:settings.sidebar -->

      <!-- #section:settings.breadcrumbs -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
        <label class="lbl" for="ace-settings-breadcrumbs"> 固定面包屑 </label>
      </div>

      <!-- /section:settings.breadcrumbs -->

      <!-- #section:settings.rtl -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
        <label class="lbl" for="ace-settings-rtl"> 从右向左阅读 (rtl)</label>
      </div>

      <!-- /section:settings.rtl -->

      <!-- #section:settings.container -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
        <label class="lbl" for="ace-settings-add-container">
          普通模式/宽屏模式
        </label>
      </div>

      <!-- /section:settings.container -->
    </div>
    <!-- /.pull-left -->

    <div class="pull-left width-50">
      <!-- #section:basics/sidebar.options -->
      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover"/>
        <label class="lbl" for="ace-settings-hover"> 弹出的子菜单 </label>
      </div>

      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact"/>
        <label class="lbl" for="ace-settings-compact"> 紧凑显示侧边栏 </label>
      </div>

      <div class="ace-settings-item">
        <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight"/>
        <label class="lbl" for="ace-settings-highlight"> 高亮选中的项目 </label>
      </div>
      <!-- /section:basics/sidebar.options -->
    </div>
    <!-- /.pull-left -->
  </div>
  <!-- /.ace-settings-box -->
</div>
<!-- /.ace-settings-container -->
<!-- /section:settings.box -->