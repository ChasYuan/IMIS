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
						<li class="active">
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
                        <li>
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
                    <form action="/createkeyword" method="post" id="createForm" class="form-inline">
                        <input type="hidden" name="curusername" value="${user.username}"/>
                        <div class="form-group">
                            <label for="exampleInputName2">关键词</label>
                            <input type="text" class="form-control" id="exampleInputName2" name="word" placeholder="关键词">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">维度</label>
                            <select class="form-control" id="exampleInputEmail2" name="aspectId">
                                <%--<option value="1">餐饮产品</option>--%>
                                <%--<option value="2">员工行为</option>--%>
                                <%--<option value="3">就餐环境</option>--%>
                                <%--<option value="4">价值感受</option>--%>
                                <%--<option value="5">品牌认知</option>--%>
                                <%--<option value="6">文明程度</option>--%>
                                <c:forEach items="${aspectList}" var="aspect" >
                                    <option value="${aspect.id}">${aspect.desc}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputName3">特征</label>
                            <input type="text" class="form-control" id="exampleInputName3" name="score" value="0">
                        </div>
                        <button type="button" class="btn btn-success" onclick="createkeyword()">添加</button>
                    </form>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                <p>关键词词库</p>
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
                                <h4 class="title">关键词</h4>
                                <p class="category"></p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <form action="/searchkeyword" method="post" id="searchForm"><input type="hidden" name="curusername" value="${user.username}"><input class="form-control input-sm" type="text" name="keyword" value="${searchword}"/></form>
                                <table class="table table-hover">
                                    <thead>
                                        <th class="text-center">序号</th>
                                        <th class="text-center">关键词</th>
                                    	<th class="text-center">维度</th>
                                    	<th class="text-center col-md-1">特征</th>
                                        <th class="text-center">更新</th>
                                        <th class="text-center">删除</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${keywordList}" var="keyword" varStatus="status" >
                                        <tr><form action="/updatekeyword" method="post" id="keywordForm${keyword.id}">
                                            <input type="hidden" name="id" value="${keyword.id}" />
                                            <input type="hidden" name="curusername" value="${user.username}" />
                                            <td class="text-center">${status.count}</td>
                                        	<td class="text-center"><input type="hidden" name="word" value="${keyword.word}">${keyword.word}</td>
                                        	<td class="text-center"><input type="hidden" name="aspectId" value="${keyword.aspectId}" />${keyword.desc}</td>
                                        	<td class="text-center"><input class="form-control col-md-1" type="text" name="score" size="5" value="${keyword.score}"></td>
                                            <td class="text-center"><a href="javascript:submitkeyword(${keyword.id})"><i class="fa fa-check text-success" /></a></td></form>
                                            <form action="/deletekeyword" method="post" id="deleteForm${keyword.id}"><td class="text-center">
                                                <input type="hidden" name="id" value="${keyword.id}" />
                                                <input type="hidden" name="curusername" value="${user.username}"/>
                                                <a href="javascript:deletekeyword(${keyword.id})"><i class="fa fa-times text-danger" /></a></td></form>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
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
    $(document).ready(function(){

        if(${msg == null}){

        }
        else{
            $(document).ready(function(){

                $.notify({
                    message: "${msg}"

                },{
                    type: 'success',
                    timer: 4000
                });

            });
        }
    });
</script>
<script type="text/javascript">
    function mysubmit(text) {
        $("#sidebarForm").attr("action","/"+text);
        $("#sidebarForm").submit();
    }
</script>
<script type="text/javascript">
    function submitkeyword(text) {
        $("#keywordForm"+text).submit();
    }
</script>
<script type="text/javascript">
    function deletekeyword(text) {
        if(confirm("确定要删除该关键词信息吗？")){
            $("#deleteForm"+text).submit();}
    }
</script>
<script type="text/javascript">
    function createkeyword() {
        $("#createForm").submit();
    }

</script>


</html>
