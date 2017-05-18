<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <p>User Profile</p>
                    </a>
                </li>
                <c:choose>
                    <c:when test="${user.right=='2'}">
                        <li>
                            <a href="javascript:mysubmit('userList')">
							<i class="ti-user"></i>
                                <p>User Management</p>
                            </a>
                        </li>
						<li>
                            <a href="javascript:mysubmit('listAllKeyword')">
							<i class="ti-view-list-alt"></i>
                                <p>Keyword List</p>
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
                                <p>Data Analysis</p>
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
			    <li class="active-pro">
                    <a href="/">
                        <i class="ti-share-alt"></i>
                        <p>Login Out</p>
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
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${cityNav} <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <form id="cityForm0" method="post" action="/datawithcc">
                                <input type="hidden" name="username" value="${user.username}" />
                                <input type="hidden" name="city" value="地区"/>
                                <input type="hidden" name="category" value="${categoryNav}" />
                            </form><li><a href="javascript:submitCityForm(0)">全部</a></li>
                            <li role="separator" class="divider"></li>
                            <c:forEach items="${cityList}" var="city" >
                                <form id="cityForm${city.id}" method="post" action="/datawithcc">
                                    <input type="hidden" name="username" value="${user.username}" />
                                    <input type="hidden" name="city" value="${city.city}"/>
                                    <input type="hidden" name="category" value="${categoryNav}" />
                                </form>
                                    <li><a href="javascript:submitCityForm(${city.id})">${city.city}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${categoryNav} <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <form id="categoryForm0" method="post" action="/datawithcc">
                                <input type="hidden" name="username" value="${user.username}" />
                                <input type="hidden" name="city" value="${cityNav}"/>
                                <input type="hidden" name="category" value="类别" />
                            </form>
                            <li><a href="javascript:submitCategoryForm(0)">全部</a></li>
                            <li role="separator" class="divider"></li>
                            <c:forEach items="${categoryList}" var="category" varStatus="status">
                                <form id="categoryForm${status.count}" method="post" action="/datawithcc">
                                    <input type="hidden" name="username" value="${user.username}" />
                                    <input type="hidden" name="city" value="${cityNav}"/>
                                    <input type="hidden" name="category" value="${category.category}" />
                                </form>
                                <li><a href="javascript:submitCategoryForm(${status.count})">${category.category}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                <p>数据分析</p>
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
                            <div class="header">
                                <h4 class="title">商家排行榜</h4>
                                <p class="category"></p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <div class="input-group">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">搜索</button>
                                    </div><!-- /btn-group -->
                                    <form action="/shopsearch" method="post">
                                        <input type="hidden" name="username" value="${user.username}">
                                        <input type="hidden" name="city" value="${cityNav}"/>
                                        <input type="hidden" name="category" value="${categoryNav}"/>
                                        <input type="text" name="keyword" class="form-control" aria-label="..." placeholder="商家" value="${keyword}">
                                    </form>
                                </div><!-- /input-group -->
                                <table class="table table-hover table-responsive">
                                    <thead>
                                    <th class="col-md-1">序号</th>
                                    <th>商家</th>
                                    <th class="col-md-1">城市</th>
                                    <th>区域</th>
                                    <th>地址</th>
                                    <th class="col-md-1">类别</th>
                                    <th>评分</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${shopList}" var="shop" varStatus="status" >
                                        <form  method="post" id="shopForm${shop.id}">
                                            <input type="hidden" name="id" value="${shop.id}" />
                                            <input type="hidden" name="curusername" value="${user.username}" />
                                        <tr>
                                            <td class="col-md-1">${status.count}</td>
                                            <td>${shop.name}</td>
                                            <td class="col-md-1">${shop.city}</td>
                                            <td>${shop.distinct}</td>
                                            <td>${shop.detailAddr}</td>
                                            <td class="col-md-1">${shop.category}</td>
                                            <td>口味：${shop.taste} 环境：${shop.envir} 服务：${shop.service}</td>
                                        </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <form action="/shoppage" method="post" id="pageForm"><ul class="pager">
                                    <input type="hidden" name="username" value="${user.username}" />
                                    <input type="hidden" name="city" value="${cityNav}"/>
                                    <input type="hidden" name="category" value="${categoryNav}" />
                                    <input type="hidden" name="keyword" value="${keyword}" />
                                    <li id="preButton" class="previous"><a href="javascript:submitPageFormPre(${pageIndex - 1})">&larr; Previous</a></li>
                                    <li class="text-center">第 <input type="text" id="pageForIndex" name="index" size="1" value="${pageIndex}" /> 页 / 共 ${pageTotal} 页，共 ${shopTotal} 户商家</li>
                                    <li id="nextButton" class="next"><a href="javascript:submitPageFormNext(${pageIndex + 1})">Next &rarr;</a></li>
                                </ul></form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>


</body>

<!--   Core JS Files   -->
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<%--<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>--%>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="js/demo.js"></script>
<script type="text/javascript">
    function mysubmit(text) {
        $("#sidebarForm").attr("action","/"+text);
        $("#sidebarForm").submit();
    }
</script>

<script type="text/javascript">
    function submitCityForm(id){
        $("#cityForm"+id).submit();
    }
</script>
<script type="text/javascript">
    function submitCategoryForm(id){
        $("#categoryForm"+id).submit();
    }
</script>
<script type="text/javascript">
    function submitPageFormPre(id){

        if($("#preButton").hasClass("disabled")){
            return;
        }
        else{
        $("#pageForIndex").val(id);
        $("#pageForm").submit();
        }

    }
</script>
<script type="text/javascript">
    function submitPageFormNext(id){
        if($("#nextButton").hasClass("disabled")){
            return;
        }
        else{
            $("#pageForIndex").val(id);
            $("#pageForm").submit();
        }
    }
</script>
<script type="text/javascript">
    $(document).ready(function(){
        if(${pageIndex <= 1}){
            $("#preButton").addClass("disabled");
        }
        if(${pageIndex >= pageTotal}){
            $("#nextButton").addClass("disabled");
        }
    });
</script>

</html>
