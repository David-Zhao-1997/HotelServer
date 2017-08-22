<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html lang="en">

<head>
    <title>Dashboard </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="../assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="../assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="../assets/css/demo.css">

    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../assets/img/favicon.png">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <script src="../assets/vendor/jquery/jquery.min.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="../assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
    <script src="../assets/vendor/chartist/js/chartist.min.js"></script>
    <script src="../assets/scripts/klorofil-common.js"></script>
    <script src="https://cdn.bootcss.com/raphael/2.2.7/raphael.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>

<body onload="loadXMLDoc()">
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index_old.jsp">
                <img src="../assets/img/logo-dark.png" alt="Klorofil Logo"
                     class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i
                        class="lnr lnr-arrow-left-circle"></i></button>
            </div>


            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                        </a>
                        <ul class="dropdown-menu notifications">

                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                                class="lnr lnr-question-circle"></i> <span>Help</span> <i
                                class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">

                        </ul>
                    </li>


                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="index_old.jsp" class="active"><i class="lnr lnr-home"></i>
                        <span>火灾防空</span></a></li>
                    <li><a href="elements.html" class=""><i class="lnr lnr-code"></i>
                        <span>温度调控</span></a></li>

                </ul>
            </nav>
        </div>
    </div>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <!-- OVERVIEW -->
                <div class="panel panel-headline">
                    <div class="panel-heading">
                        <h3 class="panel-title">实时概况</h3>
                        <p class="panel-subtitle">Period: Oct 14, 2016 - Oct 21, 2016</p>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-thermometer-3"></i></span>
                                    <p>
                                        <span class="number" id="tem">37</span>
                                        <span class="title">摄氏度</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-tint"></i></span>
                                    <p>
                                        <span class="number" id="hud">67</span>
                                        <span class="title">%RH</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-fire"></i></span>
                                    <p>
                                        <span class="number">正常</span>
                                        <span class="title">舱内安全</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number">正常</span>
                                        <span class="title">戒备状态</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-9">
                                <div id="chartwrapper">
                                    <div id="myChart1"
                                         style="display:inline-block;width: 400px;background-color:whitesmoke;"/>
                                    <div id="myChart2"
                                         style="display:inline-block;width: 400px;background-color:whitesmoke;"/>
                                </div>
                            </div>
                        </div>
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
                    </div>
                </div>
                <!-- END OVERVIEW -->


            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->

<script type="text/javascript">
    var xmlhttp;
    var t1;
    var temData = new Array();
    var temIDs = ["r0"];
    var temNames = ["温度"];


    var hudData = new Array();
    var hudIDs = ["r0"];
    var hudNames = ["湿度"];


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
                document.getElementById("tem").innerHTML = xmlhttp.responseText.split("&")[1];
                document.getElementById("hud").innerHTML = xmlhttp.responseText.split("&")[3];
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
<script src="drawChart-old.js"></script>


</body>

</html>
