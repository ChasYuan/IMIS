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
                        <li class="active">
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
                        <li>
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
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="dropdown-toggle" data-toggle="dropdown">
                                <p>用户管理</p>
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
                            <div class="content table-responsive table-full-width">
                                <table class="table">
                                    <thead>
                                        <th>Name</th>
                                    	<th>Email</th>
                                    	<th>Phone</th>
										<th>Right</th>
                                        <th class="text-center">Update</th>
                                        <th class="text-center">Delete</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list}" var="item" varStatus="status">
                                        <tr><form action="/updateusermg" method="post" id="userMgForm${item.id}">
                                            <input type="hidden" name="userid" value="${item.id}" />
                                            <input type="hidden" name="curusername" value="${user.username}" />
                                            <td>${item.username}</td>
                                            <td><input type="text" name="email" value="${item.email}" /></td>
                                            <td><input type="text" name="phone" value="${item.phone}" /></td>
                                            <td><input type="text" size="5" name="rightid" value="${item.right}" /></td>
                                            <td class="text-center"><a href="javascript:submituser(${item.id})"><i class="fa fa-check text-success" /></a></td></form>
                                            <form action="/deleteuser" method="post" id="deleteForm${item.id}"><td class="text-center">
                                                <input type="hidden" name="userid" value="${item.id}" />
                                                <input type="hidden" name="curusername" value="${user.username}"/>
                                                <a href="javascript:deleteuser(${item.id})"><i class="fa fa-times text-danger" /></a></td></form>
                                        </tr> </c:forEach>
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
    function submituser(text) {
        $("#userMgForm"+text).submit();
    }
</script>
<script type="text/javascript">
    function deleteuser(text) {
        if(confirm("确定要删除该用户吗？")){
        $("#deleteForm"+text).submit();}
    }
</script>
</html>
