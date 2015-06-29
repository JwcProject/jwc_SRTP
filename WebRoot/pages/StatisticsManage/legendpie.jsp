<%@page import="ChartDirector.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
// The data for the pie chart
double[] data = {21, 18, 15, 12, 8};

// The labels for the pie chart
String[] labels = {"优秀", "良好", "中等", "及格", "不及格"};

// Create a PieChart object of size 450 x 270 pixels
PieChart c = new PieChart(450, 270);
c.setDefaultFonts("simhei.ttc","simhei.ttf");
// Set the center of the pie at (150, 100) and the radius to 80 pixels
c.setPieSize(150, 135, 100);

// add a legend box where the top left corner is at (330, 50)
c.addLegend(330, 60);

// modify the sector label format to show percentages only
c.setLabelFormat("{percent}%");

// Set the pie data and the pie labels
c.setData(data, labels);

// Use rounded edge shading, with a 1 pixel white (FFFFFF) border
c.setSectorStyle(Chart.RoundedEdgeShading, 0xffffff, 1);

// Output the chart
String chart1URL = c.makeSession(request, "chart1");

// Include tool tip for the chart
String imageMap1 = c.getHTMLImageMap("", "",
    "title='{label}: US${value}K ({percent}%)'");
%>
<html>
<body style="margin:5px 0px 0px 5px">
<div style="font-size:18pt; font-family:verdana; font-weight:bold">
    XX学院成绩分布
</div>
<hr color="#000080">
<img src='<%=response.encodeURL("getchart.jsp?"+chart1URL)%>'
    usemap="#map1" border="0">
<map name="map1"><%=imageMap1%></map>
</body>
</html>

