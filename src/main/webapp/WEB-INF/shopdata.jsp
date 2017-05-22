<%--
  Created by IntelliJ IDEA.
  User: ShirUshI
  Date: 2017/5/19
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>akinograduation</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

        <!--
            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
        -->

        <div class="sidebar-wrapper">
            <div class="logo">
                <form method="post" id="sidebarForm">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="password" value="${user.password}">
                    <a href="javascript:mysubmit('login')" class="simple-text">
                        DCAA SYSTEM
                    </a>
                </form>
            </div>

            <ul class="nav">
                <li>
                    <a href="javascript:mysubmit('login')">
                        <i class="ti-comment-alt"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <c:choose>
                    <c:when test="${user.right=='2'}">
                        <li>
                            <a href="javascript:mysubmit('userList')">
                                <i class="ti-user"></i>
                                <p>用户管理</p>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:mysubmit('listAllKeyword')">
                                <i class="ti-view-list-alt"></i>
                                <p>关键词词库</p>
                            </a>
                        </li>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${user.right == '0'}">
                    </c:when>
                    <c:otherwise>
                        <li class="active">
                            <a href="javascript:mysubmit('showdata')">
                                <i class="ti-gallery"></i>
                                <p>数据分析</p>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="active-pro">
                    <a href="javascript:mysubmit('logout')">
                        <i class="ti-share-alt"></i>
                        <p>登出</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="javascript:mysubmit('showdata')">
                           返回 </span>
                        </button>
                    </div>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                <p>${shop.name}</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card card-plain">
                            <div class="content table-full-width">
                                <table class="table table-hover table-responsive">
                                    <thead>
                                    <th class="text-center">城市</th>
                                    <th class="text-center">区域</th>
                                    <th class="text-center">详细地址</th>
                                    <th class="text-center">类别</th>
                                    </thead>
                                    <tbody>
                                    <td class="text-center">${shop.city}</td>
                                    <td class="text-center">${shop.distinct}</td>
                                    <td class="text-center">${shop.detailAddr}</td>
                                    <td class="text-center">${shop.category}</td>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="card ">
                            <div class="content">
                                <div id="showComment" style="width: 100%;height: 400px;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <div class="content">
                                <div id="showSQ" style="width: 100%;height: 400px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="content">
                                <div id="showCommentStar" style="width: 100%;height: 400px;">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <div class="content">
                                <div id="showShopScore" style="width: 100%;height: 400px;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--<div class="row">--%>
                    <%--<div class="col-md-12">--%>
                        <%--<div class="card">--%>

                            <%--<div class="content">--%>
                                <%--<div id="showCommentQ" style="width: 1200px;height:400px;"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

            </div>
        </div>

    </div>
</div>


</body>
</body>

<!--   Core JS Files   -->
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="js/echarts.min.js"></script>

<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>


<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="js/demo.js"></script>

<script type="text/javascript">
    $(document).ready(function(){

        demo.initChartist();



    });
</script>
<script type="text/javascript">
    function mysubmit(text) {
        $("#sidebarForm").attr("action","/"+text);
        $("#sidebarForm").submit();
    }
</script>
<script type="text/javascript">

    var aChart = echarts.init(document.getElementById('showSQ'));

    // 指定图表的配置项和数据
    var aoption = {
        title: {
            text: '服务质量',
            x:'center'
        },
        tooltip: {},
        legend: {
            //               data:['销量']
        },
        xAxis: {
            data: ["餐饮产品","员工行为","就餐环境","价值感受","品牌认知","文明程度"]
        },
        yAxis: {},
        series: [{
            name: '指标',
            type: 'bar',
            data: [${showSQ1}, ${showSQ2}, ${showSQ3}, ${showSQ4}, ${showSQ5}, ${showSQ6}]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    aChart.setOption(aoption);
    // 基于准备好的dom，初始化echarts实例
    var bChart = echarts.init(document.getElementById('showShopScore'));

    // 指定图表的配置项和数据
    var boption = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: ['rgb(25, 183, 207)']
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['商家得分','用户评分']
        },
        xAxis: [
            {
                type: 'category',
                data: ['口味','环境','服务'],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '得分',
                min: 0,
                max: 10,
                interval: 2,
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '用户评分',
                min: 0,
                max: 5,
                interval: 1,
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name:'商家得分',
                type:'bar',
                data:[${shopScore1}, ${shopScore2}, ${shopScore3}]
            },
            {
                name:'用户评分',
                type:'line',
                yAxisIndex: 1,
                data:[${usrTaste}, ${usrEnvir}, ${usrService}]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    bChart.setOption(boption);

    // 基于准备好的dom，初始化echarts实例
    var cChart = echarts.init(document.getElementById('showCommentStar'));

    // 指定图表的配置项和数据
    var coption = {
        title : {
            text: '用户评分',
            x:'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['五星评分','四星评分','三星评分','两星评分','一星评分']
        },
        series: [
            {
                name:'数量',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:${showCommentStar5}, name:'五星评分'},
                    {value:${showCommentStar4}, name:'四星评分'},
                    {value:${showCommentStar3}, name:'三星评分'},
                    {value:${showCommentStar2}, name:'两星评分'},
                    {value:${showCommentStar1}, name:'一星评分'}
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    cChart.setOption(coption);

    // 基于准备好的dom，初始化echarts实例
    var dChart = echarts.init(document.getElementById('showComment'));

    // 指定图表的配置项和数据
    var doption = {
        title : {
            text: '用户评论',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['好评','中评','差评']
        },
        series : [
            {
                name: '用户评论',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${showComment1}, name:'好评'},
                    {value:${showComment2}, name:'中评'},
                    {value:${showComment3}, name:'差评'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    dChart.setOption(doption);

    setTimeout(function (){

        window.onresize = function () {

            aChart.resize();
            bChart.resize();
            cChart.resize();
            dChart.resize();
        }

    },200)
</script>
</html>