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
				 <li>
                    <a href="keyword.jsp">        
                        <p>Keyword List</p>
                    </a>
                </li>
                <li>
                    <a href="analysis.jsp">
                        <p>Data Analysis</p>
                    </a>
                </li>
                
                <li class="active">
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
                                        	<td>Chas</td>
                                        	<td>chasyuan@qq.com</td>
                                        	<td>1111111</td>
											<td><i class="fa fa-check text-success"></td>
                                        </tr>
                                        <tr>
                                        	<td>Test</td>
                                        	<td>example@qq.com</td>
                                        	<td>111111</td>
											<td><i class="fa fa-times text-danger"></i></td>
                                        </tr>
										<!-- <tr>
											<td></td>
											<td>
												<a href="#" class="btn btn-round btn-fill btn-default disabled">Current Version</a>
											</td>
											<td>
												<a target="_blank" href="#/product/paper-dashboard-pro/?ref=pdfree-upgrade-archive" class="btn btn-round btn-fill btn-info">Upgrade to PRO</a>
											</td>
										</tr> -->
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
