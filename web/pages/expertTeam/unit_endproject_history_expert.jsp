<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
          + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<div id="container">
  <div id="maincontent" class="h645">
    <table class="table table-striped table-bordered table-hover">
        <h3 class="header smaller lighter blue">
          &nbsp;
          <s:property value="%{#session.unit.unitName}"/>
          SRTP历史专家库
        </h3>
      <tr>
        <td width="88%" valign="top"
            style="padding-top: 10px; padding-left: 5px;"
            style="border:1px solid #dcdcdc" bordercolor="#f4f3f1">
          <div class="midbox">

            <s:form action="" method="post" name="queyForm" theme="simple">
              <div class="xia_left">
                <ul>
                  <li>
                    <p>
                      教师名称:
                      <s:textfield name="teacherName" id="teacherName"/>
                    </p>
                  </li>
                  <li>

                    <p>
                      职称:
                      <s:select
                              list='#{"00":"所有","教授":"教授","副教授":"副教授","讲师":"讲师"}'
                              name="teacherTitle" id="teacherTitle"></s:select>

                    </p>

                    <p>
                      <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                      <s:hidden id="totalPages" name="totalPage"
                                value="%{totalPage}"></s:hidden>
                    </p>
                  </li>
                </ul>
              </div>
            </s:form>
            <div class="xia_right_sq">
              <img src="images/gonggaoweihu_icon1.gif" alt="查询"
                   onclick="query();"/>
            </div>

            <s:form action="" theme="simple" id="addExpert" name="addExpert">
              <div class="xia_list">

                <table class="table table-striped table-bordered table-hover">

                  <tr
                          style="line-height: 30px; border-bottom: 1px solid #dcdcdc;">
                    <td style="padding-left: 10px" bgcolor="#FFFFFF" width="14%"
                        class="NoNewline">
                      <input type="checkbox" name="ALL" id="ALL"
                             onClick="check()" value="on "/>教师编号

                    </td>
                    <td>
                      教师名称
                    </td>
                    <td>
                      性别
                    </td>
                    <td >
                      职称
                    </td>
                    <td>
                      最近所属团队
                    </td>

                  </tr>
                  <s:iterator value="expertTeachers" id="expertTeachers"
                              status="stuts">
                    <s:if test="#stuts.odd == true">
                      <tr
                      style="line-height: 30px; border-bottom: 1px solid #dcdcdc; background-color: #eef7ff">
                    </s:if>
                    <!--判断记号是否为偶数 -->
                    <s:else>
                      <tr
                      style="line-height: 30px; border-bottom: 1px solid #dcdcdc; background-color: #ffffff">
                    </s:else>
                    <td style="padding-left: 10px" class="NoNewline">
                      <input type="checkbox" name="teacherCodes" id="music"
                             value='<s:property value="%{TTeacher.teaCode}"/>'/>
                      <label for="music">
                        <s:property value="#expertTeachers.TTeacher.teaCode"/>
                      </label>
                    </td>
                    <td>
                      <s:property value="#expertTeachers.TTeacher.teaName"/>
                      &nbsp;
                    </td>
                    <td>
                      <s:if test="#expertTeachers.TTeacher.teaSex=='01'">
                        男
                      </s:if>
                      <s:elseif test="#expertTeachers.TTeacher.teaSex=='02'">
                        女
                      </s:elseif>
                      <s:else>
                        未知
                      </s:else>
                    </td>
                    <td>
                      <s:property value="#expertTeachers.TTeacher.teaTitle"/>
                    </td>
                    <td>
                      <s:property
                              value="#expertTeachers.TExpertLib.TJieqi.jqYear+'年，第'+#expertTeachers.TExpertLib.TJieqi.qici+'期'"/>
                    </td>
                    </tr>
                  </s:iterator>


                </table>

              </div>
            </s:form>
            <div class="xia_x_jg">

              <ul>
                <li>
                  <a onclick="add();"><img
                          src="<%=path%>/images/jieguo_anniu45.gif" alt="添加至本期专家团队"/>
                  </a>
                </li>

                <%--<li><a ><img src="images/jieguo_anniu4.gif" alt="取消" /></a></li>
--%>
              </ul>


            </div>
            <div id="pager"
                 style="padding-left: 600px; position: relative; top: -65px;">
            </div>
          </div>
        </td>
      </tr>
    </table>
  </div>
</div>
<script type="text/javascript" language="javascript">
  $(document).ready(function () {
    var page = $("#pages")[0].value;
    var totalPage = $("#totalPages")[0].value;
    $("#pager").pager({pagenumber: page, pagecount: totalPage, buttonClickCallback: PageClick});
  });

  PageClick = function (pageclickednumber) {
    var totalPage = $("#totalPages")[0].value;
    $("#pager").pager({pagenumber: pageclickednumber, pagecount: totalPage, buttonClickCallback: PageClick});
    changePage(pageclickednumber);
  }


  function changePage(pageclickednumber) {

    var teacherName = $("#teacherName")[0].value;
    var teacherTitle = $("#teacherTitle")[0].value;

    location = "FindEndProHistoryExpert?page=" + pageclickednumber + "&teacherName=" + teacherName + "&teacherTitle=" + teacherTitle;

  }

  function query() {
    $("#pages")[0].value = 1;
    document.queyForm.action = "<%=basePath%>FindEndProHistoryExpert";

    postFormAndSetAjax($(document.queyForm));
  }


  function showSuccess() {
    $.messager.show({
      title: '提示消息',
      msg: '专家库添加成功!',
      timeout: 3000,
      showType: 'slide'
    });
  }
  function showError() {
    $.messager.show({
      title: '提示消息',
      msg: '专家库添加失败,请重新添加!',
      timeout: 4000,
      showType: 'slide'
    });
  }
  function add() {
    var isChecked = false;
    var cbx = document.getElementsByName("teacherCodes");
    for (var i = 0; i < cbx.length; ++i) {
      if (cbx[i].checked == true) {
        isChecked = true;
        break;
      }
    }

    if (isChecked) {
      $('#addExpert').form('submit',
              {
                url: '<%=path%>/CreateEndProExpFromHistory',
                success: function (result) {
                  var obj = JSON.parse(result);
                  if (obj.result == 'yes') {
                    showSuccess();

                    $.messager.confirm('提示消息', '专家库添加成功，需要跳转到专家库页面吗？', function (r) {
                      if (r) {
                        location.href = "<%=path%>/FindEndproExpTeam";
                      }
                    });
                  }
                  else if (obj.result == 'noCurrentJieqi') {
                    $.messager.alert('提示', '不存在有效的结题届期，专家库添加未成功！', 'error');
                    return;
                  }
                  else if (obj.result == 'error') {
                    showError();
                  }
                }
              });
    }
    else {
      $.messager.alert('提示', '请至少选择一个专家教师', 'warning');
    }
  }

  function check() {
    var all = document.getElementById("ALL");
    if (all.checked == true) {
      checkAll();
    }
    else {
      uncheckAll();
    }
  }
  function checkAll() {
    var code_Values = document.getElementsByTagName("input");
    for (var i = 0; i < code_Values.length; i++) {
      if (code_Values[i].type == "checkbox") {
        code_Values[i].checked = true;
      }
    }
  }
  function uncheckAll() {
    var code_Values = document.getElementsByTagName("input");
    for (var i = 0; i < code_Values.length; i++) {
      if (code_Values[i].type == "checkbox") {
        code_Values[i].checked = false;
      }
    }
  }


</script>
