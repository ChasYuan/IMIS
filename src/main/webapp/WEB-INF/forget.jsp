<%--
  Created by IntelliJ IDEA.
  User: ShirUshI
  Date: 2017/5/11
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>akinograduation</title>
    <link href="./index/style_log.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="./index/style.css">
    <link rel="stylesheet" type="text/css" href="./index/userpanel.css">
    <link rel="stylesheet" type="text/css" href="./index/jquery.ui.all.css">

</head>
<script>

</script>
<body class="login" mycollectionplug="bind">
<div class="login_m">
    <a href="/"><div class="login_logo"><img src="./index/logo.png" width="196" height="46"></div></a>
    <div class="login_boder">

        <div class="login_padding" id="login_model">
            <form action="/findPwd" method="post" >
                <h2>Email</h2>
                <label>
                    <input type="text" name="email" id="email" class="txt_input txt_input2" >
                </label>

                <h2>Phone</h2>
                <label>
                    <input type="text" name="phone" id="phone" class="txt_input" >
                </label>
                <div class="rem_sub">
                    <label>
                        <input type="submit" class="sub_button" name="button" id="button" value="Submit" style="opacity: 0.7;">
                    </label>
                </div>
            </form>
        </div>

        <!--login_padding  Sign up end-->
    </div><!--login_boder end-->
</div><!--login_m end-->
<br> <br>

</body></html>