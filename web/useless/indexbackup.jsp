<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <script src="../jquery-1.12.0.min.js"></script>
    <script src="https://cdn.bootcss.com/raphael/2.2.7/raphael.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

    <script type="text/javascript">
        var xmlhttp;
        var t1;
        var bathroomData = new Array();
        var bathroomIDs = ["r0"];
        var bathroomNames = ["温度"];


        function sendRequest()
        {
            xmlhttp.open("get", "/TemSer", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send();
        }

        function loadXMLDoc()
        {
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                {
                    document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
                    insAndDraw(xmlhttp.responseText);
                    console.log("数据更新", xmlhttp.responseText);
                }
            };
            xmlhttp.open("get", "/TemSer", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send();
            t1 = window.setInterval(sendRequest, 1000);
        }

        function remove()
        {
            window.clearInterval(t1);
        }

        function changeFreq()
        {
            window.clearInterval(t1);
            var freq_num = document.getElementById("freq").value;
            t1 = window.setInterval(sendRequest, freq_num * 1000);
        }

    </script>
</head>
<body>

<h2>实时获取温度数据Demo</h2>
<button type="button" onclick="loadXMLDoc()">开始获取数据</button>
<button type="button" onclick="remove()">停止获取数据</button>
更新速度：<select name="freq" id="freq" oninput="changeFreq()">
    <option value="1">1s</option>
    <option value="2">2s</option>
    <option value="3">3s</option>
    <option value="4">4s</option>
    <option value="5">5s</option>
    <option value="10">10s</option>
    <option value="30">30s</option>
    <option value="60">1min</option>
</select>
<div id="myDiv"></div>
<div id="chartwrapper">
    <div id="myChart" style="width: 50%;background-color:whitesmoke;"/>
</div>

<script src="drawChart-old.js"></script>
</body>
</html>