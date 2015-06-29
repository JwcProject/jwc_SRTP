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
	// Create a XYChart object of size 600 x 360 pixels
	XYChart c = new XYChart(600, 360);
	
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	
	// Add a title to the chart using 18pts Times Bold Italic font
	c.addTitle(title, "宋体", 18);
	
	// Set the plotarea at (60, 40) and of size 500 x 280 pixels. Use a vertical gradient
	// color from light blue (eeeeff) to deep blue (0000cc) as background. Set border and
	// grid lines to white (ffffff).
	c.setPlotArea(60, 40, 500, 280, c.linearGradientColor(60, 40, 60, 280, 0xeeeeff,
	    0x0000cc), -1, 0xffffff, 0xffffff);
	
	// Add a multi-color bar chart layer using the supplied data. Use soft lighting
	// effect with light direction from left.
	c.addBarLayer3(data).setBorderColor(Chart.Transparent, Chart.softLighting(Chart.Left));
	// Set x axis labels using the given labels
	c.xAxis().setLabels(labels);
	
	// Draw the ticks between label positions (instead of at label positions)
	c.xAxis().setTickOffset(0.5);
	
	// Add a title to the y axis with 10pts Arial Bold font
	c.yAxis().setTitle("数量", "宋体", 10);
	
	// Set axis label style to 8pts Arial Bold
	c.xAxis().setLabelStyle("宋体", 8);
	c.yAxis().setLabelStyle("宋体", 8);
	
	// Set axis line width to 2 pixels
	c.xAxis().setWidth(2);
	c.yAxis().setWidth(2);
	
	BarWithHotSpot ret = new BarWithHotSpot();
    ret.imageURL = c.makeSession(request, "chart" + index);

    // Include tool tip for the chart
    ret.imageMap = c.getHTMLImageMap("", "", "title='Year {xLabel}: US$ {value}M'");
	
	// Output the chart
	//String chart1URL = c.makeSession(request, "chart1");
	
	// Include tool tip for the chart
	//String imageMap1 = c.getHTMLImageMap("", "", "title='Year {xLabel}: US$ {value}M'");
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

