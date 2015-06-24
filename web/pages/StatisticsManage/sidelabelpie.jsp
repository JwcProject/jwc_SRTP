<%@page import="ChartDirector.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
// The data for the pie chart
double[] data = {35, 30, 25, 7, 6};

// The labels for the pie chart
String[] labels = {"优秀", "良好", "中等", "及格", "不及格"};


// Create a PieChart object of size 560 x 270 pixels, with a golden background and a
// 1 pixel 3D border
PieChart c = new PieChart(560, 270, Chart.goldColor(), -1, 1);
c.setDefaultFonts("simhei.ttc","simhei.ttf");
// Add a title box using 15 pts Times Bold Italic font and metallic pink background
// color
c.addTitle("成绩分布", "宋体", 15 ).setBackground(Chart.metalColor(0xff9999));

// Set the center of the pie at (280, 135) and the radius to 110 pixels
c.setPieSize(280, 135, 110);

// Draw the pie in 3D with 20 pixels 3D depth
c.set3D(20);

// Use the side label layout method
c.setLabelLayout(Chart.SideLayout);

// Set the label box background color the same as the sector color, with glass
// effect, and with 5 pixels rounded corners
TextBox t = c.setLabelStyle();
t.setBackground(Chart.SameAsMainColor, Chart.Transparent, Chart.glassEffect());
t.setRoundedCorners(5);

// Set the border color of the sector the same color as the fill color. Set the line
// color of the join line to black (0x0)
c.setLineColor(Chart.SameAsMainColor, 0x000000);

// Set the start angle to 135 degrees may improve layout when there are many small
// sectors at the end of the data array (that is, data sorted in descending order).
// It is because this makes the small sectors position near the horizontal axis,
// where the text label has the least tendency to overlap. For data sorted in
// ascending order, a start angle of 45 degrees can be used instead.
c.setStartAngle(135);

// Set the pie data and the pie labels


/*
List data = (List)request.getParameter("data");
List labels = (List)request.getParameter("labels");
if(null != data && null != data.get(0) && null != labels && null != labels.get(0))
{
	c.setData(data, labels);
}
else
{
	
}
*/

c.setData(data, labels);

// Output the chart
String chart1URL = c.makeSession(request, "chart1");

// Include tool tip for the chart
String imageMap1 = c.getHTMLImageMap("", "",
    "title='{label}: US${value}K ({percent}%)'");
%>
<html>
<body style="margin:5px 0px 0px 5px">
<div style="font-size:18pt; font-family:verdana; font-weight:bold">
    成绩分布
</div>
<hr color="#000080">
<img src='<%=response.encodeURL("getchart.jsp?"+chart1URL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=imageMap1%></map>
</body>
</html>

