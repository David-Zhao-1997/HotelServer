<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Dashboard </title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="assets/css/demo.css">
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    <link rel="stylesheet" href="assets/css/override.css">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index.jsp">
                <img src="assets/img/logo-dark.png" alt="Klorofil Logo"
                     class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <%--<button type="button" class="btn-toggle-fullwidth"><i--%>
                <%--class="lnr lnr-arrow-left-circle"></i></button>--%>
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
                    <li><a href="index.jsp" class="active"><i
                            class="lnr lnr-home"></i>
                        <span>火灾防控</span></a></li>
                    <li><a href="air.jsp" class=""><i
                            class="lnr lnr-flag"></i>
                        <span>空气质量</span></a></li>
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
                        <p class="panel-subtitle"><%=new SimpleDateFormat("yyyy年MM月dd日").format(new Date())%>
                        </p>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-thermometer-3"></i></span>
                                    <p>
                                        <span class="number" id="tem">--</span>
                                        <span class="title">摄氏度</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-tint"></i></span>
                                    <p>
                                        <span class="number" id="hud">--</span>
                                        <span class="title">%RH</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number" id="CO2">--</span>
                                        <span class="title">二氧化碳</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number" id="CO">--</span>
                                        <span class="title">一氧化碳</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number" id="VOC">--</span>
                                        <span class="title">VOC</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number" id="PM2">--</span>
                                        <span class="title">PM2.5</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-life-buoy"></i></span>
                                    <p>
                                        <span class="number" id="MQ135">--</span>
                                        <span class="title">空气质量</span>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <center>
                            <iframe width="1000" height="500" name="chart_frame"
                                    src="index_chart_.html" frameborder="0"></iframe>
                        </center>

                        <%--<div class="col-md-9">--%>

                        <%--</div>--%>


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


<%--<script src="drawChart-old.js"></script>--%>


</body>
</html>
