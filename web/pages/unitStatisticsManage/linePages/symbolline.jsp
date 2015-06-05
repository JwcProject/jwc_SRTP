<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="ChartDirector.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.isse.action.UnitStatisticAction" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%
// The data for the line chart
/*
double[] data0 = {60.2, 51.7, 81.3, 48.6, 56.2, 68.9, 52.8};
double[] data1 = {30.0, 32.7, 33.9, 29.5, 32.2, 28.4, 29.8};
String[] labels = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
*/
double[] proRate = (double[])request.getAttribute("proRate");
double[] bestRate = (double[])request.getAttribute("bestRate");
double[] proSum = (double[])request.getAttribute("proSum");
String[] labels = (String[])request.getAttribute("labels");

// Create a XYChart object of size 600 x 360 pixels, with a pale yellow (0xffffc0)
// background, a black border, and 1 pixel 3D border effect.
//XYChart c = new XYChart(600, 360, 0xffffc0, 0x000000, 1);
XYChart c = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
c.setDefaultFonts("simhei.ttc","simhei.ttf");
c.addTitle("立项率和优秀率", "宋体", 18).setMargin2(0, 0, 8, 8);
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
layer.addDataSet(proRate, 0xcf4040, "立项率").setDataSymbol(Chart.SquareSymbol, 7);

// Add the second line. Plot the points with a 9 pixel dismond symbol
layer.addDataSet(bestRate, 0x40cf40, "优秀率").setDataSymbol(Chart.DiamondSymbol, 9);

// Enable data label on the data points. Set the label format to nn%.
layer.setDataLabelFormat("{value|0}%");

// Output the chart
String chart1URL = c.makeSession(request, "chart1");

// Include tool tip for the chart
String imageMap1 = c.getHTMLImageMap("", "",
    "title='{xLabel}: {dataSetName} {value}%'");
    
    
    
    //柱状图
    XYChart barC = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
   // Create a XYChart object of size 600 x 380 pixels. Set background color to brushed
// silver, with a 2 pixel 3D border. Use rounded corners of 20 pixels radius.

barC.setDefaultFonts("simhei.ttc","simhei.ttf");
barC.addTitle("立项数量", "宋体", 18).setMargin2(0, 0, 8, 8);
// Set the plotarea at (70, 55) and of size 460 x 280 pixels. Use transparent border
// and black grid lines. Use rounded frame with radius of 20 pixels.
barC.setPlotArea(70, 55, 460, 280, -1, -1, Chart.Transparent, 0x000000);
barC.setRoundedFrame(0xffffff, 20);

// Add a multi-color bar chart layer using the supplied data. Set cylinder bar shape.
barC.addBarLayer3(proSum).setBarShape(Chart.CircleShape);

// Set the labels on the x axis.
barC.xAxis().setLabels(labels);

// Show the same scale on the left and right y-axes
barC.syncYAxis();

// Set the left y-axis and right y-axis title using 10pt Arial Bold font
barC.yAxis().setTitle("立项数量", "宋体", 10);
//barC.yAxis2().setTitle("USD (millions)", "宋体", 10);

// Set y-axes to transparent
barC.yAxis().setColors(Chart.Transparent);
//barC.yAxis2().setColors(Chart.Transparent);

// Disable ticks on the x-axis by setting the tick color to transparent
barC.xAxis().setTickColor(Chart.Transparent);

// Set the label styles of all axes to 8pt Arial Bold font
barC.xAxis().setLabelStyle("宋体", 9);
barC.yAxis().setLabelStyle("宋体", 9);
//barC.yAxis2().setLabelStyle("宋体", 8);

// Output the chart
String chart2URL = barC.makeSession(request, "chart2", Chart.JPG);

// Include tool tip for the chart
String imageMap2 = barC.getHTMLImageMap("", "", "title='Year {xLabel}: US$ {value}M'");
%>
<html>
<body style="margin:5px 0px 0px 5px">
<br>
<div style="font-size:18pt; font-family:verdana; font-weight:bold; text-align:center">
    <s:property value="%{#session.unit.unitName}" /> 指标统计图
</div>
<hr color="#000080">
<br>
<br>
<div style="text-align:center">
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart1URL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=imageMap1%></map>
	
	<img src='<%=response.encodeURL("../pages/StatisticsManage/getchart.jsp?"+chart2URL)%>'
	    usemap="#map1" border="0">
	<map name="map1"><%=imageMap2%></map>
</div>
</body>
</html>

