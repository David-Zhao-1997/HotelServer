<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>数据库查询</title>
</head>
<body>
<form action="/TsdbQuerySer" method="post">
    睡眠仓ID：<input name="id" type="number" value="1">
    <br>
    传感器:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="Metric">
    <c:forEach items="${applicationScope.Metrics}" var="metric">
        <option value="${metric}">${metric}</option>
    </c:forEach>
</select>
    <br>
    时间范围：<input name="relativeStartValue" type="number" value="1">
    <select name="relativeStartUnit">
        <option value="months">月</option>
        <option value="years">年</option>
        <option value="days">天</option>
    </select>
    <br>
    取样频率：<input name="samplingValue" type="number" value="1">
    <select name="samplingUnit">
        <option value="minutes">分钟</option>
        <option value="hours">小时</option>
        <option value="days">天</option>
        <option value="months">月</option>
        <option value="years">年</option>
    </select>
    <br>
    显示方式：<select name="aggregator">
    <option value="Avg">平均值</option>
    <option value="Max">最大值</option>
    <option value="Min">最小值</option>
    <option value="Sum">求和</option>
</select>
    <input type="submit">
</form>
</body>
</html>
