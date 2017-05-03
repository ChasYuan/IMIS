<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Paper Dashboard by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">

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
                <a href="#" class="simple-text">
                    DCAA SYSTEM
                </a>
            </div>

            <ul class="nav">
				<li>
                    <a href="userP.jsp">                      
                        <p>User Profile</p>
                    </a>
                </li>
				 <li class="active">
                    <a href="keyword.jsp">        
                        <p>Keyword List</p>
                    </a>
                </li>
                <li>
                    <a href="analysis.jsp">
                        <p>Data Analysis</p>
                    </a>
                </li>
                
                <li>
                    <a href="userM.jsp">
                        <p>User Management</p>
                    </a>
                </li>         
			    <li class="active-pro">
                    <a href="index.jsp">
                        <i class="ti-export"></i>
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
                    <a class="navbar-brand" href="#">Table List</a>
                </div>
                
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Keyword</h4>
                                <p class="category">Here is a example</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <th>keyword</th>
                                    	<th>aspect</th>
                                    	<th>score</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        	<td>美味</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>新鲜</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>好吃</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>味道正</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>难吃</td>
                                        	<td>餐饮产品</td>
                                        	<td>-1</td>
                                        </tr>
                                        <tr>
                                        	<td>份量足</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <div class="card card-plain">
                            <div class="header">
                                <h4 class="title">Table on Plain Background</h4>
                                <p class="category">Here is a subtitle for this table</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover">
                                    <thead>
                                        <th>keyword</th>
                                    	<th>aspect</th>
                                    	<th>score</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        	<td>美味</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>新鲜</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>好吃</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>味道正</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
                                        </tr>
                                        <tr>
                                        	<td>难吃</td>
                                        	<td>餐饮产品</td>
                                        	<td>-1</td>
                                        </tr>
                                        <tr>
                                        	<td>份量足</td>
                                        	<td>餐饮产品</td>
                                        	<td>1</td>
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
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


</html>
