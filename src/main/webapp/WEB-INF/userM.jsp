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
                <a onclick="mysubmit('login')" href="" class="simple-text">
                    DCAA SYSTEM
                </a>
                </form>
            </div>

            <ul class="nav">
				<li>
                    <a onclick="mysubmit('login')" href="">
                        <i class="ti-comment-alt"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <c:choose>
                    <c:when test="${user.right=='2'}">
                        <li class="active">
                            <a onclick="mysubmit('####')" href="">
							<i class="ti-user"></i>
                                <p>User Management</p>
                            </a>
                        </li>
						<li>
                            <a onclick="mysubmit('####')" href="">
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
                            <a onclick="mysubmit('####')" href="">
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
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
					<div class="col-md-8 col-md-offset-2">
                        <div class="card">
                            <div class="header text-center">
                                <h3 class="title">User</h3>
                                <p class="category">For Example</p>
								<br>
                            </div>
                            <div class="content table-responsive table-full-width table-upgrade">
                                <table class="table">
                                    <thead>
                                        <th>Name</th>
                                    	<th class="text-center">Email</th>
                                    	<th class="text-center">Phone</th>
										<th>Right</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>test</td>
                                            <td>test</td>
                                            <td>test</td>
                                            <td>test</td>
                                        <%--<td><i class="fa fa-check text-success"></td>--%>
                                        </tr>
                                        <tr>
                                        	<td>${user.userName}</td>
                                        	<td>${user.email}</td>
                                        	<td>${user.phone}</td>
                                            <td>${user.rightType}</td>
											<%--<td><i class="fa fa-check text-success"></td>--%>
                                        </tr>
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
</html>
