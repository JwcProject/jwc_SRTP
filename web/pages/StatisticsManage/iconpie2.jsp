<%@page import="ChartDirector.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
// The data for the pie chart
//double[] data = {28, 45, 5, 1, 12};
double[] data = (double[])request.getAttribute("data");

// The labels for the pie chart
//String[] labels = {"Excellent", "Good", "Bad", "Very Bad", "Neutral"};
String[] labels = (String[])request.getAttribute("labels");

// The icons for the sectors
String[] icons = {"angry.png", "sad.png", "smile.png","laugh.png", "nocomment.png"};

// Create a PieChart object of size 560 x 300 pixels, with a silver background, black
// border, 1 pxiel 3D border effect and rounded corners
PieChart c = new PieChart(560, 300, Chart.silverColor(), 0x000000, 1);
c.setDefaultFonts("simhei.ttc","simhei.ttf");
c.setRoundedFrame();

//Set search path to current JSP directory for loading icon images
c.setSearchPath(getServletConfig().getServletContext(), request);

// Set the center of the pie at (280, 150) and the radius to 120 pixels
c.setPieSize(280, 150, 120);

// Add a title box with title written in CDML, on a sky blue (A0C8FF) background with
// glass effect

c.addTitle("", "隶书", 15, 0x000080).setBackground(0xa0c8ff, 0x000000, Chart.glassEffect());

// Add a logo to the chart written in CDML as the bottom title aligned to the bottom
// right


// Set the pie data and the pie labels
c.setData(data, labels);

// Set 3D style
c.set3D();

// Use the side label layout method
c.setLabelLayout(Chart.SideLayout);

// Set the label background color to transparent
c.setLabelStyle().setBackground(Chart.Transparent);

// Add icons to the chart as a custom field
c.addExtraField(icons);

// Configure the sector labels using CDML to include the icon images
c.setLabelFormat("<*block,valign=absmiddle*><*img={field0}*> {label} ({percent|0}%)")
    ;

// Explode the 3rd and 4th sectors as a group (index = 2 and 3)
c.setExplodeGroup(3, 3);

// Set the start angle to 135 degrees may improve layout when there are many small
// sectors at the end of the data array (that is, data sorted in descending order).
// It is because this makes the small sectors position near the horizontal axis,
// where the text label has the least tendency to overlap. For data sorted in
// ascending order, a start angle of 45 degrees can be used instead.
c.setStartAngle(0);

// Output the chart
String chart1URL = c.makeSession(request, "chart1");

// Include tool tip for the chart
String imageMap1 = c.getHTMLImageMap("", "",
    "title='{label}: {value} responses ({percent}%)'");
%>
<html>
<body style="margin:5px 0px 0px 5px">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>全校成绩分布饼图</title>
		<link href="<%=path%>/css/css1.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/css/Pager.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/js/themes/default/easyui.css" rel="stylesheet" type="text/css" />
		<!--这个js是用来控制页面中出现png图片能兼容浏览区-->
		<script src="<%=path%>/js/iepngfix_tilebg.js"  type="text/javascript" ></script>
</head>
<br>
<div style="font-size:18pt; font-family:verdana; font-weight:bold; text-align:center">
   <s:if  test="%{result == 'noData'}">
		当前届期没有成绩分布，请选择其他期次
	</s:if>
	<s:elseif test="%{result == 'success'}"><s:property value="%{jieqi.jqYear}"/>年 第<s:property value="%{jieqi.qici}"/>期  全校成绩分布图</s:elseif> 
</div>
<hr color="#000080">
<br>
<br>
<s:form action="" method="post" name="queyForm" id="queyForm" theme="simple">
	<div class="douselect">
		<p>
			期次:
			<s:doubleselect name="jqYear" list="jieQiYears"
				listKey="yearKey" listValue="yearValue" headerKey="" headerValue="所有"
				doubleList="qicis.get(top.yearKey)" doubleName="jqQici"
				doubleListKey="jqId" doubleListValue="qici" doubleHeaderKey="" doubleHeaderValue="所有"
				cssClass="select_sq" theme="simple" />
				
		    <input type="button" value="查看" onclick="Figview()"/>
		</p>
	</div>
	<s:if test="%{result == 'success'}">
		<div style="text-align:center">
			<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart1URL)%>'
			    usemap="#map1" border="0">
			<map name="map1"><%=imageMap1%></map>
		</div>
	</s:if>
</s:form>

<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" language="javascript">

function Figview()
{
	var s = document.getElementsByName("jqQici")[0];
	if(-1 == s.selectedIndex)
	{
		$.messager.alert('提示','请选择一个届期查看图表','warning');
	    return;
	}
	else
	{
		var jqQici=s.options[s.selectedIndex].value;
		if(null == jqQici || '' == jqQici)
		{
			$.messager.alert('提示','请选择一个届期查看图表','warning');
	        return;
		}
		else
		{
			document.queyForm.action="<%=path%>/Statistic/ListSchoolProjectScore";
			document.queyForm.submit();
		}
	}
}
</script>
</body>
</html>

