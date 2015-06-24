<%@page import="ChartDirector.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.isse.action.StatisticAction" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%!
// A simple structure to represent a chart image with an image map
private static class BarWithHotSpot
{
    String imageURL;
    String imageMap;
}

BarWithHotSpot createChart(HttpServletRequest request, String title,int index,String[] labels, double [] data)
{	
	// Create a XYChart object of size 400 x 240 pixels.
	XYChart c = new XYChart(400, 240);
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	// Add a title to the chart using 14 pts Times Bold Italic font
	c.addTitle(title, "宋体", 14);
	
	// Set the plotarea at (45, 40) and of 300 x 160 pixels in size. Use alternating
	// light grey (f8f8f8) / white (ffffff) background.
	c.setPlotArea(45, 40, 300, 160, 0xf8f8f8, 0xffffff);
	
	// Add a multi-color bar chart layer
	BarLayer layer = c.addBarLayer3(data);
	
	// Set layer to 3D with 10 pixels 3D depth
	layer.set3D(10);
	
	// Set bar shape to circular (cylinder)
	layer.setBarShape(Chart.CircleShape);
	
	// Set the labels on the x axis.
	c.xAxis().setLabels(labels);
	
	// Add a title to the y axis
	c.yAxis().setTitle("MBytes");
	
	// Add a title to the x axis
	c.xAxis().setTitle("Work Week 25");
	
	BarWithHotSpot ret = new BarWithHotSpot();
    ret.imageURL = c.makeSession(request, "chart" + index);

    // Include tool tip for the chart
    ret.imageMap = c.getHTMLImageMap("", "", "title='{xLabel}: {value} MBytes'");
	
	return ret;
}
%>

<%
String[] labels = (String[])request.getAttribute("labels");
double[] decSum = (double[])request.getAttribute("decSum");
double[] proSum = (double[])request.getAttribute("proSum");
double[] bestSum = (double[])request.getAttribute("bestSum");
double[] badSum = (double[])request.getAttribute("badSum");
double[] endSum = (double[])request.getAttribute("endSum");
double[] delaySum = (double[])request.getAttribute("delaySum");
double[] proRate = (double[])request.getAttribute("proRate");
double[] bestRate = (double[])request.getAttribute("bestRate");
double[] endRate = (double[])request.getAttribute("endRate");
double[] delayRate = (double[])request.getAttribute("delayRate");


BarWithHotSpot chart0 = createChart(request,"申报" ,0, labels,decSum);
BarWithHotSpot chart1 = createChart(request, "立项", 1, labels,proSum);
BarWithHotSpot chart2 = createChart(request,"优秀项目", 2, labels,bestSum);
BarWithHotSpot chart3 = createChart(request,"不及格项目", 3, labels,badSum);
BarWithHotSpot chart4 = createChart(request,"结题统计",4, labels,endSum);
BarWithHotSpot chart5 = createChart(request,"延期项目统计", 5, labels,delaySum);
BarWithHotSpot chart6 = createChart(request,"立项率", 6, labels,proRate);
BarWithHotSpot chart7 = createChart(request,"优秀率", 7, labels,bestRate);
BarWithHotSpot chart8 = createChart(request,"结题率", 8, labels,endRate);
BarWithHotSpot chart9 = createChart(request,"延期率", 9, labels,delayRate);

%>
<html>
<body style="margin:5px 0px 0px 5px">
<div style="font-size:18pt; font-family:verdana; font-weight:bold">
     各学院成绩分布图
</div>
<hr color="#000080">
<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart0.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart0.imageMap%></map>


<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart1.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart1.imageMap%></map>


<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart2.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart2.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart3.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart3.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart4.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart4.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart5.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart5.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart6.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart6.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart7.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart7.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart8.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart8.imageMap%></map>

<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart9.imageURL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=chart9.imageMap%></map>
</body>
</html>

