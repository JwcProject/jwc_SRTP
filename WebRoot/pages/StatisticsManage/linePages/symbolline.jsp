<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="ChartDirector.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="com.isse.action.UnitStatisticAction" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%!
// A simple structure to represent a chart image with an image map
private static class BarWithHotSpot
{
    String imageURL;
    String imageMap;
}

BarWithHotSpot createBarChart(HttpServletRequest request, String title1, String title2,int index, String [] labels, double [] data1, double [] data2)
{
	XYChart c = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	// Add a title to the chart using 10 pt Arial font
	c.addTitle(title1+"和"+title2, "宋体", 16);
	c.setRoundedFrame(0xffffff, 20);
	// Set the plot area at (50, 25) and of size 320 x 180. Use two alternative
	// background colors (0xffffc0 and 0xffffe0)
	c.setPlotArea(70, 55, 460, 280, 0xffffc0, 0xffffe0);
	//c.setPlotArea(50, 25, 460, 280, -1, -1, Chart.Transparent, 0x000000);
	
	// Add a legend box at (55, 18) using horizontal layout. Use 8 pt Arial font, with
	// transparent background
	c.addLegend(55, 18, false, "", 9).setBackground(Chart.Transparent);
	
	// Add a title to the y-axis
	c.yAxis().setTitle("数量", "宋体", 10);
	
	// Reserve 20 pixels at the top of the y-axis for the legend box
	c.yAxis().setTopMargin(20);
	
	// Set the x axis labels
	c.xAxis().setLabels(labels);
	c.xAxis().setLabelStyle("宋体", 9);
	
	// Add a multi-bar layer with 2 data sets and 3 pixels 3D depth
	BarLayer layer = c.addBarLayer2(Chart.Side, 2);
	layer.addDataSet(data1, 0xff8080, title1);
	layer.addDataSet(data2, 0x80ff80, title2);
	
	// Output the chart
    BarWithHotSpot ret = new BarWithHotSpot();
	ret.imageURL = c.makeSession(request, "chart" + index);
	// Include tool tip for the chart
	ret.imageMap =  c.getHTMLImageMap("", "","title='{dataSetName} on {xLabel}: {value}'");
	
	return ret;
}


BarWithHotSpot createLineChart(HttpServletRequest request, String title1, String title2,int index,String[] labels, double [] data1, double [] data2)
{
	// Create a XYChart object of size 600 x 360 pixels, with a pale yellow (0xffffc0)
	// background, a black border, and 1 pixel 3D border effect.
	//XYChart c = new XYChart(600, 360, 0xffffc0, 0x000000, 1);
	XYChart c = new XYChart(600, 380, Chart.brushedSilverColor(), Chart.Transparent, 2);
	c.setDefaultFonts("simhei.ttc","simhei.ttf");
	c.addTitle(title1+"和"+title2, "宋体", 16).setMargin2(0, 0, 8, 8);
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
	layer.addDataSet(data1, 0xcf4040, title1).setDataSymbol(Chart.SquareSymbol, 7);
	
	// Add the second line. Plot the points with a 9 pixel dismond symbol
	layer.addDataSet(data2, 0x40cf40, title2).setDataSymbol(Chart.DiamondSymbol, 9);
	
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

BarWithHotSpot chart0 = createBarChart(request,"申报项目" ,"立项项目",0, labels,decSum,proSum);
BarWithHotSpot chart1 = createBarChart(request,"优秀项目", "不及格项目",1, labels,bestSum,badSum);
BarWithHotSpot chart2 = createBarChart(request,"结题项目","延期项目",2, labels,endSum,delaySum);
BarWithHotSpot chart3 = createLineChart(request,"立项率","优秀率", 3, labels,proRate,bestRate);
BarWithHotSpot chart4 = createLineChart(request,"结题率", "延期率",4, labels,endRate,delayRate);

 %>
<html>
<body style="margin:5px 0px 0px 5px">
<br>
<div style="font-size:18pt; font-family:verdana; font-weight:bold; text-align:center">
    <s:property value="%{collegeName}" />统计指标分布图
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

</div>
</body>
</html>

