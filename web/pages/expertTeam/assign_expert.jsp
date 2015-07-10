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

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="88%" valign="top" style="padding-top:10px; padding-left:5px;" style="border:1px solid #dcdcdc"
            bordercolor="#f4f3f1">
          <div class="midbox">
            <div class="midbox_gg">
              <div class="sblb">&nbsp;<s:property value="%{#session.unit.unitName}"/>学生SRTP项目申报列表</div>
            </div>
            <s:form action="" method="post" name="queyForm" theme="simple">

              <div class="xia_left">
                <table class="table table-striped table-bordered table-hover">
                  <tr>


                    <td>
                      期次:
                      <div class="douselect">
                          <s:doubleselect name="jqYear" list="jieQiYears"
                                          listKey="yearKey" listValue="yearValue"
                                          doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
                                          doubleListKey="jqId" doubleListValue="qici"
                                          cssClass="select_sq" theme="simple"/>
                      </div>
                    </td>


                    <td>
                      <p>项目编号:
                        <s:textfield name="proSerial" id="proSerial"/>
                      </p>
                    </td>

                    <td>
                      <p>项目名称:
                        <s:textfield name="proName" id="proName"/>
                      </p>
                    </td>

                    <td>
                      <p>专业:
                        <s:select list="professions" name="profession" headerKey=""
                                  headerValue="所有" listKey="professionName"
                                  listValue="professionName"></s:select>
                      </p>
                    </td>
                    <td>
                      <p>学号:
                        <s:textfield name="studentNums" id="studentNums"/>
                      </p>
                    </td>
                    <td>

                      <p>审核状态:
                        <s:select list='#{"all":"所有","02":"未分派","03":"已分派"}' name="checkState"
                                  id="checkState"></s:select>

                      </p>

                      <p>
                        <s:hidden id="pages" name="page" value="%{page}"></s:hidden>
                        <s:hidden id="totalPages" name="totalPage" value="%{totalPage}"></s:hidden>
                      </p>
                    </td>

                    <td>
                      <div class="xia_right_sq" style="left:970px">
                        <img src="images/gonggaoweihu_icon1.gif" alt="查询" onclick="query();"/>
                        <a href="javascript:document.queyForm.reset();"><img src="images/reset.png" alt="重置" "/></a>
                      </div>
                    </td>
                  </tr>
                </table>
              </div>
            </s:form>
            <s:form action="" theme="simple" name="proForm" id="proForm">
              <div>
                <div class="xia_list" style="height:200px">

                  <table class="table table-striped table-bordered table-hover">

                    <tr>
                      <td>
                        <label for="music">
                          <input id="ALL" type="checkbox" name="ALL" onclick="check()" value="on ">
                          项目编号
                        </label>
                      </td>
                      <td>项目名称</td>
                      <td>申报人</td>
                      <td>学号</td>
                      <td>专业</td>
                      <td>申请日期</td>
                      <td>分派状态</td>

                    </tr>
                    <s:iterator value="declarations" id="declarations" status="stuts">
                      <s:if test="#stuts.odd == true">
                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#eef7ff">
                      </s:if>
                      <!--判断记号是否为偶数 -->
                      <s:else>
                        <tr style="line-height:30px; border-bottom:1px solid #dcdcdc;background-color:#ffffff">
                      </s:else>
                      <td style="padding-left:10px" class="NoNewline">
                        <input type="checkbox" name="checkProjects" id="music"
                               value='<s:property value="%{#declarations.declarId}"/>'/>
                        <label for="music"><s:property value="#declarations.proSerial"/></label>
                      </td>
                      <td title="<s:property value='#declarations.proName' />">
                        <s:if test="%{#declarations.proName.length()>20}">
                          <s:property value="%{#declarations.proName.substring(0,20)+'...'}"
                                      escape="#onlineList.frmTitle"/>
                        </s:if>
                        <s:else>
                          <s:property value="#declarations.proName"/>
                        </s:else>
                      </td>
                      <td><s:property value="#declarations.TStudentByLeaderCode.studentName"/></td>
                      <td><s:property value="#declarations.TStudentByLeaderCode.studentNumber"/></td>
                      <td><s:property value="#declarations.TStudentByLeaderCode.TProfession.professionName"/></td>
                      <td>
                        <s:if test="null==#declarations.declTime||#declarations.declTime.isEmpty()">

                        </s:if>
                        <s:else>
                          <s:text name="global.format.date">
                            <s:param value="#declarations.declTime"/>
                          </s:text>
                        </s:else>
                      </td>
                      <td>
                        <s:if test="#declarations.checkState=='03'">
                          已分派
                        </s:if>
                        <s:elseif test="#declarations.checkState=='02'">
                          未分派
                        </s:elseif>


                      </td>

                      </tr>
                    </s:iterator>


                  </table>

                </div>

                <!-- 	<div class="xia_x_jg"></div> -->
                <div id="pager" style="padding-left: 600px;position: relative;">
                </div>
                <div class="widget-box">
                  <div class="widget-header widget-header-flat">
                    <div class="widget-title">分配专家</div>
                  </div>
                  <div class="widget-body">
                    <div class="widget-main">
                      <div class="row">
                        <div class="col-md-5">
                          <p>专家团队</p>

                          <p><select name="srcList" multiple style="width: 330px;height: 150px;"
                                     ondblclick="move(this.form.srcList,this.form.destList);">
                            <s:iterator value="expertTeachers" id="expertTeachers">
                              <option>
                                <s:property value="#expertTeachers.TTeacher.teaName+'--'"/>
                                <s:property value="#expertTeachers.TTeacher.teaCode+'--'"/>
                                <s:property value="#expertTeachers.TTeacher.teaTitle"/>
                              </option>
                            </s:iterator>
                          </select>
                          </p>
                        </div>
                        <div class="col-md-2">
                          <ul style="margin-top: 50px;">
                            <li>
                              <a href="javascript:void(0);"
                                 onclick="move(getElementsByName('proForm')[0].srcList,getElementsByName('proForm')[0].destList)"
                                 name="B1">
                                <img src="images/cjzj_anniu1.gif" alt="右" height="26" width="80"/></a>
                            </li>
                            <li>
                              <a href="javascript:void(0);"
                                 onclick="move(getElementsByName('proForm')[0].destList,getElementsByName('proForm')[0].srcList)"
                                 name="B2">
                                <img src="images/cjzj_anniu2.gif" alt="左" height="26" width="80"/></a>
                            </li>
                            <li>
                              <a href="javascript:void(0);"
                                 onclick="moveall(getElementsByName('proForm')[0].srcList,getElementsByName('proForm')[0].destList)"
                                 name="B3">
                                <img src="images/zhuanjia_anniu1.gif" alt="右" height="26" width="80"/></a>
                            </li>
                            <li>
                              <a href="javascript:void(0);"
                                 onclick="moveall(getElementsByName('assignExperts')[0].destList,getElementsByName('assignExperts')[0].srcList)"
                                 name="B4">
                                <img src="images/zhuanjia_anniu2.gif" alt="左" height="26" width="80"/></a>
                            </li>
                          </ul>
                        </div>
                        <div class="col-md-5">
                          <p>专家分派</p>
                          <p>
                            <select name="destList" style="width: 330px;height:150px;" multiple
                                    ondblclick="move(this.form.destList,this.form.srcList);">

                            </select>
                          </p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </s:form>
            <div class="xia_anniu_zj" style="margin-top: 0px">
              <ul>
                <li><a href="javascript:void(0);" onclick="save()"><img src="images/fenpai.png" alt="分派"/></a></li>
                <li><a href="javascript:document.proForm.reset();"><img src="images/quxiao.png" alt="取消"/></a></li>

              </ul>
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
  };


  function changePage(pageclickednumber) {

    var checkState = $("#checkState")[0].value;
    var proName = $("#proName")[0].value;
    var proSerial = $("#proSerial")[0].value;
    var studentNumebr = $("#studentNumebr")[0].value;

    var r = document.getElementsByName("profession")[0];
    var t = document.getElementsByName("jqYear")[0];
    var s = document.getElementsByName("jqQici")[0];
    var jqYear = t.options[t.selectedIndex].value;
    var jqQici = s.options[t.selectedIndex].value;
    var profession = r.options[t.selectedIndex].value;
    getAndSetAjax();
    sendGetAndSetAjax( "QueryDeclaAssignExp?page=" + pageclickednumber + "&checkState=" + checkState + "&proName=" + proName + "&proSerial=" + proSerial + "&studentNumebr=" + studentNumebr + "&profession=" + profession + "&jqYear=" + jqYear + "&jqQici=" + jqQici);

  }

  function query() {
    $("#pages")[0].value = 1;
    document.queyForm.action = "<%=basePath%>QueryDeclaAssignExp";
    postFormAndSetAjax(document.queyForm);
  }

  function save() {
    destList = window.document.getElementById("proForm").destList;
    var expertString = "";
    for (var i = 0; i < destList.length; i++) {
      if (i == destList.length - 1) {
        expertString += destList.options[i].text;
      } else {
        expertString += destList.options[i].text + ",";
      }
    }
    var dataForm = $('#proForm').serialize() + "&experts=" + expertString;

    //alert("aaa");
    jQuery.ajax({
      url: 'AssignExpert',
      data: dataForm,
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      type: "POST",
      success: function (r) {
        //alert("dd");
        sendGetAndSetAjax("<%=path%>/PreAssignExpert") ;
      }
    });
    return false;
  }
  ;

  function move(fbox, tbox) {
    for (var i = 0; i < fbox.options.length; i++) {
      if (fbox.options[i].selected && fbox.options[i].value != "") {
        var no = new Option();
        no.value = fbox.options[i].value;
        no.text = fbox.options[i].text;
        tbox.options[tbox.options.length] = no;
        fbox.options[i].value = "";
        fbox.options[i].text = "";
      }
    }
    BumpUp(fbox);
    if (sortitems)
      SortD(tbox);
  }

  function moveall(fbox, tbox) {
    for (var i = 0; i < fbox.options.length; i++) {
      if (fbox.options[i].value != "") {
        var no = new Option();
        no.value = fbox.options[i].value;
        no.text = fbox.options[i].text;
        tbox.options[tbox.options.length] = no;
        fbox.options[i].value = "";
        fbox.options[i].text = "";
      }
    }
    BumpUp(fbox);
    if (sortitems)
      SortD(tbox);
  }

  function BumpUp(box) {
    for (var i = 0; i < box.options.length; i++) {
      if (box.options[i].value == "") {
        for (var j = i; j < box.options.length - 1; j++) {
          box.options[j].value = box.options[j + 1].value;
          box.options[j].text = box.options[j + 1].text;
        }
        var ln = i;
        break;
      }
    }
    if (ln < box.options.length) {
      box.options.length -= 1;
      BumpUp(box);
    }
  }

  function SortD(box) {
    var temp_opts = new Array();
    var temp = new Object();
    for (var i = 0; i < box.options.length; i++) {
      temp_opts[i] = box.options[i];
    }

    for (var x = 0; x < temp_opts.length - 1; x++) {
      for (var y = (x + 1); y < temp_opts.length; y++) {
        if (temp_opts[x].text > temp_opts[y].text) {
          temp = temp_opts[x].text;
          temp_opts[x].text = temp_opts[y].text;
          temp_opts[y].text = temp;
          temp = temp_opts[x].value;
          temp_opts[x].value = temp_opts[y].value;
          temp_opts[y].value = temp;
        }
      }
    }

    for (var i = 0; i < box.options.length; i++) {
      box.options[i].value = temp_opts[i].value;
      box.options[i].text = temp_opts[i].text;
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
