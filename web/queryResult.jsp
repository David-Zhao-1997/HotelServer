<%@ page import="entity.TsdbQueryResult" %>
<%@ page import="constant.StringConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
<div id="container" style="height: 100%"></div>
<script type="text/javascript"
        src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<%--<script type="text/javascript"--%>
<%--src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>--%>
<script type="text/javascript"
        src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript">
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;

    myChart.setOption(option = {
        title: {
            text: '<%=request.getParameter("Metric")%>'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: <%=((TsdbQueryResult)request.getAttribute("tsdbQueryResult")).getTimes()%>

        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        dataZoom: [{
            startValue: '1970-01-01'
        }, {
            type: 'inside'
        }],
        visualMap: {
            <%=StringConstants.getVisualMap(request.getParameter("Metric"))%>
        },
        series: {
            name: '<%=request.getParameter("Metric")%>',
            type: 'line',
            data: <%=((TsdbQueryResult)request.getAttribute("tsdbQueryResult")).getValues()%>,
            markLine: {
                <%=StringConstants.getMarkLine(request.getParameter("Metric"))%>
            }
        }
    });
    if (option && typeof option === "object")
    {
        myChart.setOption(option, true);
    }
</script>
</body>
</html>