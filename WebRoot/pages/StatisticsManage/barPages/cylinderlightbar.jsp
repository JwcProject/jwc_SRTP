<%@page import="ChartDirector.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.isse.action.StatisticAction" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

	// Create a XYChart object of size 600 x 380 pixels. Set background color to brushed
	// silver, with a 2 pixel 3D border. Use rounded corners of 20 pixels radius.
	XYChart c = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	
	// Add a title to the chart using 18pts Times Bold Italic font. Set top/bottom
	// margins to 8 pixels.
	c.addTitle(title, "宋体", 18).setMargin2(0, 0, 8, 8);
	
	// Set the plotarea at (70, 55) and of size 460 x 280 pixels. Use transparent border
	// and black grid lines. Use rounded frame with radius of 20 pixels.
	c.setPlotArea(70, 55, 460, 280, -1, -1, Chart.Transparent, 0x000000);
	c.setRoundedFrame(0xffffff, 20);
	
	// Add a multi-color bar chart layer using the supplied data. Set cylinder bar shape.
	c.addBarLayer3(data).setBarShape(Chart.CircleShape);
	
	// Set the labels on the x axis.
	c.xAxis().setLabels(labels);
	
	// Show the same scale on the left and right y-axes
	c.syncYAxis();
	
	// Set the left y-axis and right y-axis title using 10pt Arial Bold font
	c.yAxis().setTitle("数量", "宋体", 10);
	//c.yAxis2().setTitle("数量", "宋体", 10);
	
	// Set y-axes to transparent
	c.yAxis().setColors(Chart.Transparent);
	c.yAxis2().setColors(Chart.Transparent);
	
	// Disable ticks on the x-axis by setting the tick color to transparent
	c.xAxis().setTickColor(Chart.Transparent);
	
	// Set the label styles of all axes to 8pt Arial Bold font
	c.xAxis().setLabelStyle("宋体", 9);
	c.yAxis().setLabelStyle("宋体", 10);
	//c.yAxis2().setLabelStyle("宋体", 8);

	BarWithHotSpot ret = new BarWithHotSpot();
    ret.imageURL = c.makeSession(request, "chart" + index , Chart.JPG);

    // Include tool tip for the chart
    ret.imageMap = c.getHTMLImageMap("", "", "title='Year {xLabel}: US$ {value}M'");
	
	return ret;
}

BarWithHotSpot createLineChart(HttpServletRequest request, String title,int index,String[] labels, double [] data)
{
	// Create a XYChart object of size 600 x 360 pixels, with a pale yellow (0xffffc0)
	// background, a black border, and 1 pixel 3D border effect.
	//XYChart c = new XYChart(600, 360, 0xffffc0, 0x000000, 1);
	XYChart c = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	c.addTitle(title, "宋体", 16).setMargin2(0, 0, 8, 8);
	// Set the plotarea at (45, 35) and of size 240 x 120 pixels, with white background.
	// Turn on both horizontal and vertical grid lines with light grey color (0xc0c0c0)
	c.setPlotArea(55, 55, 480, 240, 0xffffff, -1, -1, 0xc0c0c0, -1);
	c.setRoundedFrame(0xffffff, 20);
	//c.setPlotArea(55, 55, 460, 280, -1, -1, Chart.Transparent, 0x000000);
	// Add a legend box at (45, 12) (top of the chart) using horizontal layout and 8 pts
	// Arial font Set the background and border color to Transparent.
	c.addLegend(55, 22, false, "", 9).setBackground(Chart.Transparent);
	
	// Add a title to the chart using 9 pts Arial Bold/white font. Use a 1 x 2 bitmap
	// pattern as the background.
	//c.addTitle("Server Load (Jun 01 - Jun 07)", "Arial Bold", 9, 0xffffff).setBackground(
	   // c.patternColor(new int[]{0x004000, 0x008000}, 2));
	
	// Set the y axis label format to nn%
	c.yAxis().setLabelFormat("{value}%");
	
	// Set the labels on the x axis
	c.xAxis().setLabels(labels);
	c.xAxis().setLabelStyle("宋体", 9);
	// Add a line layer to the chart
	LineLayer layer = c.addLineLayer();
	
	// Add the first line. Plot the points with a 7 pixel square symbol
	layer.addDataSet(data, 0xcf4040, title).setDataSymbol(Chart.SquareSymbol, 7);
	
	// Enable data label on the data points. Set the label format to nn%.
	layer.setDataLabelFormat("{value|0}%");
	
	
	BarWithHotSpot ret = new BarWithHotSpot();
	ret.imageURL = c.makeSession(request, "chart" + index);
	
	// Include tool tip for the chart
	ret.imageMap = c.getHTMLImageMap("", "","title='{xLabel}: {dataSetName} {value}%'");
	
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


BarWithHotSpot chart0 = createChart(request,"申报项目" ,0, labels,decSum);
BarWithHotSpot chart1 = createChart(request, "立项项目", 1, labels,proSum);
BarWithHotSpot chart2 = createChart(request,"优秀项目", 2, labels,bestSum);
BarWithHotSpot chart3 = createChart(request,"不及格项目", 3, labels,badSum);
BarWithHotSpot chart4 = createChart(request,"结题项目",4, labels,endSum);
BarWithHotSpot chart5 = createChart(request,"延期项目", 5, labels,delaySum);
BarWithHotSpot chart6 = createLineChart(request,"立项率", 6, labels,proRate);
BarWithHotSpot chart7 = createLineChart(request,"优秀率", 7, labels,bestRate);
BarWithHotSpot chart8 = createLineChart(request,"结题率", 8, labels,endRate);
BarWithHotSpot chart9 = createLineChart(request,"延期率", 9, labels,delayRate);

%>
<html>
<body style="margin:5px 0px 0px 5px">
<br>
<div style="font-size:18pt; font-family:verdana; font-weight:bold; text-align: center">
   <s:property value="%{jqName}"/> 各学院指标统计分布图
</div>
<hr color="#000080">
<br>
<div style="text-align: center">
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart0.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart0.imageMap%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart1.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart1.imageMap%></map>
	<br>
	<br>
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart2.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart2.imageMap%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart3.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart3.imageMap%></map>
	<br>
	<br>
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart4.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart4.imageMap%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart5.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart5.imageMap%></map>
	<br>
	<br>
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart6.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart6.imageMap%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart7.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart7.imageMap%></map>
	<br>
	<br>
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart8.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart8.imageMap%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart9.imageURL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=chart9.imageMap%></map>
</div>
</body>
</html>

