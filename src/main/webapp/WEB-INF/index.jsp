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
<div class="login_logo"><img src="./index/logo.png" width="196" height="46"></div>
<div class="login_boder">

<div class="login_padding" id="login_model">
<form action="/login" method="post" id="loginfrom">
  <h2>USERNAME</h2>
  <label>
    <input type="text" name="username" id="username" class="txt_input txt_input2" >
  </label>

  <h2>PASSWORD</h2>
  <label>
    <input type="password" name="password" id="password" class="txt_input" >
  </label>

  <p class="forgot"><a id="iforget" href="javascript:void(0);">Forgot your password?</a></p>
  <div class="rem_sub">
  <div class="rem_sub_l">
   <a href="#"><label>SIGN-UP</label></a>
   </div> 
    <a href="userP.jsp"><label>
      <input type="submit" class="sub_button" name="button" id="button" value="SIGN-IN" style="opacity: 0.7;">
    </label></a>
  </div>
</form>
</div>

<div id="forget_model" class="login_padding" style="display:none">
<br>

   <h1>Forgot password</h1>
   <br>
   <div class="forget_model_h2">(Please enter your registered email below and the system will automatically reset users’ password and send it to user’s registered email address.)</div>
    <label>
    <input type="text" id="usrmail" class="txt_input txt_input2">
   </label>

 
  <div class="rem_sub">
<div class="rem_sub_l">
   </div>
    <label>
     <input type="submit" class="sub_buttons" name="button" id="Retrievenow" value="Retrieve now" style="opacity: 0.7;">
     　　　
     <input type="submit" class="sub_button" name="button" id="denglou" value="Return" style="opacity: 0.7;">　　
    
    </label>
  </div>
</div>






<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
 <br> <br>

</body></html>